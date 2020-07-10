package com.msr.tq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * 主类
 */
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.msr.tq.mapper")
@ComponentScan(basePackages={"com.msr.tq","com.msr.common"})
public class TqApplication {
    public static void main(String[] args) {
        SpringApplication.run(TqApplication.class);
    }
}
