package lhb.msos.provider.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProviderGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviderGatewayApplication.class, args);
    }
}
