package com.audio_mart.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
        	.authorizeHttpRequests((authorizeRequests) ->
        		authorizeRequests
				.requestMatchers("/member/register.do").permitAll() // 특정 URL 허용 설정
				.requestMatchers("member/signin.do").permitAll()
				.requestMatchers("/css/**", "/scripts/**", "/images/**", "/fonts/**").permitAll()
	            .anyRequest().authenticated()
            )
            .formLogin((formLogin) -> 
            	formLogin
            		.loginPage("/member/login.do").permitAll()
    		)
            .logout((logoutConfig) -> 
            	logoutConfig.logoutSuccessUrl("/member/logout").permitAll()
    		);
        return http.build();
    }
	

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // BCryptPasswordEncoder 사용
    }
}
