package com.fox.sec.web;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

/**
 * @Author: tan
 * @Date: 2019/2/15 13:36
 * @function
 */

@Controller
public class loginController {
        @GetMapping("/login")
    public String Login(){
        return "login.html";
    }
    @GetMapping("/none")
    public String Error(){
        return "error.html";
    }
    @GetMapping("/index")
    public String Index(Model model){
        Object principal= SecurityContextHolder.getContext().getAuthentication();
        String username=((Authentication) principal).getName();
        //获取该用户登陆的时候对应的角色
        Collection<? extends GrantedAuthority> roles =((Authentication) principal).getAuthorities();
        String index="";
        switch (roles.toString()){
            case "[ROLE_ADMIN]":
                index="admin/index.html";
                break;
        }
        model.addAttribute("username",username);
        return index;
    }
}
