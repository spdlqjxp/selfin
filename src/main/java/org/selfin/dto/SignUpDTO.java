package org.selfin.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter
public class SignUpDTO {

    @NotEmpty(message = "아이디를 입력해 주세요.")
    private String username; //userId 대신

    @NotEmpty(message = "비밀번호를 입력해주세요.")
//    @Length(min=8, max=16, message="비밀번호는 8자 이상, 16자 이하로 입력해주세요.")
    private String password;

    @NotEmpty(message = "비밀번호를 입력해주세요.")
    private String passwordCheck;

    @NotEmpty(message = "회원 이름을 입력해주세요.")
    private String name;

    @NotEmpty(message = "이메일을 임력해주세요.")
    @Email(message = "이메일 형식이 올바르지 않습니다.")
    private String email;

    @NotEmpty(message = "핸드폰 번호를 입력해주세요.")
    private String phone;

    @DateTimeFormat(pattern = "yyyy-MM-dd", iso = DateTimeFormat.ISO.DATE)
    private LocalDate birth;

    private String role;
}
