package lhb.msos.provider.manager.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Description  启动类
 * @author Herbie Leung(梁鸿斌)
 * @date 2020/8/7
 * @time 10:16
 */
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"lhb.msos"})
public class ProviderManagerUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviderManagerUserApplication.class, args);
    }
}
