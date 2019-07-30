package com.fox.sec.web;

import com.fox.sec.entity.Dto.QxRoleDto;
import com.fox.sec.entity.QxRole;
import com.fox.sec.service.QxRoleService;
import com.fox.sec.entity.Dto.QxRoleDto;
import com.fox.sec.entity.QxRole;
import com.fox.sec.service.QxRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class QxRoleController {
    @Autowired
    private QxRoleService qxRoleService;
    @GetMapping("/q/role/get")
    public Map<String,Object> Find(QxRoleDto params){
        return qxRoleService.Find(params);
    }
    @PostMapping("/m/role/add")
    public boolean Create(@RequestBody QxRole qxRole){
        return qxRoleService.Create(qxRole);
    }
    @PutMapping("/m/role/update")
    public boolean Update(@RequestBody QxRole qxRole){
        return qxRoleService.Update(qxRole);
    }
    @PostMapping("/m/role/del")
    public boolean Delete(@RequestBody QxRole qxRole){
        return qxRoleService.Delete(qxRole);
    }
    @GetMapping("/q/role/getAll")
    public List<QxRole> SelectAll(){
        return qxRoleService.SelectAll();
    }
}
