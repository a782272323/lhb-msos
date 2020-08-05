//package lhb.msos.provider.user.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationManager;
//import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
//import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    /**
//     * 声明资源服务器令牌服务
//     * @return
//     */
//    @Bean
//    public ResourceServerTokenServices tokenServices(){
//        RemoteTokenServices tokenServices =  new RemoteTokenServices();
//        //认证服务器认识的client
//        //认证服务器认识的client secret
//        tokenServices.setClientId("user_client");
//        tokenServices.setClientSecret("123456");
//        //认证服务器验证token url
//        tokenServices.setCheckTokenEndpointUrl("http://localhost:10000/oauth/check_token");
//        return tokenServices;
//    }
//
//    /**
//     * 告诉认证服务器对应的令牌-->>用户信息
//     * 暴露AuthenticationManager
//     * @return
//     * @throws Exception
//     */
//    @Bean
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        OAuth2AuthenticationManager authenticationManager = new OAuth2AuthenticationManager();
//        authenticationManager.setTokenServices(tokenServices());
//        return authenticationManager;
//    }
//}
