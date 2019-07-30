package com.fox.sec.service;

import com.fox.sec.entity.Dto.QxUrlDto;
import com.fox.sec.entity.QxUrl;

import java.util.List;
import java.util.Map;

public interface QxUrlService {
    //翻页查询
    Map<String, Object> Find(QxUrlDto params);

    //添加
    boolean Create(QxUrl qxUrl);

    //编辑
    boolean Update(QxUrl qxUrl);

    //删除
    boolean Delete(QxUrl qxUrl);

    //查询出所有的url
    List<QxUrl> SelectAll();

    //通过url名来查询该url对应的角色（roles）
    List<QxUrl> SelectByUrl(QxUrl qxUrl);

    //通过url名来进行更新对应的角色（roles）
    boolean UpdateByUrl(QxUrl qxUrl);
}
