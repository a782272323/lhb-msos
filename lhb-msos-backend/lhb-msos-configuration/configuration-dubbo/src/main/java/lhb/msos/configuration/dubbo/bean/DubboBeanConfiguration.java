package lhb.msos.configuration.dubbo.bean;

/**
 * @Description  dubbo 启动加载bean
 * @author Herbie Leung(梁鸿斌)
 * @date 2020/8/24
 * @time 01:35
 */

import org.apache.dubbo.spring.boot.actuate.endpoint.metadata.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DubboBeanConfiguration {
    @Bean
    public DubboMetadata DubboMetadataBean() {
        return new DubboMetadata();
    }

    @Bean
    public DubboConfigsMetadata DubboConfigsMetadataBean() {
        return new DubboConfigsMetadata();
    }

    @Bean
    public DubboPropertiesMetadata DubboPropertiesMetadataBean() {
        return new DubboPropertiesMetadata();
    }

    @Bean
    public DubboReferencesMetadata DubboReferencesMetadataBean() {
        return new DubboReferencesMetadata();
    }

    @Bean
    public DubboServicesMetadata DubboServicesMetadataBean() {
        return new DubboServicesMetadata();
    }

    @Bean
    public DubboShutdownMetadata DubboShutdownMetadataBean() {
        return new DubboShutdownMetadata();
    }

}
