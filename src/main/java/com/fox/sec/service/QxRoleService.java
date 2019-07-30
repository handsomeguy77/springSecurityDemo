package com.fox.sec.service;

import com.fox.sec.entity.QxRole;
import com.fox.sec.entity.Dto.QxRoleDto;
import com.fox.sec.entity.QxRole;

import java.util.List;
import java.util.Map;

public interface QxRoleService {
    //翻页查询
    Map<String, Object> Find(QxRoleDto params);

    //添加
    boolean Create(QxRole qxRole);

    //编辑
    boolean Update(QxRole qxRole);

    //删除
    boolean Delete(QxRole qxRole);

    //查询所有的角色名
    List<QxRole> SelectAll();
}
