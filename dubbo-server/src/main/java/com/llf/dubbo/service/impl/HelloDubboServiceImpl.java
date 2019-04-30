package com.llf.dubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.llf.dubbo.dto.HelloDto;
import com.llf.dubbo.service.HelloDubboService;

/**
 * @author: Oliver.li
 * @Description:
 * @date: 2019/1/17 15:13
 */
@Service(version = "1.0.0")
public class HelloDubboServiceImpl implements HelloDubboService {

    public HelloDto getHello(Long id) {
        HelloDto helloDto = new HelloDto();
        helloDto.setId(id);
        helloDto.setContent("Hello, handsome");
        return helloDto;
    }
}
