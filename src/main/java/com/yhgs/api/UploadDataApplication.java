package com.yhgs.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.yhgs.api.mapper"})
public class UploadDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(UploadDataApplication.class, args);
	}

}
