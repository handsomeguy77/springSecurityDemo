package com.fox.sec.entity;

import lombok.Data;

@Data
public class QxUser {
    private Integer Id;     //id
    private String Username;        //用户名
    private String Password;        //密码
    private String Qq;              //QQ
    private String Role;            //角色
    private String [] RoleList;        //用来存储所有角色的数组（数据库中不存在该字段）
}
