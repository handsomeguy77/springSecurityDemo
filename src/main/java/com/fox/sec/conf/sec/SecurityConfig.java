package com.fox.sec.conf.sec;

import com.fox.sec.service.AuthService;
import com.fox.sec.service.Impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.DigestUtils;

import java.util.*;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthService authService;

    @Bean
    UserDetailsService getUserdetailService(){
        return new UserDetailsServiceImpl();
    }
    @Bean
    BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(){
            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                return encodedPassword.equals(DigestUtils.md5DigestAsHex(rawPassword.toString().getBytes()));//MD5密文验证
            }
        };
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(getUserdetailService()).passwordEncoder(passwordEncoder());
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        Map<String, String> urlRoles = authService.getAllUrl();     //获取所有的url，主要是获取该url对应的Roles（角色）
        for (String key : urlRoles.keySet()) {
            http.authorizeRequests().antMatchers(key).hasAnyRole(urlRoles.get(key));
        }

        http.headers().frameOptions().disable();
        http.authorizeRequests()
                .anyRequest().authenticated() //任何请求,登录后可以访问
                .antMatchers("/login").permitAll()
                .and().formLogin().loginPage("/login").defaultSuccessUrl("/index").usernameParameter("username")
                .passwordParameter("password").failureUrl("/none").permitAll()
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/login").invalidateHttpSession(true).permitAll()
                .and().csrf().disable();
    }
    /**function:该方法主要用来设置某些文件不被拦截，比如脚本文件，图片等 param: return:*/
    @Override
    public void configure(WebSecurity web) throws Exception {     //保障以下资源不被过滤
        web.ignoring().antMatchers("/**/*.html,"
                , "/**/*.js","/**/*.css",
                "/**/*.png","/**/*.jpg",
                "/**/*.jpeg","/test/**",
                "/**/*.eot","/**/*.svg","/**/*.ttf","/**/*.woff");
    }
}