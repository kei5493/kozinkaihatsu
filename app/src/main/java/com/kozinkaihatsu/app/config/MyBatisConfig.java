package com.kozinkaihatsu.app.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.kozinakihatsu.app.repository")
public class MyBatisConfig {
}
