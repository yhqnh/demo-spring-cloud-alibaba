package com.yhqnh.demo.spring.cloud.alibaba.service;

import com.yhqnh.demo.spring.cloud.alibaba.common.dto.ProductDTO;

public interface ProductService {

    ProductDTO get(String id);

    void deduct(String commodityCode, int count);
}
