package lhb.msos.provider.qiniu.upload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Description  启动类
 * @author Herbie Leung(梁鸿斌)
 * @date 2020/8/10
 * @time 09:52
 */
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"lhb.msos"})
public class ProviderQiniuUploadApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviderQiniuUploadApplication.class, args);
    }
}
