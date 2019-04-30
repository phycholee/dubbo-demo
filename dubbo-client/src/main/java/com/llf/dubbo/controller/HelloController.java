package com.llf.dubbo.controller;

import com.llf.dubbo.dto.HelloDto;
import com.llf.dubbo.dubbo.HelloDubboProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Oliver.li
 * @Description:
 * @date: 2019/1/17 15:18
 */
@RestController
@RequestMapping("/hello/")
public class HelloController {

    @Autowired
    private HelloDubboProxy helloDubboProxy;

    @GetMapping("get")
    public HelloDto getHello(Long id){
        HelloDto hello = helloDubboProxy.getHello(id);

        return hello;
    }


}
