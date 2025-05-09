package com.looko.postgresqlmybatisdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.looko.postgresqlmybatisdemo.repository.mybatis")
public class PostgresqlMybatisDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PostgresqlMybatisDemoApplication.class, args);
    }

}
