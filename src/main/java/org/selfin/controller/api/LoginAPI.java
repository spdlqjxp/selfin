package org.selfin.controller.api;

import jakarta.validation.Valid;
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
public class LoginAPI {

    private final UserService userService;
    private final UserRepository userRepository;

    public LoginAPI(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@Valid @RequestBody SignUpDTO signUpDTO) {
        userService.signup(signUpDTO);
        return ResponseEntity.ok("회원가입 완료");
    }
}