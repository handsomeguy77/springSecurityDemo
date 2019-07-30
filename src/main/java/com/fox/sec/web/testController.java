package com.fox.sec.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: tan
 * @Date: 2019/2/15 17:31
 * @function
 */
@RestController
public class testController {
    @GetMapping("/m/jcsu/xqsj/add")
    public String Xadd(){
            return "/m/jcsu/xqsj/add";
        }
        @GetMapping("/m/jcsu/xqsj/update")
        public String Xupdate(){
            return "/m/jcsu/xqsj/update";
    }
    @GetMapping("/add")
    public String add(){
        return "add";
    }
}
