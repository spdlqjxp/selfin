import React, {useEffect, useState} from "react";

import '../css/Edit.css';
import Header from "./Header";
import loading_gif from "../images/Edit_Ing/loading_spinner.gif"
import Edit_fin from "./Edit_fin";
import axios from "axios";
import server_url from "../api/Configure";

class Qna {
  constructor(question, answer) {
    this.question = question;
    this.answer = answer;
  }
}

const Edit = () => {
      const [editedVisible, setEditedVisible] = useState(true)
      const [transitioning, setTransitioning] = useState(false);
      const [loading, setLoading] = useState(false)

      const [coverLetterTitle, setCoverLetterTitle] = useState("");
      const [qnaList, setQnaList] = useState([
        new Qna("", ""),
      ])

      const [after_edit, setAfter_edit] = useState()
      const [rating, setRating] = useState(0)

      const qnaListAddButtonClick = () => {
        setQnaList([
          ...qnaList,
          new Qna("", "")
        ]);
      };

      const handleTitleChange = (event) => {
        setCoverLetterTitle(event.target.value);
      }

      const handleQuestionChange = (index, event) => {
        const newQnaList = [...qnaList];
        newQnaList[index].question = event.target.value;
        setQnaList(newQnaList);
      }

      const handleAnswerChange = (index, event) => {
        const newQnaList = [...qnaList];
        newQnaList[index].answer = event.target.value;
        setQnaList(newQnaList);
      }

      const editButtonClick = () => {
        setLoading(true)
        const data = {"title": coverLetterTitle, "qna": qnaList}
        axios.post(server_url + "/api/edit",
            JSON.stringify(data),
            {headers: {"Content-Type": "application/json"}})
        .then(response => {
          if (response.status === 200) {
            setAfter_edit(
                response.data.qna.map((item) => Object.assign(new Qna(), item)))
            setRating(response.data.rating)

            setLoading(false)
            setTransitioning(true);
            setTimeout(() => {
              setEditedVisible(!editedVisible);
              setTransitioning(false);
            }, 1000); // 0.5초 후 화면 전환
          }
        })
      }

      useEffect(() => {
        if (!transitioning) {
          setTimeout(() => {
            setTransitioning(false);
          }, 1000); // 0.5초 후 페이드 인 완료
        }
      }, [transitioning]);

      const editPage = () => {
        return (
            <div className={"edit_container"}>
              <Header/>
              {loading ? <div className={"loading_overlay"}><img
                      className={"loading_gif"} src={loading_gif}/></div> :
                  <div/>}
              <div className={"contents_container"}>
                <div className={"edit_components"}>
                  <div className={"edit_component"}>
                    <div>Q. 자소서명</div>
                    <input className={"small_input_box"} value={coverLetterTitle}
                           placeholder={"내용을 입력하세요 Ex) 대한항공 지원서"}
                           onChange={handleTitleChange}
                    />
                  </div>

                  {qnaList.map((qna, index) => (
                      <div>
                        <div className={"edit_component"}>
                          <div>Q. 자소서 문항을 입력하세요.</div>
                          <input className={"small_input_box"} value={qna.question}
                                 placeholder={"내용을 입력하세요."}
                                 onChange={(event) => handleQuestionChange(index,
                                     event)}
                          />
                        </div>
                        <div className={"edit_component"}>
                          <div>Q. 자소서 문항 내용을 입력하세요. (500자 이내)</div>
                          <textarea className={"big_input_box"} value={qna.answer}
                                    placeholder={"내용을 입력하세요."}
                                    onChange={(event) => handleAnswerChange(index,
                                        event)}
                          />
                        </div>
                      </div>
                  ))}
                </div>

                <div className={"circle-button"} onClick={qnaListAddButtonClick}>
                  +
                </div>
                <button onClick={editButtonClick}
                        className={"API_edit"}>첨삭하기
                </button>
              </div>
            </div>
        )
      }

      return (
          <div className={`fade ${transitioning ? 'fade-out' : 'fade-in'}`}>
            {editedVisible ? editPage() :
                <Edit_fin rating={rating}
                          before_edit={qnaList}
                          after_edit={after_edit}/>}
          </div>
      )
    }
;

export default Edit;