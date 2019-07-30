package com.fox.sec.service.Impl;

import com.fox.sec.dao.QxUrlDao;
import com.fox.sec.entity.QxUrl;
import com.fox.sec.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: tan
 * @Date: 2019/2/15 12:58
 * @function
 */
@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private QxUrlDao qxUrlDao;
    @Override
    public Map<String, String> getAllUrl(){
        List<QxUrl> allRoles = qxUrlDao.selectAll();
        Map<String,String> allUrlMap = new LinkedHashMap<>();
            for(QxUrl qxUrl:allRoles){
                allUrlMap.put(qxUrl.getName(),qxUrl.getRoles());
            }
        return allUrlMap;
    }
}
