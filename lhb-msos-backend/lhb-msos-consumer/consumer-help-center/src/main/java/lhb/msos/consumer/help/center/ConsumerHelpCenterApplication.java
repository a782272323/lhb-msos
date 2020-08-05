package lhb.msos.consumer.help.center;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Description  启动类
 * @author Herbie Leung(梁鸿斌)
 * @date 2020/8/5
 * @time 09:00
 */
@SpringBootApplication(scanBasePackages = {"lhb.msos"})
@EnableDiscoveryClient
@ComponentScan(basePackages = {"lhb.msos"})
@EnableFeignClients(basePackages = "lhb.msos.feign.*")
public class ConsumerHelpCenterApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerHelpCenterApplication.class, args);
    }
}
