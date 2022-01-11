package com.jay.login.common.config

import com.jay.login.service.UserService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
class SecurityConfig(
    private val userService: UserService
) : WebSecurityConfigurerAdapter() {
    override fun configure(http: HttpSecurity?){
        if (http == null) { throw Exception() }

        http.csrf().disable()
            .authorizeRequests()
                .antMatchers("/", "/home")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .permitAll()
                .and()
            .logout()
                .permitAll()
    }

    override fun configure(auth: AuthenticationManagerBuilder?) {
        auth?.let {
            auth.userDetailsService(userService)
        } ?: super.configure(auth)
    }

    @Bean
    override fun userDetailsService(): UserDetailsService {
        return super.userDetailsService()
    }

    @Bean
    fun encoder(): PasswordEncoder = BCryptPasswordEncoder(10)
}