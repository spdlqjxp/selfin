import React from 'react';

import "../css/Main.css"

import hand from '../images/Main_Page/손.png';
import s_img1 from '../images/Main_Page/연필.png';
import s_img2 from '../images/Main_Page/시계.png';
import s_img3 from '../images/Main_Page/핀.png';
import s_img4 from '../images/Main_Page/고민.png';
import middle_line from '../images/Main_Page/Middle Line.png'

import img1 from '../images/Main_Page/1.png';
import img2 from '../images/Main_Page/2.png';
import img3 from '../images/Main_Page/3.png';
import img4 from '../images/Main_Page/4.png';

import Header from "./Header";
import {Link} from "react-router-dom";

const Hand = () => {
  return (
      <div className={"hand_container"}>
        <div className={"hand_text_container"}>
          <img src={hand}/>
          <text className={"overlay-text"}>당신의 이야기를 완성해보세요.</text>
        </div>
        <Link to={"../pages/edit"} className={"hand_button"}>첨삭하러 가기</Link>
      </div>
  )
}

const MainText = () => {
  return (
      <div className={"main_text_container"}>
        <h1>
          자소서 고민 이제 그만!, 쉽고 빠른 해결책
        </h1>
        <text>
          당신의 이력서를 빛나게 만들어줄 AI 첨삭 서비스
        </text>
      </div>
  )
}

const FeatureRepresentation = ({img_source, title, text}) => {
  return (
      <div className={"feature_representation_container"}>
        <div className={"round"}>
          <img src={img_source}/>
        </div>
        <div className={"feature_representation_text_container"}>
          <h2>
            {title}
          </h2>
          <text>
            {text}
          </text>
        </div>
      </div>
  )
}

const FeatureShow = ({img_src, title, text}) => {
  return (
      <div className={"feature_show_container"}>
        <img src={img_src}/>
        <h1>{title}</h1>
        <text>{text}</text>
      </div>
  )
}

const LineLeft = () => {
  return (
      <div className={"line_side_container"}>
        <FeatureRepresentation img_source={s_img1}
                               text={"AI 기술을 활용하여 문법 오류,\n표현 미흡, 내용 구조 등을 신속\n하게 식별하여 개선 방안을 제시합니다."}
                               title={"자동 첨삭과 정학한 피드백"}/>
        <FeatureRepresentation img_source={s_img2}
                               text={"언제든지 서비스에 접속하여\n자소서를 업로드하고 첨삭을\n요청할 수 있는 24시간 서비스입니다."}
                               title={"빠른 결과 확인과 24/7 서비스"}/>
        <FeatureShow img_src={img1} title={"1.자기소개서 점수 측정 및\n자기소개서 첨삭 제공"}
                     text={"자기소개서 작성에 자신감을 불어넣고,\n최고의 결과물을 위해 도와드립니다!\n\n자기소개서 첨삭을 통해 자기소개서 작성 팁을 얻어 가세요!"}/>
        <FeatureShow img_src={img3} title={"3.자격증 및 어학점수 관리"}
                     text={["여러분의 자격증과 어학점수를 효과적으로 관리하세요!",
                       "한눈에 보기 쉽게 자신의 스펙을 확인할 수 있습니다."]}/>
      </div>
  )
}

const LineRight = () => {
  return (
      <div className={"line_side_container"}>
        <FeatureRepresentation img_source={s_img3}
                               text={"자소서 첨삭 AI는 대용량 데이터를\n기반으로 학습하므로 정확하고\n섬세한 피드백을 제공합니다."}
                               title={"정확성과 일관성"}/>
        <FeatureRepresentation img_source={s_img4}
                               text={"대용량의 합격 자소서를 기반으로\n사용자의 자소서 합격률 예측 서비스를\n제공합니다."}
                               title={"서류 합격률 예측 서비스"}/>
        <FeatureShow img_src={img2} title={"2.자기소개서 관리"}
                     text={"자신의 자기소개서를 손쉽게 저장하고,\n회사별로 구분하여 효율적으로 관리하세요!\n입사 지원 시 해당 회사에 맞는 자기소개서를\n손쉽게 찾아볼 수 있습니다!"}/>
        <FeatureShow img_src={img4} title={"4.합격 자기소개서 제공"}
                     text={"다양한 분야의 회사에 입사한 지원자들의\n합격 자기소개서를 제공합니다.\n합격 자기소개서를 한눈에 확인하고,\n자기소개서 전략을 찾아보세요!"}/>
      </div>
  )
}

const Main = () => {
  return (
      <div className={"main_container"}>
        <Header/>
        <Hand/>
        <MainText/>
        <div className={"line_container"}>

          <LineLeft/>
          <img src={middle_line}/>
          <LineRight/>
        </div>

        <Link to={"../pages/edit"}>
          첨삭하기
        </Link>

        <div className={"last_box"}/>
      </div>
  );
};

export default Main;