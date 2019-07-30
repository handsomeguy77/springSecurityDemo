package com.fox.sec.web;

import com.fox.sec.entity.Dto.QxUserDto;
import com.fox.sec.entity.QxUser;
import com.fox.sec.service.QxUserService;
import com.fox.sec.entity.Dto.QxUserDto;
import com.fox.sec.entity.QxUser;
import com.fox.sec.service.QxUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class QxUserController {
    @Autowired private QxUserService qxUserService;
    @GetMapping("/q/user/get")
    public Map<String,Object> Find(QxUserDto params){
        return qxUserService.Find(params);
    }
    @PostMapping("/m/user/add")
    public boolean Create(@RequestBody QxUser qxUser){
        return qxUserService.Create(qxUser);
    }
    @PutMapping("/m/user/update")
    public boolean Update(@RequestBody QxUser qxUser){
        return qxUserService.Update(qxUser);
    }
    @PostMapping("/m/user/del")
    public boolean Delete(@RequestBody QxUser qxUser){
        return qxUserService.Delete(qxUser);
    }
    @GetMapping("/q/user/getAll")
    public List<QxUser> SelectAll(){
        return qxUserService.SelectAll();
    }
    @PutMapping("/m/user/updateByUsername")
    public boolean UpdateByRole(@RequestBody QxUser qxUser){
        return qxUserService.UpdateByUsername(qxUser);
    }
}
