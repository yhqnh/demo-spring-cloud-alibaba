package com.yhqnh.demo.spring.cloud.alibaba.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.yhqnh.demo.spring.cloud.alibaba.common.dto.OrderDTO;
import com.yhqnh.demo.spring.cloud.alibaba.common.dto.ProductDTO;
import com.yhqnh.demo.spring.cloud.alibaba.dao.OrderMapper;
import com.yhqnh.demo.spring.cloud.alibaba.dao.model.OrderDO;
import com.yhqnh.demo.spring.cloud.alibaba.service.OrderService;
import com.yhqnh.demo.spring.cloud.alibaba.service.external.ProductExternal;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private ProductExternal productExternal;

    @Resource
    private OrderMapper orderMapper;

    @Override
    public OrderDTO get(String id) {
        ProductDTO productDTO = productExternal.get("1");
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId("1");
        orderDTO.setProductId(productDTO.getId());
        return orderDTO;
    }

//    @GlobalTransactional
    @Transactional(rollbackFor = Exception.class)
    public void placeOrder(String userId, String commodityCode, Integer count) {
        BigDecimal orderMoney = new BigDecimal(count).multiply(new BigDecimal(5));
        OrderDO orderDO = new OrderDO().setUserId(userId).setCommodityCode(commodityCode).setCount(count).setMoney(
                orderMoney);
        orderMapper.insert(orderDO);
        productExternal.deduct(commodityCode, count);
    }
}
