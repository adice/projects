package com.starrysky.infocollection.test;

import cn.wanghaomiao.seimi.core.Seimi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/seimi")
public class TestController {
    @GetMapping("test")
    public String test(){
        Seimi seimi = new Seimi();
        seimi.startAll();
        return "test";
    }
}
