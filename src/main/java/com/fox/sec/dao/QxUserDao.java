package com.fox.sec.dao;

import com.fox.sec.entity.QxUser;
import com.fox.sec.entity.QxUser;
import org.beetl.sql.core.annotatoin.Param;
import org.beetl.sql.core.annotatoin.SqlResource;
import org.beetl.sql.core.mapper.BaseMapper;

import java.util.List;

@SqlResource("qxUser")
public interface QxUserDao extends BaseMapper<QxUser> {
    public int insertUser(QxUser qxUser);
    public int deleteById(QxUser qxUser);
    public List<QxUser> selectAll();
    public int updateByUsername(QxUser qxUser);
    public QxUser selectByUsername(@Param("username") String username);
}
