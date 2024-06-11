package com.atermon.website.Configurations;

import com.atermon.website.Services.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Autowired
    private MyUserDetailsService myUserDetailsService;
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                (requests) -> requests
                        .requestMatchers("/", "/css/**", "/images/**"
                                        , "/layouts/**","/login","/signup","/register"
                                ,"/registration","/candidates","/jobs/**"
                                ,"/staff","/contact", "/about").permitAll()
                        .requestMatchers("/applyCv").hasAnyRole("USER","ADMIN")
                        .requestMatchers("/admin").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .formLogin(
                        formLogin -> formLogin
                                .loginPage("/login").permitAll()
                                .defaultSuccessUrl("/applyCv" ,true)// Custom login page
                )
                .logout(
                        logout -> logout
                                .logoutSuccessUrl("/login").permitAll());
        return http.build();
    }
}
