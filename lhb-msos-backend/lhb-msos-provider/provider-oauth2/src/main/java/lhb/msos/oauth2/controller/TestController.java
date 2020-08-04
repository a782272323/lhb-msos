package lhb.msos.oauth2.controller;

import lhb.msos.commons.utils.BaseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description  测试oauth2是否搭建完成
 * @author Herbie Leung(梁鸿斌)
 * @date 2020/8/3
 * @time 15:26
 */
@RestController
public class TestController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 资源服务的ID，在单体写死，在微服务中根据服务来动态注入
     */
    @Value("${spring.application.name}")
    private String RESOURCE_ID;

    @GetMapping("/lhb/111")
    public BaseResult test01() {
        return BaseResult.ok("拥有资源ppp访问成功");
    }

    @GetMapping("portal/222")
    public BaseResult test02() {
        return BaseResult.ok("测试绕过token");
    }

    @GetMapping("/admin/333")
    public BaseResult test03() {
        return BaseResult.ok("登录成功，就可以访问了");
    }

    @GetMapping("/test/v1")
    public BaseResult test04() {
        return BaseResult.ok("登录成功，但没有权限访问");
    }

    @GetMapping("/feign")
    public BaseResult test05(@RequestParam("username")String username) {
        return BaseResult.ok(username + ", feign远程调用测试," + RESOURCE_ID);
    }
}
