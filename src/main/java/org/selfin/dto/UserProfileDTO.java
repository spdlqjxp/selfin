package org.selfin.dto;

import lombok.Getter;
import lombok.Setter;
import org.selfin.entity.UserEntity;

@Getter
@Setter
public class UserProfileDTO {

    private String name;
    private String email;
    private String provider;

    public UserEntity toEntity() {
        return UserEntity.builder()
            .name(this.name)
            .email(this.email)
            .provider(this.provider)
            .build();
    }
}
