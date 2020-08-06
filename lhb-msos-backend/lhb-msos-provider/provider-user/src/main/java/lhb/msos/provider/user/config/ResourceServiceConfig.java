//package lhb.msos.provider.user.config;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
//
///**
// * @Description  用户服务资源服务器
// * @author Herbie Leung(梁鸿斌)
// * @date 2020/8/6
// * @time 01:36
// */
//@Configuration
//@EnableResourceServer
//public class ResourceServiceConfig extends ResourceServerConfigurerAdapter {
//
//    @Value("${spring.application.name}")
//    private String resource_id;
//
//    /**
//     * 配置 resourceId
//     * @param resources
//     * @throws Exception
//     */
//    @Override
//    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
//        resources.resourceId(resource_id);
//    }
//
//    /**
//     * 默认所有的请求都需要验证token
//     * 根据自己项目实际情况来配置
//     * @param http
//     * @throws Exception
//     */
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                // todo 百度
//                .requestMatchers(EndpointRequest.toAnyEndpoint()).permitAll()
//                // 放行
//                .antMatchers("/css/**",
//                        "/js/**",
//                        "/plugins/**",
//                        "/favicon.ico",
//                        "/actuator/**",
//                        "/oauth/**",
//                        "/static/**").permitAll()
//                //剩下的都需要拦截
//                .anyRequest().authenticated()
//                .and()
//                // 统一自定义异常
//                .exceptionHandling()
//                .and()
//                .csrf().disable()
//            ;
//    }
//}
