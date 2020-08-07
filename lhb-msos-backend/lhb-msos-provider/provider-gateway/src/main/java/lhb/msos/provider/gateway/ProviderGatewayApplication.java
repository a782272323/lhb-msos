package lhb.msos.provider.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description  启动类
 * @author Herbie Leung(梁鸿斌)
 * @date 2020/8/6
 * @time 17:00
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProviderGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderGatewayApplication.class, args);
    }
}