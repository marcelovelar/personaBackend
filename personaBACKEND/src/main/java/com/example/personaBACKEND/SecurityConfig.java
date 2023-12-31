//package com.example.personaBACKEND;
//
//import com.example.personaBACKEND.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
////@Configuration
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private UserService userDetailsService;
//
//    @Autowired
//    public BCryptPasswordEncoder bcrypt;
//
//    @Bean
//    public static BCryptPasswordEncoder passwordEncoder(){
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        return bCryptPasswordEncoder;
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth)
//        throws Exception {
//            auth.userDetailsService(userDetailsService).passwordEncoder(bcrypt);
//
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception{
//        http
//                .authorizeRequests()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .httpBasic();
//    }
//}
