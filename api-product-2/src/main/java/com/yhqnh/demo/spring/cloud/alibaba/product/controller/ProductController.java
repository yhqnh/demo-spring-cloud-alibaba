package com.yhqnh.demo.spring.cloud.alibaba.product.controller;

import com.yhqnh.demo.spring.cloud.alibaba.common.dto.OrderDTO;
import com.yhqnh.demo.spring.cloud.alibaba.common.dto.ProductDTO;
import com.yhqnh.demo.spring.cloud.alibaba.service.OrderService;
import com.yhqnh.demo.spring.cloud.alibaba.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController(value = "/product")
public class ProductController {

    @Resource
    private ProductService productService;

    @GetMapping("/{id}")
    public ProductDTO get(@PathVariable String id) {
        return productService.get("product-2:" + id);
    }
}
