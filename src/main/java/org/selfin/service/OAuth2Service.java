package org.selfin.service;//package org.web.service;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.selfin.dto.UserProfileDTO;
import org.selfin.entity.UserEntity;
import org.selfin.repository.UserRepository;
import org.selfin.util.OAuthAttributes;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OAuth2Service implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    private final UserRepository userRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2UserService<OAuth2UserRequest, OAuth2User> oAuth2UserService = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = oAuth2UserService.loadUser(userRequest);

        String registrationId = userRequest.getClientRegistration().getRegistrationId();
        String userNameAttributeName = userRequest
            .getClientRegistration()
            .getProviderDetails()
            .getUserInfoEndpoint()
            .getUserNameAttributeName();

        Map<String, Object> attributes = oAuth2User.getAttributes();

        UserProfileDTO userProfile = OAuthAttributes.extract(registrationId, attributes);
        userProfile.setProvider(registrationId);

        updateOrSaveUser(userProfile);

        Map<String, Object> customAttribute =
            getCustomAttribute(registrationId, userNameAttributeName, attributes, userProfile);

        return new DefaultOAuth2User(
            Collections.singleton(new SimpleGrantedAuthority("USER")),
            customAttribute,
            userNameAttributeName);
    }

    public Map<String, Object> getCustomAttribute(String registrationId,
        String userNameAttributeName,
        Map<String, Object> attributes,
        UserProfileDTO userProfile) {
        Map<String, Object> customAttribute = new HashMap<>();

        customAttribute.put(userNameAttributeName, attributes.get(userNameAttributeName));
        customAttribute.put("provider", registrationId);
        customAttribute.put("name", userProfile.getName());
        customAttribute.put("email", userProfile.getEmail());

        return customAttribute;
    }

    public UserEntity updateOrSaveUser(UserProfileDTO userProfile) {
        UserEntity user = userRepository
            .findUserByEmailAndProvider(userProfile.getEmail(), userProfile.getProvider())
            .map(value -> value.updateUser(userProfile.getName(), userProfile.getEmail()))
            .orElse(userProfile.toEntity());

        return userRepository.save(user);
    }
}
