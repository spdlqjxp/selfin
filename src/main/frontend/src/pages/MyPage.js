import React, {useEffect, useState} from 'react';

import {Link} from "react-router-dom";

import '../css/MyPage.css';
import profile_man from '../images/My_Page/남자.png'
import Header from "./Header";
import axios from "axios";
import server_url from "../api/Configure";

class UserInfoClass {
  constructor(name, age, birth, email) {
    this.name = name;
    this.age = age;
    this.birth = birth;
    this.email = email;
  }
}

class CoverLetterClass {
  constructor(id, title, editDate, prev, after) {
    this.id = id
    this.title = title
    this.editDate = editDate
    this.prev = prev
    this.after = after
  }
}

const LeftMenu = ({currentPage, setCurrentPage}) => {
  const certificateOnClick = () => {
    setCurrentPage(0)
  }

  const editOnClick = () => {
    setCurrentPage(1)
  }

  const myCoverLetterOnClick = () => {
    setCurrentPage(2)
  }

  return (
      <div className='left_menu_container'>
        <h1>My Page</h1>
        <hr></hr>
        <div className={"left_menu"}>
          <h2>개인정보</h2>
          <div onClick={certificateOnClick}
               style={{color: currentPage === 0 ? "blue" : "black"}}>자격증 및
            어학점수
          </div>
          <h2>
            자소서
          </h2>
          <div onClick={editOnClick}
               style={{color: currentPage === 1 ? "blue" : "black"}}>첨삭 자소서
          </div>
          <div onClick={myCoverLetterOnClick} style={{
            marginBottom: "70%",
            color: currentPage === 2 ? "blue" : "black"
          }}>나의 자소서
          </div>
          <hr></hr>
          <div className="logout">
            <Link to='/home' style={{color: "black"}}>로그아웃</Link>
          </div>
        </div>
      </div>
  )
}

const CoverletterTopContents = () => {
  return (
      <div className={"edit_cover_letter_top_contents"}>
        <div>#</div>
        <div>자소서명</div>
        <div>최종 저장 날짜</div>
      </div>
  )
}

const toggleCoverLetter = (index, toggles, setToggles) => {
  const newToggle = [...toggles]
  newToggle[index] = !newToggle[index]
  setToggles(newToggle)
}

const EditCoverletterComponent = () => {
  const [coverLetters, setCoverLetters] = useState([
    new CoverLetterClass(
        0,
        "title",
        "2000-01-01",
        [{"question": "q1", "answer": "a1"}],
        [{"question": "qq1", "answer": "aa1"}]
    )
  ])

  const [coverletterToggle, setCoverletterToggle] = useState(
      Array(coverLetters.length).fill(false))

  useEffect(() => {
    axios.get(
        server_url + "/api/getmypagecoverletters"
        + `?username=${localStorage.getItem(
            'username')}`
    ).then(
        response => {
          setCoverLetters(
              response.data.map(
                  item => new CoverLetterClass(
                      item.id,
                      item.title,
                      item.editDate,
                      item.prev,
                      item.after,
                  )
              )
          )
        }
    )
  }, []);

  return (
      <div className={"edited_cover_letter_container"}>
        <div className={"edited_cover_letter_title"}>
          첨삭된 자소서
        </div>
        <hr className={"edited_cover_letter_title_hr"}/>
        <CoverletterTopContents/>
        <hr className={"edited_cover_letter_contents_divider"}/>
        {coverLetters.map(((value, index) => (
                <div className={"edit_cover_letter_contents"}
                     onClick={() => toggleCoverLetter(index, coverletterToggle,
                         setCoverletterToggle)}>
                  <div className={"edit_cover_letter_top_contents"}>
                    <div>{index}</div>
                    <div>{value.title}</div>
                    <div>{value.editDate}</div>
                  </div>
                  <div
                      className={`toggle-div ${coverletterToggle[index]
                          ? 'active'
                          : ''}`}>
                    {coverLetters[index].prev.map((value, idx) => (
                        <div className={"edited_cover_letter_toggle"}>
                          <div className={"edited_cover_letter_question"}>
                            Q. {value.question}
                          </div>
                          <div className={"edited_cover_letter_answer"}>
                            <div>
                              {value.answer}
                            </div>
                            <div>
                              {coverLetters[index].after[idx].answer}
                            </div>
                          </div>
                        </div>
                    ))}
                  </div>
                  <hr className={"edited_cover_letter_contents_divider"}/>
                </div>
            )
        ))}
      </div>
  )
}

