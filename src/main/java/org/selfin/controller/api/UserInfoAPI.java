package org.selfin.controller.api;

import lombok.RequiredArgsConstructor;
import org.selfin.dto.UserInfoDTO;
import org.selfin.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserInfoAPI {

    private final UserService userService;

    @GetMapping("/getuserinfo")
    public ResponseEntity<UserInfoDTO> getUserInfo(@RequestParam String username) {
        UserInfoDTO userInfoDTO = userService.getUserInfo(username);

        if (userInfoDTO == null) {  // 인증 부분을 거치면 필요가 없는 조건문
            return ResponseEntity.badRequest().body(null);
        }

        return ResponseEntity.ok(userInfoDTO);
    }
}
