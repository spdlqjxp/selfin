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

const Edit_fin = () => {

  const [star, setStar] = useState(5)

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

  const [prev_cover_letter, setPrev_cover_letter] = useState([
    new Qna(
        "(자유양식) 성장과정",
        "대학 시절에는 학업에서 우수한 성적을 유지하면서도 아르바이트와 봉사활동, 어학 등 다양한 활동을 소화했습니다. 특히,\n"
        + "            마케팅 광고 대행 기업에서의 인턴 경험 중에는 기업의\n"
        + "            시즌별 마케팅 기획안 작성이나 광고 촬영 일정 조율과 같은 다양한 업무를 수행했습니다. 이 중에서도 저는 온라인 상에서\n"
        + "            고객응대를 맡았습니다. 소셜미디어를 통해 들어오는\n"
        + "            고객의 문의나 불만 사항을 처리하는 역할이었는데, 매번 달라지는 상황에 유연하게 대응하기 위해 노력했습니다. 틈날 때마다\n"
        + "            매뉴얼을 읽고, 전임자의 경험을 참고하여 최상의\n"
        + "            고객 응대를 위해 노력했습니다."
    ), new Qna(
        "(자유양식) 성장과정",
        "대학 시절에는 학업에서 우수한 성적을 유지하면서도 아르바이트와 봉사활동, 어학 등 다양한 활동을 소화했습니다. 특히,\n"
        + "            마케팅 광고 대행 기업에서의 인턴 경험 중에는 기업의\n"
        + "            시즌별 마케팅 기획안 작성이나 광고 촬영 일정 조율과 같은 다양한 업무를 수행했습니다. 이 중에서도 저는 온라인 상에서\n"
        + "            고객응대를 맡았습니다. 소셜미디어를 통해 들어오는\n"
        + "            고객의 문의나 불만 사항을 처리하는 역할이었는데, 매번 달라지는 상황에 유연하게 대응하기 위해 노력했습니다. 틈날 때마다\n"
        + "            매뉴얼을 읽고, 전임자의 경험을 참고하여 최상의\n"
        + "            고객 응대를 위해 노력했습니다."
    ),
    new Qna(
        "(직장을 선택할때 중요하게 생각하는 가치/ 마이리얼트립을 선택한 이유와 입사 후 포부",
        "대학 시절에는 학업에서 우수한 성적을 유지하면서도 아르바이트와 봉사활동, 어학 등 다양한 활동을 소화했습니다. 특히,\n"
        + "            마케팅 광고 대행 기업에서의 인턴 경험 중에는 기업의\n"
        + "            시즌별 마케팅 기획안 작성이나 광고 촬영 일정 조율과 같은 다양한 업무를 수행했습니다. 이 중에서도 저는 온라인 상에서\n"
        + "            고객응대를 맡았습니다. 소셜미디어를 통해 들어오는\n"
        + "            고객의 문의나 불만 사항을 처리하는 역할이었는데, 매번 달라지는 상황에 유연하게 대응하기 위해 노력했습니다. 틈날 때마다\n"
        + "            매뉴얼을 읽고, 전임자의 경험을 참고하여 최상의 고객 응대를 위해 노력했습니다."
    )]
  )
  const [after_cover_letter, setAfter_cover_letter] = useState([
    new Qna(
        "(자유양식) 성장과정",
        "대학교에서 우수한 성적을 유지하면서도 다년간의 아르바이트와 봉사, 어학 등 많은 활동을 놓치지 않았습니다. 그중에서도 한\n"
        + "            마케팅 광고 대행 기업에서 인턴으로 근무할 당시,\n"
        + "            기업의 시즌별 마케팅 기획안을 작성하거나 광고 촬영 일정을 조력하는 등 다양한 업무를 맡았습니다. 그중에서도 저는\n"
        + "            온라인상에서 고객을 응대하는 CS 업무를 원활하게\n"
        + "            수행하였습니다. 이는 업체의 소셜미디어를 통해 들어오는 고객의 문의나 불만 사항을 처리하는 일이었는데, 저는 매번 달라지는\n"
        + "            고객분들의 불만 사항에 유연하게 대처하기 위해\n"
        + "            애썼습니다. 틈틈이 매뉴얼을 읽고, 올바른 고객 응대를 위해서 전임자분의 CS 답변 기록을 모두 찾아 읽었을 정도로 맡겨진\n"
        + "            일을 성실히 이행했습니다."
    ), new Qna(
        "(자유양식) 성장과정",
        "대학교에서 우수한 성적을 유지하면서도 다년간의 아르바이트와 봉사, 어학 등 많은 활동을 놓치지 않았습니다. 그중에서도 한\n"
        + "            마케팅 광고 대행 기업에서 인턴으로 근무할 당시,\n"
        + "            기업의 시즌별 마케팅 기획안을 작성하거나 광고 촬영 일정을 조력하는 등 다양한 업무를 맡았습니다. 그중에서도 저는\n"
        + "            온라인상에서 고객을 응대하는 CS 업무를 원활하게\n"
        + "            수행하였습니다. 이는 업체의 소셜미디어를 통해 들어오는 고객의 문의나 불만 사항을 처리하는 일이었는데, 저는 매번 달라지는\n"
        + "            고객분들의 불만 사항에 유연하게 대처하기 위해\n"
        + "            애썼습니다. 틈틈이 매뉴얼을 읽고, 올바른 고객 응대를 위해서 전임자분의 CS 답변 기록을 모두 찾아 읽었을 정도로 맡겨진\n"
        + "            일을 성실히 이행했습니다."
    ),
    new Qna(
        "(직장을 선택할때 중요하게 생각하는 가치/ 마이리얼트립을 선택한 이유와 입사 후 포부",
        "대학교에서 우수한 성적을 유지하면서도 다년간의 아르바이트와 봉사, 어학 등 많은 활동을 놓치지 않았습니다. 그중에서도 한\n"
        + "            마케팅 광고 대행 기업에서 인턴으로 근무할 당시,\n"
        + "            기업의 시즌별 마케팅 기획안을 작성하거나 광고 촬영 일정을 조력하는 등 다양한 업무를 맡았습니다. 그중에서도 저는\n"
        + "            온라인상에서 고객을 응대하는 CS 업무를 원활하게\n"
        + "            수행하였습니다. 이는 업체의 소셜미디어를 통해 들어오는 고객의 문의나 불만 사항을 처리하는 일이었는데, 저는 매번 달라지는\n"
        + "            고객분들의 불만 사항에 유연하게 대처하기 위해\n"
        + "            애썼습니다. 틈틈이 매뉴얼을 읽고, 올바른 고객 응대를 위해서 전임자분의 CS 답변 기록을 모두 찾아 읽었을 정도로 맡겨진\n"
        + "            일을 성실히 이행했습니다."
    )])

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