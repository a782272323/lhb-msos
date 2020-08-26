package lhb.msos.commons.base.config;


import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisConfig {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Bean
    public ConfigurationCustomizer mybatisConfigurationCustomizer() {
        return new ConfigurationCustomizer() {
            @Override
            public void customize(org.apache.ibatis.session.Configuration configuration) {
                logger.debug("MySQL数据库检查返回结果:Mybatis连接成功");
                System.out.println("MySQL数据库检查返回结果:Mybatis连接成功");
                configuration.setObjectWrapperFactory(new MapWrapperFactory());
            }
        };
    }
}