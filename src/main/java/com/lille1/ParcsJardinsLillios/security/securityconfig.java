package com.lille1.ParcsJardinsLillios.security;


import com.lille1.ParcsJardinsLillios.DAO.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Configuration
@EnableWebSecurity
public class securityconfig extends WebSecurityConfigurerAdapter {
@Autowired
CustomUserDetails customUserDetails;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(customUserDetails);
        //auth.inMemoryAuthentication().withUser("admin").password("password").roles("ADMIN");


    }


    @Override
   protected void configure(HttpSecurity http)throws Exception{
        http.csrf().disable();

        //http.formLogin();

        http.formLogin().loginPage("/login");
        http.authorizeRequests().antMatchers("/",
                "/NouveauCommentaire",
                "/NouveauCommentaire/delete",
                "/NouveauCommentaire/confirmer",
                "/AjouterPJ",
                "/operationPJ",
                "/operationPJ/delete",
                "/operationPJ/update").hasRole("ADMIN");


    }
}
