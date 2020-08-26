package lhb.msos.provider.file;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(basePackages = {"lhb.msos"})
public class ProviderFileApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviderFileApplication.class, args);
    }
}
