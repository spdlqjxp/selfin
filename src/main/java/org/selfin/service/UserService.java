package org.selfin.service;

import java.time.LocalDate;
import lombok.RequiredArgsConstructor;
import org.selfin.dto.LoginDTO;
import org.selfin.dto.SignUpDTO;
import org.selfin.entity.UserEntity;
import org.selfin.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    //회원가입
    public void signup(SignUpDTO signUpDTO) {

        String username = signUpDTO.getUsername();
        String password = signUpDTO.getPassword();
        String passwordCheck = signUpDTO.getPasswordCheck();
        String email = signUpDTO.getEmail();
        String name = signUpDTO.getName();
        String phone = signUpDTO.getPhone();
        LocalDate birth = signUpDTO.getBirth();

        //존재하는 아이디인지 확인
        if (userRepository.existsByUsername(username)) {
            throw new IllegalArgumentException("이미 존재하는 아이디입니다.");
        }
        //존재하는 이메일인지 확인
        if (userRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("이미 존재하는 이메일 주소입니다.");
        }

        if (passwordCheck == null || password == null) {
            throw new IllegalArgumentException("password, and password check must not be null");
        }

        if (!passwordCheck.equals(password)) {
            throw new IllegalArgumentException("비밀번호가 올바르지 않습니다.");
        }

        UserEntity data = UserEntity.builder()
            .username(username)
            .name(name)
            .email(email)
            .password(password) // 추후에 암호화 필요
            .passwordCheck(passwordCheck) // 추후에 암호화 필요
            .phone(phone)
            .birth(birth)
            .role("USER")
            .provider("basic")
            .build();

        userRepository.save(data);

    }

    // 로그인
    public LoginDTO login(@RequestBody LoginDTO loginDTO) {
        UserEntity user = userRepository.findByUsername(loginDTO.getUsername());
        if (user == null) {
            throw new RuntimeException("존재하지 않는 아이디입니다.");
        }

        // 비밀번호가 일치하지 않을때
        if (!loginDTO.getPassword().equals(user.getPassword())){
            throw new RuntimeException("비밀번호가 올바르지 않습니다.");
        }

        return loginDTO;
    }
}
