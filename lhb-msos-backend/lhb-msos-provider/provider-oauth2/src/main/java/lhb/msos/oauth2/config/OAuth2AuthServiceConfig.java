package lhb.msos.oauth2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

import javax.annotation.Resource;

@Configuration
@EnableAuthorizationServer
public class OAuth2AuthServiceConfig extends AuthorizationServerConfigurerAdapter {

    @Resource
    private AuthenticationManager authenticationManager;


    @Resource
    private PasswordEncoder passwordEncoder;

    //需要把token的信息放进mysql 生成的token 存放的表：oauth_access_token
    @Bean
    public TokenStore tokenStore() {
        //使用数据库来操作token
        return new InMemoryTokenStore();
    }


    /**
     * 这里先把服务写到内存里面 后续配置到mysql
     * 配置client服务详情(也就说有哪些服务可以来向我申请令牌)
     * see:org.springframework.security.oauth2.provider.authentication
     * 我这里假设我现在有一个游戏微服务game_client  一个网关微服务gateway_client
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

        clients
                // 基于内存存储
                .inMemory()
                // client_id
                .withClient("oauth2_client")
                // 加密
                .secret(passwordEncoder.encode("123456"))
                .accessTokenValiditySeconds(3600)
                // 资源id
                .resourceIds("provider-oauth2-server")
                // 授权模式
                .authorizedGrantTypes("password","refresh_token")
                // 允许授权的范围
                .scopes("all")
                .and()
                .withClient("user_client")
                .secret(passwordEncoder.encode("123456"))
                .resourceIds("provider-user-server")
                .authorizedGrantTypes("password","refresh_token")
                .scopes("app")
                ;
    }

    /**
     * 配置哪些可以访问认证服务器
     *
     * @param endpoints
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {

        endpoints
                .tokenStore(tokenStore())
                //authenticationManager校验传递进来的用户是否合法
                .authenticationManager(authenticationManager);
    }

    /**
     * 配置验证令牌的条件(即满足什么样的条件才能找我验证令牌 不是随便拿token也来验证)
     * 这里都先做一个最基本的配置
     *
     * @param security
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        //检验服务验证的规则 必须是经过验证的用户名,密码才给你验证令牌
        security.checkTokenAccess("isAuthenticated()");
    }
}
