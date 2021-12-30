package com.jay.login.common.config

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class MvcConfig : WebMvcConfigurer {
    override fun addViewControllers(registry: ViewControllerRegistry) {
        registry.apply {
            addViewController("/home").setViewName("home")
            addViewController("/").setViewName("home")
            addViewController("/login").setViewName("login")
        }
    }
}