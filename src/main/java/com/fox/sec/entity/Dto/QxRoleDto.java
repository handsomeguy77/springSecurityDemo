package com.fox.sec.entity.Dto;

import com.fox.sec.utils.BaseParams;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class QxRoleDto extends BaseParams {
    private String Role;        //角色名
    private String Sm;              //说明
    public QxRoleDto(Long page,Long limit){
        super(page,limit);
    }
}
