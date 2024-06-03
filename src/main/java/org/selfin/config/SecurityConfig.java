package org.selfin.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.selfin.service.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final CustomUserDetailsService customUserDetailsService;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeHttpRequests(request -> request
                .requestMatchers("/static/**", "/pages/login_page", "/index.html").permitAll()
                .requestMatchers("/api/signup").permitAll() // 기본 API 요청 허용
                .requestMatchers("/api/**").permitAll()
                .anyRequest().authenticated()
            )
            .formLogin(formLogin -> formLogin
                .loginPage("/pages/login_page")
                .defaultSuccessUrl("/pages/main", true)
                .loginProcessingUrl("/api/login")
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest request,
                        HttpServletResponse response, Authentication authentication)
                        throws IOException, ServletException {
                        System.out.println("Success");
                    }
                })
                .failureHandler(new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest request,
                        HttpServletResponse response, AuthenticationException exception)
                        throws IOException, ServletException {
                        System.out.println("Request URL : " + request.getRequestURL());
                        System.out.println("Request Mode : " + request.getMethod());
                        String requestBody = request.getReader().lines()
                            .collect(Collectors.joining(System.lineSeparator()));
                        System.out.println("Request Body: " + requestBody);

                        System.out.println("Failure: " + exception.getMessage());
                        exception.printStackTrace();
                    }
                })
            );
        return http.build();
    }
}