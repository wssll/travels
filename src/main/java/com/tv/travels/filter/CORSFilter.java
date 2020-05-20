//package com.tv.travels.filter;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@Component
//@Slf4j
//public class CORSFilter implements Filter {
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//
//    }
//
//    @Override
//    public void destroy() {
//
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        HttpServletResponse httpResponse = (HttpServletResponse) response;
//        //*表示允许所有域名跨域
//        httpResponse.addHeader("Access-Control-Allow-Origin", "http://localhost:63342");
//        httpResponse.addHeader("Access-Control-Allow-Headers",
//                "Origin, X-Requested-With, Content-Type, Accept");
//        //允许跨域的Http方法
//        httpResponse.addHeader("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE");
//        httpResponse.addHeader("Access-Control-Max-Age", "0");
//        httpResponse.addHeader("Access-Control-Allow-Credentials","true");
//        httpResponse.addHeader("XDomainRequestAllowed","1");
//        log.info("kuayu-------------------");
//        chain.doFilter(request,response);
//
//    }
//}
