package org.selfin.service;

import org.selfin.dto.CustomUserDetails;
import org.selfin.entity.UserEntity;
import org.selfin.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("loadUserByUsername");
        System.out.println("User name : " + username);
        UserEntity userentity = userRepository.findByUsername(username);
        System.out.println("UserEntity : " + userentity);

        if (userentity != null) {
            //userDetails에 담아서 return 하면 AuthenticationManager가 검증 함
            return new CustomUserDetails(userentity);
        }

        return null;
    }

    public UserEntity getUser(String username) {
        System.out.println("getUser");
        System.out.println("User name : " + username);
        return userRepository.findByUsername(username);
    }
}
