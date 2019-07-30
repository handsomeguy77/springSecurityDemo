package com.fox.sec.service.Impl;

import com.fox.sec.dao.QxUserDao;
import com.fox.sec.entity.Dto.QxUserDto;
import com.fox.sec.entity.QxUser;
import com.fox.sec.service.QxUserService;
import com.fox.sec.dao.QxUserDao;
import com.fox.sec.entity.Dto.QxUserDto;
import com.fox.sec.entity.QxUser;
import com.fox.sec.service.QxUserService;
import com.fox.sec.utils.LayuiUtils;
import org.beetl.sql.core.SQLManager;
import org.beetl.sql.core.engine.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class QxUserServiceImpl implements QxUserService {
    @Autowired
    SQLManager sqlManager;
    @Autowired private QxUserDao qxUserDao;
    @Override
    public Map<String, Object> Find(QxUserDto params) {
        PageQuery query = new PageQuery();
        query.setParas(params);
        query.setPageNumber(params.page);
        query.setPageSize(params.limit);
        sqlManager.pageQuery("qxUser.pageQuery", QxUser.class, query);
        return LayuiUtils.getPage(query);
    }

    @Override
    public boolean Create(QxUser qxUser) {
        qxUserDao.insertUser(qxUser);
        return true;
    }

    @Override
    public boolean Update(QxUser qxUser) {
        int fag=qxUserDao.updateById(qxUser);
        if(fag==1){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean Delete(QxUser qxUser) {
        int fag=qxUserDao.deleteById(qxUser);
        if(fag==1){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public List<QxUser> SelectAll() {
        return qxUserDao.selectAll();
    }

    @Override
    public boolean UpdateByUsername(QxUser qxUser) {
        String[] RoleList=qxUser.getRoleList();
        StringBuffer sb = new StringBuffer();       //将字符串数组转换为字符串
        for(int i = 0; i < RoleList.length; i++){
            sb.append(RoleList[i]);
            if(i!=RoleList.length-1){
                sb.append(",");
            }
        }
        String newStr = sb.toString();
        qxUser.setRole(newStr);
        int fag=qxUserDao.updateByUsername(qxUser);
        if(fag==1){
            return true;
        }else{
            return false;
        }
    }
}
