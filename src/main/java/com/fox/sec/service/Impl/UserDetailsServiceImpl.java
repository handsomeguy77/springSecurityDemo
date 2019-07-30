package com.fox.sec.service.Impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fox.sec.dao.QxUserDao;
import com.fox.sec.entity.QxUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;



public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private QxUserDao qxUserDao;
    @Autowired
    ObjectMapper objectMapper;
    /**function:引用接口UserDetailService,重写方法loadUserByUsername
     *    通过UserBuilder构造一个授权的用户，该用户至少包含用户名，密码以及角色
     *  param: return:*/
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QxUser qxUser = qxUserDao.selectByUsername(username);
        try{
            System.out.println(objectMapper.writeValueAsString(qxUser));
        }catch (JsonProcessingException e){

        }

        if (qxUser == null){
            throw new UsernameNotFoundException("user not found");
        }else {
            User.UserBuilder userBuilder = User.withUsername(username);
            userBuilder.password(qxUser.getPassword());      //加密时启用   数据库存密文
            userBuilder.roles(qxUser.getRole());      //一个用户可能存在多种角色
            return userBuilder.build();
        }
    }
}