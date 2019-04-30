package com.llf.dubbo.sentinel;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Oliver.li
 * @Description:
 * @date: 2019/1/25 14:15
 */
public class SentinelTest {

    @Test
    public void test1(){
        initRules();

        while (true){
            Entry entry = null;

            try {
                entry = SphU.entry("HelloSentinel");

                System.out.println("Hello, I'm out.");
            } catch (BlockException e) {
                e.printStackTrace();
                System.out.println("Blocked!");
            } finally {
                if (entry != null){
                    entry.exit();
                }
            }

        }
    }


    /**
     * 配置规则
     */
    private static void initRules(){
        List<FlowRule> rules = new ArrayList<>();

        FlowRule rule = new FlowRule();
        rule.setResource("HelloSentinel");
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule.setCount(20);

        rules.add(rule);

        FlowRuleManager.loadRules(rules);
    }
}
