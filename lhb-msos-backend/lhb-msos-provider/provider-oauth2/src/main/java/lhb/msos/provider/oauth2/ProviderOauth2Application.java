package lhb.msos.provider.oauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * @Description  认证服务启动类
 * @author Herbie Leung(梁鸿斌)
 * @date 2020/8/26
 * @time 00:56
 */
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"lhb.msos"})
//@EnableResourceServer
public class ProviderOauth2Application {
    public static void main(String[] args) {
        SpringApplication.run(ProviderOauth2Application.class, args);
    }
}
