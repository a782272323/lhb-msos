//package lhb.msos.security.client.config;
//
//import feign.RequestInterceptor;
//import lhb.msos.security.client.interceptor.FeignRequestInterceptor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * @Description 自定义的Feign拦截器
// * Feign 全局配置
// * @author Herbie Leung(梁鸿斌)
// * @date 2020/8/6
// * @time 16:26
// */
//@Configuration
//public class FeignRequestConfiguration {
//
//    @Bean
//    public RequestInterceptor requestInterceptor() {
//        return new FeignRequestInterceptor();
//    }
//}