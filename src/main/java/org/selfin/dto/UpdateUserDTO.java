package org.selfin.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class UpdateUserDTO {
    //수정된 유저 정보

    private String name;
    private String email;
    private String passwordNow;
    private String password;
    private String passwordCheck;
    private String phone;
    private LocalDate birth;

}
