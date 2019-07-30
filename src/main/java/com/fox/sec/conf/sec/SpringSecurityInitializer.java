package com.fox.sec.conf.sec;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

@Configuration
public class SpringSecurityInitializer extends AbstractSecurityWebApplicationInitializer {
    public SpringSecurityInitializer() {            //Add a ContextLoaderListener that loads the WebSecurityConfig
        super(SecurityConfig.class);
    }
}