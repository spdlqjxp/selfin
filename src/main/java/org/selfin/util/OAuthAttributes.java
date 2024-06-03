package org.selfin.util;


import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import org.selfin.dto.UserProfileDTO;

public enum OAuthAttributes {

    GOOGLE("google", (attribute) -> {
        UserProfileDTO userProfile = new UserProfileDTO();
        userProfile.setName((String) attribute.get("name"));
        userProfile.setEmail((String) attribute.get("email"));
        return userProfile;
    }),

    NAVER("naver", (attribute) -> {
        UserProfileDTO userProfile = new UserProfileDTO();
        Map<String, String> responseValue = (Map<String, String>) attribute.get("response");
        userProfile.setName(responseValue.get("name"));
        userProfile.setEmail(responseValue.get("email"));
        return userProfile;
    });

    private final String registrationId; // Service ID (e.g., google, naver)
    private final Function<Map<String, Object>, UserProfileDTO> attributeExtractor; // Function to extract user profile from attributes

    OAuthAttributes(String registrationId,
        Function<Map<String, Object>, UserProfileDTO> attributeExtractor) {
        this.registrationId = registrationId;
        this.attributeExtractor = attributeExtractor;
    }

    public static UserProfileDTO extract(String registrationId, Map<String, Object> attributes) {
        return Arrays.stream(values())
            .filter(value -> registrationId.equals(value.registrationId))
            .findFirst()
            .orElseThrow(IllegalArgumentException::new)
            .attributeExtractor.apply(attributes);
    }
}
