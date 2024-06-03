package org.selfin.controller.temp;//package org.web.controller;
//
//import jakarta.validation.Valid;
//import java.time.LocalDate;
//import lombok.RequiredArgsConstructor;
//import org.domain.dto.SignUpDTO;
//import org.domain.dto.UpdateUserDTO;
//import org.domain.entity.UserEntity;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PatchMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//import org.web.service.CustomUserDetailsService;
//import org.web.service.UserService;
//
//@Controller
//@RestController
//@ResponseBody
//@RequiredArgsConstructor
//public class UserController {
//
//    private final UserService userService;
//    private final CustomUserDetailsService customUserDetailsService;
//    private final BCryptPasswordEncoder bCryptPasswordEncoder;
//
//    //회원가입
//    @PostMapping("/user/signup")
//    public ResponseEntity<String> signup(@Valid @RequestBody SignUpDTO signUpDTO) {
//        userService.signup(signUpDTO);
//        return ResponseEntity.ok("회원가입 완료"); //회원가입 성공 페이지
//    }
//
//    //개인정보 조회(마이페이지)
//    @GetMapping("/user/get-user-infor")
//    public String getCurrentUser(Authentication authentication) {
//
//        UserEntity user = customUserDetailsService.getUser(authentication.getName());
//
//        String username = user.getUsername();
//        String email = user.getEmail();
//        String name = user.getName();
//        String phone = user.getPhone();
//        LocalDate birth = user.getBirth();
//
//        System.out.println(username + " " + name + " " + email + " " + phone + " " + birth);
//
//        return "mypage";
//    }
//
//    //개인정보 수정
//    @PatchMapping("/user/patch-user-infor")
//    public ResponseEntity<UserEntity> updateUser(@ModelAttribute UpdateUserDTO updateUserDTO) {
//
//        userService.update(updateUserDTO);
//
//        return new ResponseEntity(HttpStatus.OK);
//    }
//
//}
