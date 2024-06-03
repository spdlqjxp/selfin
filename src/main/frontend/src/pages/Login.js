import React from "react";

import '../css/Login.css';
import server_url from "../api/Configure";
import axios from "axios";

import logo from '../images/img.png'
import naver from '../images/Naver.png'
import google from "../images/Login_Page/Google Logo.png"
import {useForm} from "react-hook-form";

const Login = () => {
  const {register, handleSubmit} = useForm();

  const naverLogin = async () => {
    try {
      const response = await axios.get(server_url + "/oauth/getNaverLoginURL");
      window.location.href = response.data;
    } catch (e) {
      console.log(e);
    }
  }

  const loginSubmit = (data) => {
    try {
      const response = axios.post(server_url + "/api/login"
          + "",
          data,
          {headers: {"Content-Type": "application/json"}});
      console.log(response);
    } catch (e) {
      console.log(e);
    }
    // localStorage.setItem("token",
    //     response.headers["Authorization"].split("")[1]);
  }
  return (
      <div className={"container"}>
        <div>
          <img className={"logo"} src={logo} alt={"Main logo"}/>
        </div>
        <div className={"login_container"}>
          <div className={"login_body"}>
            <div className={"hello"}>안녕하세요👋</div>
            <form className={"login_form"} onSubmit={handleSubmit(
                (data) => loginSubmit(data))}>
              <div>ID</div>
              <input placeholder={"Enter Your ID"}
                     className={"login_form_input"}
                     {...register("username")}
              />
              <div>Password</div>
              <input placeholder={"Enter Your Password"}
                     className={"login_form_input"}
                     type={"password"}
                     {...register("password")}
              />
              <button type={"submit"} className={"login_button box"}>로그인
              </button>
            </form>
            <div className="line-container">
              <span className="line-text">Or With</span>
            </div>

            <button className={"box google_login"}>
              <img className={"login_logo"} src={google}/>
              <text>Google 아이디로 로그인</text>
            </button>
            <button className={"box naver_login"} onClick={naverLogin}>
              <img className={"login_logo"} src={naver}/>
              <text>네이버 로그인</text>
            </button>
            <div style={{
              display: "flex",
              gap: "10%",
              width: "25vw",
              fontSize: "12px",
              justifyContent: "center",
              fontWeight: "bold"
            }}>
              <div>계정이 없으신가요?</div>
              <div>회원 가입</div>
            </div>
          </div>
        </div>
      </div>
  );
};

export default Login;