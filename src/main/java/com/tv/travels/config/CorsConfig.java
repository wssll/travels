//package com.tv.travels.config;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//@Slf4j
//public class CorsConfig implements WebMvcConfigurer {
//
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        log.info("我是MyWebConfig跨域");
//        //设置允许跨域的路径
//        registry.addMapping("/**")
//                //设置允许跨域请求的域名
//                .allowedOrigins("*")
//                //是否允许证书 不再默认开启
//                .allowCredentials(true)
//                //设置允许的方法
//                .allowedMethods("*")
//                //跨域允许时间
//                .maxAge(3600);
//
////        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
////
////        registry.addResourceHandler("swagger-ui.html")
////                .addResourceLocations("classpath:/META-INF/resources/");
////
////        registry.addResourceHandler("/webjars/**")
////                .addResourceLocations("classpath:/META-INF/resources/webjars/");
//
//    }
//}
