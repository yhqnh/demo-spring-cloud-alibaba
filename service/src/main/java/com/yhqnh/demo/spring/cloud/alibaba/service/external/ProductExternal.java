package com.yhqnh.demo.spring.cloud.alibaba.service.external;

import com.yhqnh.demo.spring.cloud.alibaba.common.dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "api-product")
public interface ProductExternal {

    @GetMapping(path = "/{id}")
    ProductDTO get(@PathVariable(name = "id") String id);
}
