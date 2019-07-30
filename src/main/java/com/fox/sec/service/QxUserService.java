package com.fox.sec.service;

import com.fox.sec.entity.QxUser;
import com.fox.sec.entity.Dto.QxUserDto;
import com.fox.sec.entity.QxUser;

import java.util.List;
import java.util.Map;

public interface QxUserService {
    //翻页查询
    Map<String, Object> Find(QxUserDto params);

    //添加
    boolean Create(QxUser qxUser);

    //编辑
    boolean Update(QxUser qxUser);

    //删除
    boolean Delete(QxUser qxUser);

    //查询出所有的用户名
    List<QxUser> SelectAll();

    //通过用户名更新角色(role)
    boolean UpdateByUsername(QxUser qxUser);
}
