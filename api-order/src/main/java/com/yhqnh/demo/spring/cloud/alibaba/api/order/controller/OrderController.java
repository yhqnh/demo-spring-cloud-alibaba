package com.yhqnh.demo.spring.cloud.alibaba.api.order.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.yhqnh.demo.spring.cloud.alibaba.common.dto.OrderDTO;
import com.yhqnh.demo.spring.cloud.alibaba.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController(value = "/order")
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("/{id}")
    @SentinelResource(value = "get")
    public OrderDTO get(@PathVariable String id) {
        return orderService.get(id);
    }
}
