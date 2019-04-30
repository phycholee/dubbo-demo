package com.llf.dubbo.dubbo;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.dubbo.config.annotation.Reference;
import com.llf.dubbo.dto.HelloDto;
import com.llf.dubbo.service.HelloDubboService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author: Oliver.li
 * @Description:
 * @date: 2019/1/17 15:18
 */
@Service
public class HelloDubboProxy {

    private static final Logger logger = LoggerFactory.getLogger(HelloDubboProxy.class);

    @Reference(version = "1.0.0")
    private HelloDubboService helloDubboService;

    @SentinelResource(value = "getHello", blockHandler = "exceptionHandler")
    public HelloDto getHello(Long id){
        try{
            return helloDubboService.getHello(id);
        } catch (Exception e){
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * Fallback 函数，函数签名与原函数一致.
     * @param id
     * @return
     */
    public HelloDto helloFallback(Long id) {
        logger.error("Fallback, id = {}", id);
        return null;
    }

    /**
     * Block 异常处理函数，参数最后多一个 BlockException，其余与原函数一致.
     * @param id
     * @param ex
     * @return
     */
    public HelloDto exceptionHandler(Long id, BlockException ex) {
        logger.error("Oops, error occurred, id = {}", id);
        return null;
    }

}
