package com.fox.sec.dao;

import com.fox.sec.entity.QxUrl;
import com.fox.sec.entity.QxUrl;
import org.beetl.sql.core.annotatoin.SqlResource;
import org.beetl.sql.core.mapper.BaseMapper;

import java.util.List;

@SqlResource("qxUrl")
public interface QxUrlDao extends BaseMapper<QxUrl> {
    public int deleteById(QxUrl qxUrL);
    public List<QxUrl> selectAll();
    public List<QxUrl> selectByUrlName(QxUrl qxUrl);
    public int updateByUrlName(QxUrl qxUrl);
}
