package org.selfin.repository;

import java.util.Optional;
import org.selfin.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    UserEntity findByUsername(String username);

    Optional<UserEntity> findUserByEmailAndProvider(String email, String provider);
}
