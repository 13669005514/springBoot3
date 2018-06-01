package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
//扫描mapper文件包
@MapperScan("com.mapper")
//配置事务管理
@EnableTransactionManagement
public class Springboot4Application {

    public static void main(String[] args) {

        SpringApplication.run(Springboot4Application.class, args);
    }
}