const MyCoverletterComponent = () => {
  const [coverLetters, setCoverLetters] = useState([
    new CoverLetterClass(
        0,
        "title",
        "2000-01-01",
        [{"question": "qq1", "answer": "aa1"}],
        null
    )
  ])

  const [coverletterToggle, setCoverletterToggle] = useState(
      Array(coverLetters.length).fill(false))

  const deleteButtonClick = (id, index) => {
    axios.delete(server_url + "/api/deletecoverletter" + `?id=${id}`)
        .then(r => {
          setCoverLetters(coverLetters.filter((_, i) => i !== index))
          setCoverletterToggle(coverletterToggle.filter((_, i) => i !==index))
        })
  }

  useEffect(() => {
    axios.get(
        server_url + "/api/getmypagemycoverletters"
        + `?username=${localStorage.getItem(
            'username')}`
    ).then(
        response => {
          setCoverLetters(
              response.data.map(
                  item => new CoverLetterClass(
                      item.id,
                      item.title,
                      item.editDate,
                      item.prev,
                      item.after,
                  )
              )
          )
        }
    )
  }, []);

  return (
      <div className={"edited_cover_letter_container"}>
        <div className={"edited_cover_letter_title"}>
          나의 자소서
        </div>
        <hr className={"edited_cover_letter_title_hr"}/>
        <CoverletterTopContents/>
        <hr className={"edited_cover_letter_contents_divider"}/>
        {coverLetters.map(((value, index) => (
                <div className={"edit_cover_letter_contents"}
                     onClick={() => toggleCoverLetter(index, coverletterToggle,
                         setCoverletterToggle)}>
                  <div className={"my_cover_letter_button_info_container"}>
                    <div className={"edit_cover_letter_top_contents"}>
                      <div>{index}</div>
                      <div>{value.title}</div>
                      <div>{value.editDate}</div>
                    </div>
                    <div className={"my_cover_letter_button_container"}>
                      <Link to={"/pages/edit"} state={
                        {
                          qnas: value.prev,
                          title: value.title
                        }} className={"my_cover_letter_edit_button"}>
                        수정
                      </Link>
                      <button onClick={() => deleteButtonClick(value.id, index)}
                          style={{"background-color": "red"}}
                              className={"my_cover_letter_edit_button"}>
                        삭제
                      </button>
                    </div>
                  </div>
                  <div
                      className={`toggle-div ${coverletterToggle[index]
                          ? 'active'
                          : ''}`}>
                    {coverLetters[index].prev.map((value, idx) => (
                        <div className={"edited_cover_letter_toggle"}>
                          <div className={"edited_cover_letter_question"}>
                            Q. {value.question}
                          </div>
                          <div
                              className={"edited_cover_letter_answer my_cover_letter_div"}>
                            <div>
                              {value.answer}
                            </div>
                          </div>
                        </div>
                    ))}
                  </div>
                  <hr className={"edited_cover_letter_contents_divider"}/>
                </div>
            )
        ))}
      </div>
  )
}

const CoverLetter = ({currentPage}) => {
  const [userInfo, setUserInfo] = useState(new UserInfoClass("", "", "", ""));

  useEffect(() => {
    axios.get(
        server_url + "/api/getuserinfo" + `?username=${localStorage.getItem(
            'username')}`
    ).then(
        response => setUserInfo(
            new UserInfoClass(
                response.data.name,
                response.data.age,
                response.data.birth,
                response.data.email)
        )
    )
  }, []);

  return (
      <div className="right_menu">
        <h2>개인정보</h2>
        <div className='blue_box'>
          <img className={"profile"} src={profile_man} alt={"profileImg"}/>
          <div className={"profile_text"}>
            <div>이름 : {userInfo.name}</div>
            <div>나이 : {userInfo.age}</div>
            <div>생년월일 : {userInfo.birth}</div>
            <div>이메일 : {userInfo.email}</div>
          </div>
        </div>
        <hr className={"mypage_bluebox_coverletter_divider"}/>
        {currentPage === 0 ? <div>자격증 및 어학점수</div> : currentPage === 1 ?
            <EditCoverletterComponent/> : <MyCoverletterComponent/>}
      </div>
  )
}

const MyPage = () => {
  const [currentPage, setCurrentPage] = useState(1)
  return (
      <div className="wrapper_mypage">
        <Header/>
        <div className='mypage_middle_contents'>
          <LeftMenu currentPage={currentPage} setCurrentPage={setCurrentPage}/>
          <CoverLetter currentPage={currentPage}/>
        </div>

      </div>
  );
};

export default MyPage;