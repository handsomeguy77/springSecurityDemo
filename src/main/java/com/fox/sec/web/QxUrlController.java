package com.fox.sec.web;

import com.fox.sec.service.QxUrlService;
import com.fox.sec.entity.Dto.QxUrlDto;
import com.fox.sec.entity.QxUrl;
import com.fox.sec.service.QxUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class QxUrlController {
    @Autowired
    private QxUrlService qxUrlService;
    @GetMapping("/q/url/get")
    public Map<String,Object> Find(QxUrlDto params){
        return qxUrlService.Find(params);
    }
    @PostMapping("/m/url/add")
    public boolean Create(@RequestBody QxUrl qxUrl){
        return qxUrlService.Create(qxUrl);
    }
    @PutMapping("/m/url/update")
    public boolean Update(@RequestBody QxUrl qxUrl){
        return qxUrlService.Update(qxUrl);
    }
    @PostMapping("/m/url/del")
    public boolean Delete(@RequestBody QxUrl qxUrl){
        return qxUrlService.Delete(qxUrl);
    }
    @GetMapping("/q/url/getAll")
    public List<QxUrl> SelectAll(){
        return qxUrlService.SelectAll();
    }
    @PostMapping("/q/url/getByUrl")
    public List<QxUrl> SelectByUrl(@RequestBody QxUrl qxUrl){
        return qxUrlService.SelectByUrl(qxUrl);
    }
    @PutMapping("/m/url/updateByUrl")
    public boolean UpdateByUrl(@RequestBody QxUrl qxUrl){
        return qxUrlService.UpdateByUrl(qxUrl);
    }
}
