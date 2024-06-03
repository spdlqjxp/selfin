package org.selfin.controller.temp;//package org.web.controller;
//
//import java.util.Map;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.security.oauth2.core.user.OAuth2User;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/oauth")
//public class OauthController {
//
//    @GetMapping("/loginfo")
//    public String getJson(@AuthenticationPrincipal OAuth2User oAuth2User) {
//        // OAuth2User에서 사용자의 속성을 가져옴
//        Map<String, Object> attributes = oAuth2User.getAttributes();
//
//        // 속성을 문자열로 반환
//        return attributes.toString();
//    }
//
//    @GetMapping("/getNaverLoginURL")
//    public ResponseEntity<String> getNaverLoginURL() {
//        return ResponseEntity.ok(
//            "https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=6kA_2LLjDen4yDHNBtxQ&redirect_uri=http://localhost:80/main&state=state");
//    }
//}
