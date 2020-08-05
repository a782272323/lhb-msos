//package lhb.msos.provider.user.config;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
//
//@Configuration
//@EnableResourceServer
//public class ResourceServiceCofig extends ResourceServerConfigurerAdapter {
//
//    @Value("${spring.application.name}")
//    private String resource_id;
//
//    /**
//     * 配置 resourceId 即告诉认证服务器 我就是 game-service
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
//        http.authorizeRequests()
//                //我这里就意思意思一下 假设配置token,test开头的url不需要验证,多个逗号隔开
//                .antMatchers("/token/*","/test/*")
//                //剩下的都需要拦截
//                .permitAll().anyRequest().authenticated();
//    }
//}
