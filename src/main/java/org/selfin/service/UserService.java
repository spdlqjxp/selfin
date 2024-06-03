package org.selfin.service;//package org.web.service;

import jakarta.transaction.Transactional;
import java.time.LocalDate;
import lombok.RequiredArgsConstructor;
import org.selfin.config.JWTUtil;
import org.selfin.dto.LoginDTO;
import org.selfin.dto.SignUpDTO;
import org.selfin.dto.TokenDTO;
import org.selfin.dto.UpdateUserDTO;
import org.selfin.entity.UserEntity;
import org.selfin.repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final JWTUtil jwtUtil;
    private final CustomUserDetailsService customUserDetailsService;

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
            .password(bCryptPasswordEncoder.encode(password))
            .passwordCheck(bCryptPasswordEncoder.encode(passwordCheck))
            .phone(phone)
            .birth(birth)
            .role("USER")
            .provider("basic")
            .build();

        userRepository.save(data);

    }

    // 로그인
    public TokenDTO login(@RequestBody LoginDTO loginDTO) {
        UserEntity user = userRepository.findByUsername(loginDTO.getUsername());
        if (user == null) {
            throw new RuntimeException("존재하지 않는 아이디입니다.");
        }

        if (!bCryptPasswordEncoder.matches(loginDTO.getPassword(), user.getPassword())) {
            throw new RuntimeException("비밀번호가 올바르지 않습니다.");
        }

        return new TokenDTO(jwtUtil.createJwt(user.getUsername(), user.getRole()));
    }

    //개인정보 수정
    @Transactional
    public void update(UpdateUserDTO updateUserDTO) {

        String username = SecurityContextHolder.getContext().getAuthentication()
            .getName(); //username
        UserEntity user = userRepository.findByUsername(username);

        System.out.println(user.getName());

        if (user == null) {
            throw new RuntimeException("올바른 회원이 아닙니다.");
        }

        String passwordNow = updateUserDTO.getPasswordNow();
        String password = updateUserDTO.getPassword();
        String passwordCheck = updateUserDTO.getPasswordCheck();
        String email = updateUserDTO.getEmail();
        String name = updateUserDTO.getName();
        String phone = updateUserDTO.getPhone();
        LocalDate birth = updateUserDTO.getBirth();

        if (user.getEmail().equals(email)) {
            //이메일 안바꿈.
        } else if (userRepository.existsByEmail(email)) { //이메일 중복 확인
            throw new IllegalArgumentException("이미 사용중인 이메일 주소입니다.");
        }

        //원래 비밀번호를 아는지 확인
        if (!bCryptPasswordEncoder.matches(passwordNow, user.getPassword())) {
            throw new IllegalArgumentException("현재 비밀번호가 올바르지 않습니다.");
        }

        //새로 설정한 비밀번호 맞는지 확인
        if (!passwordCheck.equals(password)) {
            throw new IllegalArgumentException("새로운 비밀번호가 올바르지 않습니다.");
        }

        user.setName(name);
        user.setEmail(email);
        user.setPhone(phone);
        user.setPassword(bCryptPasswordEncoder.encode(password));
        user.setPasswordCheck(bCryptPasswordEncoder.encode(passwordCheck));
        user.setBirth(birth);

        userRepository.save(user);

    }

}
