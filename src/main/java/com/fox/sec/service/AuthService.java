package com.fox.sec.service;

import java.util.List;
import java.util.Map;

/**
 * @Author: tan
 * @Date: 2019/2/15 12:56
 * @function
 */
public interface AuthService {
    /**
     * function:获取所有的角色与url之间的关系
     * */
    Map<String,String> getAllUrl();

}
