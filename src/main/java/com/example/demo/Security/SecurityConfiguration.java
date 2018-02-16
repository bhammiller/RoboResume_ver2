package com.example.demo.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private SSUserDetailsService userDetailsService;

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetailsService userDetailsServiceBean() throws Exception{
        return new SSUserDetailsService(userRepository);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/","/register","/contact","/css/**","/js/**","/addeducation","/addexp","/addskills","/addcover","/addsummary","/complete").permitAll()
                .antMatchers("/h2-console/**","/updatecontact/{id}","/process","/processeducation","/updateeducation/{id}",
                        "/deleteeducation/{id}","/processexp","/updateexp/{id}","/deleteexp/{id}","/processskill",
                        "/updateskill/{id}","/deleteskill/{id}","/processreferals","/updateref/{id}","/deleteref/{id}","/processcover",
                        "/addreferals","/updatecover/{id}","/deletecover/{id}","/processsummary","/updatesummary/{id}","/deletesummary/{id}").hasAuthority("APPLICANT")
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").successForwardUrl("/").failureForwardUrl("/").permitAll()
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/").permitAll().permitAll()
                .and()
                .httpBasic();
        http
                .csrf().disable();
        http
                .headers().frameOptions().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{

        auth.userDetailsService(userDetailsServiceBean());

    }
}

