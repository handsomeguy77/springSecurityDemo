package com.fox.sec.service.Impl;

import com.fox.sec.dao.QxUrlDao;
import com.fox.sec.entity.Dto.QxUrlDto;
import com.fox.sec.entity.QxUrl;
import com.fox.sec.service.QxUrlService;
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
public class QxUrlServiceImpl implements QxUrlService  {
    @Autowired
    SQLManager sqlManager;
    @Autowired
    private QxUrlDao qxUrlDao;
    @Override
    public Map<String, Object> Find(QxUrlDto params) {
        PageQuery query = new PageQuery();
        query.setParas(params);
        query.setPageNumber(params.page);
        query.setPageSize(params.limit);
        sqlManager.pageQuery("qxUrl.pageQuery", QxUrl.class, query);
        return LayuiUtils.getPage(query);
    }

    @Override
    public boolean Create(QxUrl qxUrl) {
       qxUrlDao.insert(qxUrl);
       return true;
    }

    @Override
    public boolean Update(QxUrl qxUrl) {
        int fag=qxUrlDao.updateById(qxUrl);
        if(fag==1){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean Delete(QxUrl qxUrl) {
        int fag=qxUrlDao.deleteById(qxUrl);
        if(fag==1){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public List<QxUrl> SelectAll() {
        return qxUrlDao.selectAll();
    }

    @Override
    public List<QxUrl> SelectByUrl(QxUrl qxUrl) {
        return qxUrlDao.selectByUrlName(qxUrl);
    }

    @Override
    public boolean UpdateByUrl(QxUrl qxUrl) {
        int fag=qxUrlDao.updateByUrlName(qxUrl);
        if(fag==1){
            return true;
        }else{
            return false;
        }
    }
}
