import React, {useState} from "react";

import '../css/Edit_fin.css';
import Header from "./Header";

import star0 from "../images/Edit_Fin/0점.png"
import star1 from "../images/Edit_Fin/1점.png"
import star2 from "../images/Edit_Fin/2점.png"
import star3 from "../images/Edit_Fin/3점.png"
import star4 from "../images/Edit_Fin/4점.png"
import star5 from "../images/Edit_Fin/5점.png"

class Qna {
  constructor(question, answer) {
    this.question = question
    this.answer = answer
  }
}

const Edit_fin = ({rating, before_edit, after_edit}) => {

  const [star, setStar] = useState(rating)

  const starDiv = () => {
    switch (star) {
      case 0:
        return <img className={"star_point"} src={star0} alt={"star0"}/>
      case 1:
        return <img className={"star_point"} src={star1} alt={"star0"}/>
      case 2:
        return <img className={"star_point"} src={star2} alt={"star0"}/>
      case 3:
        return <img className={"star_point"} src={star3} alt={"star0"}/>
      case 4:
        return <img className={"star_point"} src={star4} alt={"star0"}/>
      case 5:
        return <img className={"star_point"} src={star5} alt={"star0"}/>
    }
  }

  const [prev_cover_letter, setPrev_cover_letter] = useState(before_edit)
  const [after_cover_letter, setAfter_cover_letter] = useState(after_edit)

  return (
      <div className="wrapper_edit_fin">
        <Header/>
        <div className='edit_fin_middle_contents'>
          {starDiv()}

          <div className={"edit_prev_after"} key={0}>
            {prev_cover_letter.map((qna, index) => (
                <div style={{width: "100%", height: "100%"}}>
                  <text className={"title_q"}>Q.</text>
                  <text
                      className={"title"}>{qna.question}
                  </text>
                  <div className={"prev_after_container"}>
                    <div className={"text_box"}>
                      {qna.answer}
                    </div>
                    <div className={"text_box"}>
                      {after_cover_letter[index].answer}
                    </div>
                  </div>
                </div>
            ))}
          </div>

          <button className={"re_edit_btn"}>
            다시 첨삭하기
          </button>
        </div>
      </div>
  )
};

export default Edit_fin;