package com.fox.sec.entity.Dto;

import com.fox.sec.utils.BaseParams;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class QxUserDto extends BaseParams {
    private String Username;        //用户名
    private String Password;        //密码
    private String Qq;              //QQ
    private String Role;            //角色
    public QxUserDto(Long page,Long limit){
        super(page,limit);
    }
}
