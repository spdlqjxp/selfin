import React, {useEffect, useState} from 'react';

import {Link} from "react-router-dom";

import '../css/MyPage.css';
import profile_man from '../images/My_Page/남자.png'
import Header from "./Header";
import server_url from "../api/Configure";
import axios from "axios";

class UserInfo {
  constructor(name, age, birth, email) {
    this.name = name;
    this.age = age;
    this.birth = birth;
    this.email = email;
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
  const [userInfo, setUserInfo] = useState(new UserInfo("", "", "", ""));

  useEffect( () => {
    axios.get(
        server_url + "/api/getuserinfo" + `?username=${localStorage.getItem('username')}`
    ).then(
        response => setUserInfo(new UserInfo(response.data.name, response.data.age, response.data.birth, response.data.email)))
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