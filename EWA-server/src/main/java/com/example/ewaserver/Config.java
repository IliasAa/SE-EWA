package com.example.ewaserver;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Set;


@Configuration
@EnableWebMvc
public class Config implements WebMvcConfigurer {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


    public static final String IP_FORWARDED_FOR = "X-Forwarded-For";

    // path prefixes that will be protected by the authentication filter
    public Set<String> SECURED_PATHS =
            Set.of("/users");

    // a variable reboot signature can be used as an additional security layer in authentication tokens.
    private static final double REBOOT_CODE = 63.0427; // Math.random();

    // JWT configuration that can be adjusted from application.properties
    @Value("${jwt.issuer:private company}")
    private String issuer;

    @Value("${jwt.passphrase:This is very secret information for my private encryption key.}")
    private String passphrase;

    @Value("${jwt.duration-of-validity:1200}") // default 20 minutes;
    private int tokenDurationOfValidity;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "DELETE").
                allowedOriginPatterns("http://localhost:*").allowedHeaders(HttpHeaders.AUTHORIZATION, HttpHeaders.CONTENT_TYPE)
                .allowedHeaders(HttpHeaders.AUTHORIZATION, HttpHeaders.CONTENT_TYPE)
                .exposedHeaders(HttpHeaders.AUTHORIZATION, HttpHeaders.CONTENT_TYPE)
                .allowCredentials(true);

    }

    public String getIssuer() {
        // include a reboot sequence nr in the issuer signature
        //  such that authentication tokens can be revoked after a reboot.
        return String.format("%s-%f", this.issuer, REBOOT_CODE);
    }

    public String getPassphrase() {
        return passphrase;
    }

    public int getTokenDurationOfValidity() {
        return tokenDurationOfValidity;
    }


}
