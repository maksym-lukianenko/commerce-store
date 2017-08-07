package com.estore.context.factory

import com.estore.context.StoreRequestContext
import com.estore.user.entity.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Scope
import org.springframework.context.annotation.ScopedProxyMode
import org.springframework.stereotype.Component
import org.springframework.web.context.WebApplicationContext
import javax.servlet.http.HttpServletRequest

@Component
class StoreRequestContextFactory {

    @Autowired
    lateinit var request: HttpServletRequest

    @Bean
    @Scope(WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.INTERFACES)
    fun createContext(): StoreRequestContext {
        //TODO("Replace mock user")
        return StoreRequestContext(request.locale, User())
    }
}
