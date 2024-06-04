package org.selfin.controller.api;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.selfin.dto.LoginDTO;
import org.selfin.dto.SignUpDTO;
import org.selfin.repository.UserRepository;
import org.selfin.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class LoginAPI {

    private final UserService userService;
    private final UserRepository userRepository;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@Valid @RequestBody SignUpDTO signUpDTO) {
        userService.signup(signUpDTO);
        return ResponseEntity.ok("회원가입 완료");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) {
        // login에 성공하면 front에서 username을 저장해놓고, 다른 api 요청할 때마다 requestparam에 입력해서 사용
        // 하나의 쿠키처럼 username 사용
        try {
            userService.login(loginDTO);
            return ResponseEntity.ok(
                "/pages/main"); // redirection을 be에서 처리해야할거 같음, 현재는 Fe에서 redirection 중
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().body("로그인 실패");
    }
}