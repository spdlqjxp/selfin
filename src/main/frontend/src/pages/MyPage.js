import React, {useEffect, useState} from 'react';

import {Link} from "react-router-dom";

import '../css/MyPage.css';
import profile_man from '../images/My_Page/남자.png'
import Header from "./Header";
import axios from "axios";
import server_url from "../api/Configure";

class UserInfo {
  constructor(name, age, birth, email) {
    this.name = name;
    this.age = age;
    this.birth = birth;
    this.email = email;
  }
}

class CoverLetter {
  constructor(title, editDate, prev, after, toggle) {
    this.title = title
    this.editDate = editDate
    this.prev = prev
    this.after = after
    this.toggle = false
  }
}

const LeftMenu = () => {
  return (
      <div className='left_menu_container'>
        <h1>My Page</h1>
        <hr></hr>
        <div className={"left_menu"}>
          <h2>개인정보</h2>
          <Link to={""}>자격증 및 어학점수</Link>
          <h2>
            자소서
          </h2>
          <Link to='' style={{marginBottom: "70%"}}>나의 자소서</Link>
          <hr></hr>
          <div className="logout">
            <Link to='/home' style={{color: "black"}}>로그아웃</Link>
          </div>
        </div>
      </div>
  )
}

const CoverLetter = () => {
  const [userInfo, setUserInfo] = useState();
  const [coverLetters, setCove]
  const toggleCoverLetter = (index) => {
    const newToggle = [...coverletterToggle]
    newToggle[index] = !newToggle[index]
    setCoverletterToggle(newToggle)
  }

  useEffect(() => {
    axios.get(
        server_url + "/api/getuserinfo" + `?username=${localStorage.getItem(
            'username')}`
    ).then(
        response => setUserInfo(
            new UserInfo(response.data.name, response.data.age,
                response.data.birth, response.data.email)))
  }, []);

  useEffect(() => {
    axios.get(
        server_url + "/api/getcoverletter" + `?username=${localStorage.getItem(
            'username')}`
    ).then(
        response => {
          setCoverletters(
              response.data.map(
                  item => new Coverletter(item.index, item.title,
                      item.edited_date)))
          setCoverletterToggle(
              Array(coverletters.length).fill(false)
          )
        }
    )
  }, []);

  useEffect(() => {
    axios.get(server_url + "/api/getprevaftercoverletter"
        + `?username=${localStorage.getItem(
            'username')}`
    ).then(
        response => {
          response.data.map((value, index) => {
                setPrevCoverLetter(prev => (
                    [...prev, value.prev.map(
                        item => new Qna(item.question, item.answer))]
                ))
                setAfterCoverLetter(after => [
                  ...after, value.after.map(
                      item => new Qna(item.question, item.answer)
                  )
                ])
              }
          )
        }
    )
  }, []);

  return (
      <div className="right_menu">
        <h2>개인정보</h2>
        <div className='blue_box'>
          <img className={"profile"} src={profile_man}/>
          <div className={"profile_text"}>
            <div>이름 : {userInfo.name}</div>
            <div>나이 : {userInfo.age}</div>
            <div>생년월일 : {userInfo.birth}</div>
            <div>이메일 : {userInfo.email}</div>
          </div>
        </div>
        <hr className={"mypage_bluebox_coverletter_divider"}/>

        <div className={"edited_cover_letter_container"}>
          <div className={"edited_cover_letter_title"}>
            첨삭된 자소서
          </div>
          <hr className={"edited_cover_letter_title_hr"}/>
          <div className={"edit_cover_letter_top_contents"}>
            <div>#</div>
            <div>자소서명</div>
            <div>최종 저장 날짜</div>
          </div>
          <hr className={"edited_cover_letter_contents_divider"}/>
          {coverletters.map(((value, index) => (
                  <div className={"edit_cover_letter_contents"}
                       onClick={() => toggleCoverLetter(index)}>
                    <div className={"edit_cover_letter_top_contents"}>
                      <div>{value.index}</div>
                      <div>{value.title}</div>
                      <div>{value.edited_date}</div>
                    </div>
                    <div
                        className={`toggle-div ${coverletterToggle[index]
                            ? 'active'
                            : ''}`}>
                      {prevCoverLetter[index].map((value, idx) => (
                          <div className={"edited_cover_letter_toggle"}>
                            <div className={"edited_cover_letter_question"}>
                              Q. {value.question}
                            </div>
                            <div className={"edited_cover_letter_answer"}>
                              <div>
                                {value.answer}
                              </div>
                              <div>
                                {afterCoverLetter[index][idx].answer}
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
      </div>
  )
}

const MyPage = () => {
  return (
      <div className="wrapper_mypage">
        <Header/>
        <div className='mypage_middle_contents'>
          <LeftMenu/>
          <CoverLetter/>
        </div>

      </div>
  );
};

export default MyPage;