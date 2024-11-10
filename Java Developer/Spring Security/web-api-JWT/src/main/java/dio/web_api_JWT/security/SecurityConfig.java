package dio.web_api_JWT.security;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "security.config")
public class SecurityConfig {
    public static String PREFIX;
    public static String KEY;
    public static Long EXPIRATION;

    public void setPREFIX(String prefix){
        PREFIX = prefix;
    }

    public void setKEY(String key){
        KEY = key;
    }

    public void setEXPIRATION(Long expiration){
        EXPIRATION = expiration;
    }
}
