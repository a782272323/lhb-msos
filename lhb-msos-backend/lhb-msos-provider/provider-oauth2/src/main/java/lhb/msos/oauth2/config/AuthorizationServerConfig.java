package lhb.msos.oauth2.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import javax.annotation.Resource;

/**
 * @Description  认证授权服务器
 * @author Herbie Leung(梁鸿斌)
 * @date 2020/8/3
 * @time 00:02
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 访问客户端密钥
     */
    private String CLIENT_SECRET = "123456";
    /**
     * 访问客户端ID
     */
    private String CLIENT_ID ="lhb";
    /**
     * 鉴权模式,密码模式，开启刷新token
     */
    private String[] GRANT_TYPE = {"password","refresh_token"};
    /**
     * 资源服务的ID，在单体写死，在微服务中根据服务来动态注入
     */
    @Value("${spring.application.name}")
    private String RESOURCE_ID;

    /**
     * 密码编码器
     */
    @Resource
    private BCryptPasswordEncoder passwordEncoder;

    /**
     * 认证管理器
     */
    @Resource
    private AuthenticationManager authenticationManager;

    /**
     * 客户端详情
     */
    @Resource
    private ClientDetailsService clientDetailsService;

    /**
     * 注入redis
     */
    @Resource
    private RedisConnectionFactory connectionFactory;

    /**
     * 使用redis来存储令牌
     * @return
     */
    @Bean
    public RedisTokenStore redisTokenStore() {
        return new RedisTokenStore(connectionFactory);
    }

    /**
     * 客户端详情配置
     * 暂时使用内存存储
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        // 基于内存存储
        clients.inMemory()
                // client_id
                .withClient(CLIENT_ID)
                // 加密
                .secret(passwordEncoder.encode(CLIENT_SECRET))
                // 资源id
                .resourceIds(RESOURCE_ID)
                // 授权模式
                .authorizedGrantTypes(GRANT_TYPE[0], GRANT_TYPE[1])
                // 允许授权的范围
                .scopes("all")
        ;

    }

    /**
     * 配置令牌访问端点和令牌访问服务，令牌 = token
     * @param security
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security
                // 开启/oauth/token_key验证端口无权限访问
                .tokenKeyAccess("permitAll()")
                // /oauth/check_token 公开
                .checkTokenAccess("permitAll()")
                // 允许表单验证（前端），申请令牌
                .allowFormAuthenticationForClients()
        ;


    }


    /**
     * 配置令牌端点的安全约束
     * 启动授权终端
     * @param endpoints
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                // 令牌存redis
                .tokenStore(redisTokenStore())
                // 认证管理器,支持密码模式
                .authenticationManager(authenticationManager)
                // 允许post请求访问令牌
                .allowedTokenEndpointRequestMethods(HttpMethod.POST)
                // 校验token
                .tokenServices(tokenServices())
        ;

    }

    /**
     * 令牌设置
     * @return
     */
    @Bean
    public AuthorizationServerTokenServices tokenServices() {
        DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
        // 客户端详情信息
        defaultTokenServices.setClientDetailsService(clientDetailsService);
        // 开启刷新令牌
        defaultTokenServices.setReuseRefreshToken(true);
        // 令牌存储方案
        defaultTokenServices.setTokenStore(redisTokenStore());
        // 令牌 assess_token 有效期12小时，可自定义
        defaultTokenServices.setAccessTokenValiditySeconds(60 * 60 * 12);
        // 刷新令牌 refresh_token 有效期一周，可自定义
        defaultTokenServices.setRefreshTokenValiditySeconds(60 * 60 * 24 * 7);
        return defaultTokenServices;
    }

}
