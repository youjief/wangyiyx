package com.wyyx.cn.provider.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.fyj.cn.provider.mapper")
public class MybatisConfiguration {
}
