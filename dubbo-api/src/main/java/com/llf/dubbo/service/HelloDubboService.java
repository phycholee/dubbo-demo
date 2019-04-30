package com.llf.dubbo.service;

import com.llf.dubbo.dto.HelloDto;

/**
 * @author: Oliver.li
 * @Description:
 * @date: 2019/1/17 15:08
 */
public interface HelloDubboService {

    HelloDto getHello(Long id);

}
