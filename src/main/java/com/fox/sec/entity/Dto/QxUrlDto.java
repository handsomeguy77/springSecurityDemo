package com.fox.sec.entity.Dto;

import com.fox.sec.utils.BaseParams;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class QxUrlDto extends BaseParams {
    private String Name;        //url名
    private String Sm;          //说明
    private String Roles;       //角色
    public QxUrlDto(Long page,Long limit){
        super(page,limit);
    }
}
