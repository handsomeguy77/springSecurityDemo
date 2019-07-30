package com.fox.sec.service.Impl;

import com.fox.sec.dao.QxRoleDao;
import com.fox.sec.entity.Dto.QxRoleDto;
import com.fox.sec.entity.QxRole;
import com.fox.sec.service.QxRoleService;
import com.fox.sec.dao.QxRoleDao;
import com.fox.sec.entity.Dto.QxRoleDto;
import com.fox.sec.entity.QxRole;
import com.fox.sec.service.QxRoleService;
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
public class QxRoleServiceImpl implements QxRoleService {
    @Autowired
    SQLManager sqlManager;
    @Autowired
    QxRoleDao qxRoleDao;
    @Override
    public Map<String, Object> Find(QxRoleDto params) {
        PageQuery query = new PageQuery();
        query.setParas(params);
        query.setPageNumber(params.page);
        query.setPageSize(params.limit);
        sqlManager.pageQuery("qxRole.pageQuery", QxRole.class, query);
        return LayuiUtils.getPage(query);
    }

    @Override
    public boolean Create(QxRole qxRole) {
        qxRoleDao.insert(qxRole);
        return true;
    }

    @Override
    public boolean Update(QxRole qxRole) {
        int fag=qxRoleDao.updateById(qxRole);
        if(fag==1){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean Delete(QxRole qxRole) {
        int fag=qxRoleDao.deleteById(qxRole);
        if(fag==1){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public List<QxRole> SelectAll() {
        return qxRoleDao.selectAll();
    }
}
