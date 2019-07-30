package com.fox.sec.dao;

import com.fox.sec.entity.QxRole;
import org.beetl.sql.core.annotatoin.SqlResource;
import org.beetl.sql.core.mapper.BaseMapper;

import java.util.List;

@SqlResource("qxRole")
public interface QxRoleDao extends BaseMapper<QxRole> {
    public int deleteById(QxRole qxRole);
    public List<QxRole> selectAll();
}
