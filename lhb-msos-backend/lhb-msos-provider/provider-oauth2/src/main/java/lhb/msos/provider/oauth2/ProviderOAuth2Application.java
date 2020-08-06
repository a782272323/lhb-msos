package lhb.msos.provider.oauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * @Description
 * @author Herbie Leung(梁鸿斌)
 * @date 2020/8/3
 * @time 00:14
 */
@SpringBootApplication
@ComponentScan(basePackages = {"lhb.msos"})
@EnableDiscoveryClient
@EnableResourceServer
public class ProviderOAuth2Application {
    public static void main(String[] args) {
        SpringApplication.run(ProviderOAuth2Application.class, args);
    }
}
