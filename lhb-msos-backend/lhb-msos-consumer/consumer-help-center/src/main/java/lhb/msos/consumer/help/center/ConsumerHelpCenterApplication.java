package lhb.msos.consumer.help.center;

import lhb.msos.configuration.dubbo.bean.DubboBeanConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Description  
 * @author Herbie Leung(梁鸿斌)
 * @date 2020/8/24 
 * @time 23:05
 */
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"lhb.msos"})
@EnableFeignClients(basePackages = "lhb.msos.feign.*")
public class ConsumerHelpCenterApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerHelpCenterApplication.class, args);
    }
}
