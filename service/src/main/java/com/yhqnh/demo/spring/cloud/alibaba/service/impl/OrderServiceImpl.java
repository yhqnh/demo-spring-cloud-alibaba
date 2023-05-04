package com.yhqnh.demo.spring.cloud.alibaba.service.impl;

import com.yhqnh.demo.spring.cloud.alibaba.common.dto.OrderDTO;
import com.yhqnh.demo.spring.cloud.alibaba.common.dto.ProductDTO;
import com.yhqnh.demo.spring.cloud.alibaba.service.OrderService;
import com.yhqnh.demo.spring.cloud.alibaba.service.external.ProductExternal;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private ProductExternal productExternal;

    @Override
    public OrderDTO get(String id) {
        ProductDTO productDTO = productExternal.get("1");
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId("1");
        orderDTO.setProductId(productDTO.getId());
        return orderDTO;
    }
}
