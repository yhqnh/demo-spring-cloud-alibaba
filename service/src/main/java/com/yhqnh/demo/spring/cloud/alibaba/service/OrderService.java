package com.yhqnh.demo.spring.cloud.alibaba.service;

import com.yhqnh.demo.spring.cloud.alibaba.common.dto.OrderDTO;

public interface OrderService {

    OrderDTO get(String id);

    void placeOrder(String userId, String commodityCode, Integer count);
}
