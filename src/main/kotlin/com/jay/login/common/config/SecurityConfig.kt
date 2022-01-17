package com.jay.login.common.config

import com.jay.login.service.UserService
import org.springframework.context.annotation.Bean
import org.springframework.http.HttpMethod
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.provisioning.JdbcUserDetailsManager
import javax.sql.DataSource

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
class SecurityConfig(
    private val dataSource: DataSource,
    private val userService: UserService
) : WebSecurityConfigurerAdapter() {
    override fun configure(http: HttpSecurity?){
        if (http == null) { throw Exception("HTTP Configure Failed") }

        http
            .csrf()
                .disable()
            .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/user/register").permitAll()
                .and()
            .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/home", true)
                .usernameParameter("username")
                .passwordParameter("password")
                .permitAll()
                .and()
            .logout()
                .permitAll()
                .and()
            .authorizeRequests()
                .anyRequest()
                .authenticated()
    }

    override fun configure(auth: AuthenticationManagerBuilder?) {
        auth?.let {
            val provider = DaoAuthenticationProvider().apply {
                setPasswordEncoder(encoder())
                setUserDetailsService(userService)
            }

            it.authenticationProvider(provider)
        } ?: throw Exception("AuthenticationManagerBuilder Configure Failed")
    }

    @Bean
    override fun userDetailsService(): UserDetailsService {
        return JdbcUserDetailsManager(dataSource)
    }

    @Bean
    fun encoder(): PasswordEncoder = BCryptPasswordEncoder(10)
}