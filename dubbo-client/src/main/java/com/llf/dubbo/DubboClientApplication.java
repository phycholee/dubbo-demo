package com.llf.dubbo;

import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.llf.dubbo.dto.HelloDto;
import com.llf.dubbo.dubbo.HelloDubboProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DubboClientApplication {

    @Autowired
    private HelloDubboProxy helloDubboProxy;

    public static void main(String[] args) {
        SpringApplication.run(DubboClientApplication.class, args);
    }

    @PostConstruct
    public void init() {
        HelloDto hello = helloDubboProxy.getHello(1L);
        System.err.println(hello);
    }

    /**
     * 配置规则
     */
    private static void initRules(){
        List<FlowRule> rules = new ArrayList<>();

        FlowRule rule = new FlowRule();
        rule.setResource("getHello");
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule.setCount(20);

        rules.add(rule);

        FlowRuleManager.loadRules(rules);
    }
}

