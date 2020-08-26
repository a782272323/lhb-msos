package lhb.msos.provider.manager.user;


import lhb.msos.configuration.dubbo.bean.DubboBeanConfiguration;
import org.apache.dubbo.spring.boot.actuate.endpoint.metadata.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Description  启动类
 * @author Herbie Leung(梁鸿斌)
 * @date 2020/8/23
 * @time 11:07
 */
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"lhb.msos"})
@EnableFeignClients(basePackages = "lhb.msos.feign.*")
public class ProviderManagerUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviderManagerUserApplication.class, args);
    }
}
