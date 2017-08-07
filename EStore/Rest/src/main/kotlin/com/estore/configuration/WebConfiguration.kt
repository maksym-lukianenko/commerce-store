package com.estore.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.context.request.RequestContextListener

@Configuration
class WebConfiguration {

    @Bean
    fun requestContextListener(): RequestContextListener = RequestContextListener()
}