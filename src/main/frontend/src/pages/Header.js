import logo from "../images/Logo.png";
import React from "react";
import {Link, useLocation} from "react-router-dom";
import "../css/Header.css";

const Header = () => {
  const path = useLocation().pathname;

  return (
      <div className={"header_container"}>
        <img src={logo} className={"header_logo"}></img>
        <div className={"header_links"}>
          <Link to={"/pages/main"}
                style={{color: path === "/pages/main" ? 'blue' : 'black'}}>Home</Link>
          <Link to={"/pages/edit"}
                style={{color: path === "/pages/edit" ? 'blue' : 'black'}}>첨삭하기</Link>
          <Link to={"/pages/passed_coverletter"} style={{
            color: path === "/pages/passed_coverletter" ? 'blue' : 'black'
          }}>합격
            자소서</Link>
          <Link to={"/pages/mypage"}
                style={{color: path === "/pages/mypage" ? 'blue' : 'black'}}>마이
            페이지</Link>
        </div>
      </div>
  )
}

export default Header;