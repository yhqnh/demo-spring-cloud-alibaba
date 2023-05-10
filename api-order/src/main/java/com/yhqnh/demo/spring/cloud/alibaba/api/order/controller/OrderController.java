package com.yhqnh.demo.spring.cloud.alibaba.api.order.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.yhqnh.demo.spring.cloud.alibaba.common.dto.OrderDTO;
import com.yhqnh.demo.spring.cloud.alibaba.service.OrderService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping(path = "/order")
@RefreshScope
public class OrderController {

    @Value("${testConfigValue:test}")
    private String testConfigValue;

    @Resource
    private OrderService orderService;

    @GetMapping("/{id}")
    @SentinelResource(value = "get")
    public OrderDTO get(@PathVariable String id) {
        return orderService.get(id);
    }

    @GetMapping("/test")
    @SentinelResource
    public String test() {
        return testConfigValue;
    }

    /**
     * 下单：插入订单表、扣减库存，模拟回滚
     *
     * @return
     */
    @PostMapping("/placeOrder/commit")
    public Boolean placeOrderCommit() {

        orderService.placeOrder("1", "product-1", 1);
        return true;
    }

    /**
     * 下单：插入订单表、扣减库存，模拟回滚
     *
     * @return
     */
    @PostMapping("/placeOrder/rollback")
    public Boolean placeOrderRollback() {
        // product-2 扣库存时模拟了一个业务异常
        orderService.placeOrder("1", "product-2", 1);
        return true;
    }

    @PostMapping("/placeOrder")
    public Boolean placeOrder(String userId, String commodityCode, Integer count) {
        orderService.placeOrder(userId, commodityCode, count);
        return true;
    }
}
