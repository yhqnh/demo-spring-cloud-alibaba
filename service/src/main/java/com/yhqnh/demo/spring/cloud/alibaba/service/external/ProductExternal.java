package com.yhqnh.demo.spring.cloud.alibaba.service.external;

import com.yhqnh.demo.spring.cloud.alibaba.common.dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "api-product")
public interface ProductExternal {

    @GetMapping(path = "product/{id}")
    ProductDTO get(@PathVariable(name = "id") String id);

    @GetMapping("product/stock/deduct")
    Boolean deduct(@RequestParam("commodityCode") String commodityCode, @RequestParam("count") Integer count);
}
