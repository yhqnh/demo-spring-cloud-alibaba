package com.yhqnh.demo.spring.cloud.alibaba.service.impl;

import com.yhqnh.demo.spring.cloud.alibaba.common.dto.ProductDTO;
import com.yhqnh.demo.spring.cloud.alibaba.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Override
    public ProductDTO get(String id) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(id);
        productDTO.setName("product name 1");
        productDTO.setDescription("product description 1");
        return productDTO;
    }
}
