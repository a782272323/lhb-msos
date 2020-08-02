package lhb.msos.security.client.config;


import lhb.msos.security.client.handler.AuthExceptionEntryHandler;
import lhb.msos.security.client.handler.CustomAccessDeniedHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.expression.OAuth2WebSecurityExpressionHandler;

/**
 * @Description  资源服务器
 * @author Herbie Leung(梁鸿斌)
 * @date 2020/8/3
 * @time 00:34
 */
@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 资源服务的ID，在单体写死，在微服务中根据服务来动态注入
     */
    @Value("${spring.application.name}")
    private String RESOURCE_ID;

    @Autowired
    private OAuth2WebSecurityExpressionHandler expressionHandler;


    @Bean
    public OAuth2WebSecurityExpressionHandler oAuth2WebSecurityExpressionHandler(ApplicationContext applicationContext) {
        OAuth2WebSecurityExpressionHandler expressionHandler = new OAuth2WebSecurityExpressionHandler();
        expressionHandler.setApplicationContext(applicationContext);
        return expressionHandler;
    }

    /**
     * 配置安全拦截机制
     * 在这里也可以配置具体的权限
     * @param http
     * @throws Exception
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                // 配置会话（session）何时创建以及和Spring Security怎么进行交互
                .csrf().disable()
                // 配置会话（session）何时创建以及和Spring Security怎么进行交互,这里配置不用session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()

                // 下边路径放行,不需要认证
                // 门户网站前缀的接口，直接放行
                .antMatchers("/portal/**").permitAll()
                // OPTIONS请求不需要鉴权
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()

                // 以下为配置所需保护的资源路径及权限，需要与认证服务器配置的授权部分对应
                .antMatchers("/lhb/**").hasAnyAuthority("ppp")

        ;
        // 其余接口没有角色限制，但需要经过认证，只要携带token就可以放行
        http.authorizeRequests().anyRequest().authenticated();
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        System.out.println("RESOURCE_ID = " + RESOURCE_ID);
        resources
                .expressionHandler(expressionHandler)
                // 资源id
                .resourceId(RESOURCE_ID)
                // 自定义异常处理,token过期或失效的处理
                .authenticationEntryPoint(new AuthExceptionEntryHandler())
                // 自定义异常处理,token权限不够的处理
                .accessDeniedHandler(new CustomAccessDeniedHandler())
        // 在这些资源上只允许基于令牌的身份验证。(具体干哈不清楚)
//                    .stateless(true)
        ;

    }

}
