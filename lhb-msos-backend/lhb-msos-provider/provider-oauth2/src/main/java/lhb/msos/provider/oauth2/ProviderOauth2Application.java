package lhb.msos.provider.oauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Description  认证服务启动类
 * @author Herbie Leung(梁鸿斌)
 * @date 2020/8/26
 * @time 00:56
 */
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"lhb.msos"})
public class ProviderOauth2Application extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(ProviderOauth2Application.class, args);
    }

    /**
     * 为了打包springboot项目
     * @param builder
     * @return
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(this.getClass());
    }
}
