package com.yhqnh.demo.spring.cloud.alibaba.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yhqnh.demo.spring.cloud.alibaba.common.dto.ProductDTO;
import com.yhqnh.demo.spring.cloud.alibaba.dao.StockMapper;
import com.yhqnh.demo.spring.cloud.alibaba.dao.model.StockDO;
import com.yhqnh.demo.spring.cloud.alibaba.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    private StockMapper stockMapper;

    @Override
    public ProductDTO get(String id) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(id);
        productDTO.setName("product name 1");
        productDTO.setDescription("product description 1");
        return productDTO;
    }

    @Transactional(rollbackFor = Exception.class)
    public void deduct(String commodityCode, int count) {
        if (commodityCode.equals("product-2")) {
            throw new RuntimeException("异常:模拟业务异常:stock branch exception");
        }

        QueryWrapper<StockDO> wrapper = new QueryWrapper<>();
        wrapper.setEntity(new StockDO().setCommodityCode(commodityCode));
        StockDO stockDO = stockMapper.selectOne(wrapper);
        stockDO.setCount(stockDO.getCount() - count);
        stockMapper.updateById(stockDO);
    }
}
