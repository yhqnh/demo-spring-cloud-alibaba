package com.yhqnh.demo.spring.cloud.alibaba.dao.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@TableName("stock_tbl")
public class StockDO {

    private Long id;
    private String commodityCode;
    private Long count;
}
