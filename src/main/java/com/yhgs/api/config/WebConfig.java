package com.yhgs.api.config;

import com.yhgs.api.Interceptor.LoginInterceptor;
import io.xjar.XCryptos;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebConfig implements WebMvcConfigurer {
 
    @Bean
    public LoginInterceptor loginInterceptor() {
        return new LoginInterceptor();
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor())
                .addPathPatterns("/**") // 拦截所有请求，通过判断是否有 @LoginRequired 注解 决定是否需要登录
                .excludePathPatterns(
                        "/api/Ticket",
                        "/api/ScData/SSData"
                );
    }

    public static void main(String[] args) throws Exception {
        XCryptos.encryption()
                // jar包本地目录位置
                .from("C:\\Users\\dell\\Desktop\\UPLOAD_DATA\\target\\UPLOAD_DATA-0.0.1-SNAPSHOT.jar")
                .use("yi19970728")
                //exclude 不需要混肴的模块 静态文件  模板 资源文件
                .exclude("/resources/**/*")
                //to 生成jar 的目标目录
                .to("C:\\Users\\dell\\Desktop\\code_generator-0.0.1-SNAPSHOT.jar");
        System.out.println("成功");
    }
}