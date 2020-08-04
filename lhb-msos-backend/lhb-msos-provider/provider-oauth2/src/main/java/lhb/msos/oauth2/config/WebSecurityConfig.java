package lhb.msos.oauth2.config;

import lhb.msos.oauth2.service.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Description  web安全配置
 * @author Herbie Leung(梁鸿斌)
 * @date 2020/8/3
 * @time 00:16
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 密码编码器
     * @return
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 配置授权管理器
     * @return
     * @throws Exception
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManager() throws Exception{
        return super.authenticationManager();
    }

    /**
     * 注入用户认证逻辑
     * @return
     * @throws Exception
     */
    @Bean
    @Override
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return new UserDetailsServiceImpl();
    }

    /**
     * 网络过滤
     * @param web
     * @throws Exception
     */
    @Override
    public void init(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**",
                "/js/**",
                "/plugins/**",
                "/favicon.ico",
                "/actuator/**",
                "/oauth/user",
                "/oauth/check_token");
    }


    /**
     * 用户认证
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsServiceBean())
        ;
    }
}
