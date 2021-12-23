/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.sie.charity_network.configurations;

import org.sie.charity_network.handlers.LoginSuccesshandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author sie
 */
@Configuration
@EnableWebSecurity
@EnableTransactionManagement
@ComponentScan(basePackages = {
    "org.sie.charity_network.repositories",
    "org.sie.charity_network.services",
})
public class SpringSecurityConfigurations extends WebSecurityConfigurerAdapter{
    @Autowired
    private  UserDetailsService userDetailsService;
    @Autowired
    private AuthenticationSuccessHandler loginSuccessHandler;
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
         http.formLogin()
                 .loginPage("/user/login/")
                 .usernameParameter("username")
                 .passwordParameter("password")
                 .defaultSuccessUrl("/")
                 .successHandler(loginSuccessHandler)
                 .failureUrl("/user/login/?error");
         
         http.logout()
                 .logoutUrl("/user/logout/")
                 .logoutSuccessUrl("/user/loggedOut/");
         
         http.exceptionHandling()
                 .accessDeniedPage("/accessDenied/?accessDenied");
         
         http.authorizeRequests()
                 .antMatchers("/").permitAll()
                 .antMatchers("/admin/").hasRole("ADMIN")
                 .antMatchers("/post/create/").authenticated();
         http.csrf().disable();
    }
    
    @Bean
    public AuthenticationSuccessHandler loginSuccessHandler(){
        return new LoginSuccesshandler();
    }
    
}
