package com.yhqnh.demo.spring.cloud.alibaba.dao;

import com.yhqnh.demo.spring.cloud.alibaba.common.dto.OrderDTO;

public interface OrderMapper {

    OrderDTO get(String id);
}
