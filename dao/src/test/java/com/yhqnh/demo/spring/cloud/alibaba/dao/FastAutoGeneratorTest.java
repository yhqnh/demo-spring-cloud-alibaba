package com.yhqnh.demo.spring.cloud.alibaba.dao;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.sql.Types;
import java.util.Collections;

public class FastAutoGeneratorTest {

    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://150.158.94.86:3306/seata_order?useUnicode=true&characterEncoding=UTF-8&useSSL=false&allowMultiQueries=true&allowPublicKeyRetrieval=true", "lenovo", "lenovoQAZ123$%^")
                .globalConfig(builder -> {
                    builder.author("baomidou")
                            .enableSwagger()
                            .fileOverride()
                            .outputDir("D://FastAutoGenerator");
                })
                .dataSourceConfig(builder -> builder.typeConvertHandler((globalConfig, typeRegistry, metaInfo) -> {
                    int typeCode = metaInfo.getJdbcType().TYPE_CODE;
                    if (typeCode == Types.SMALLINT) {
                        return DbColumnType.INTEGER;
                    }
                    return typeRegistry.getColumnType(metaInfo);

                }))
                .packageConfig(builder -> {
                    builder.parent("com.baomidou.mybatisplus.samples.generator")
                            .moduleName("system")
                            .pathInfo(Collections.singletonMap(OutputFile.xml, "D://FastAutoGenerator"));
                })
                .strategyConfig(builder -> {
                    builder.addInclude("order_tbl");
                })
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }
}
