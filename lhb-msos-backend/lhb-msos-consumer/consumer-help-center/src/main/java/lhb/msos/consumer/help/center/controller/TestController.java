package lhb.msos.consumer.help.center.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import lhb.msos.commons.utils.BaseResult;
import lhb.msos.consumer.help.center.handler.SentinelHandler;
import lhb.msos.feign.user.AppUserFeign;
import lhb.msos.feign.user.ManagerUserFeign;
import lhb.msos.feign.user.PortalUserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @author Herbie Leung(梁鸿斌)
 * @date 2020/8/5
 * @time 09:14
 */
@RestController
public class TestController {

    @Value("${spring.application.name}")
    private String serverName;

    @Value("${spring.mvc.date-format}")
    String dateFormat;

    @Autowired
    private AppUserFeign appUserFeign;

    @Autowired
    private PortalUserFeign portalUserFeign;

    @Autowired
    private ManagerUserFeign managerUserFeign;

    @GetMapping("/feign/test01")
    public BaseResult feignTest01() {
        return portalUserFeign.feign();
    }

    @GetMapping("/feign/test02")
    public BaseResult feignTest02() {
        return managerUserFeign.feign();
    }

    @GetMapping("/feign/test03")
    public BaseResult feignTest03() {
        return appUserFeign.feign();
    }

    @GetMapping("/help/center/test")
    public BaseResult test01() {
        return BaseResult.ok("帮助中心服务测试" + dateFormat);
    }


    /**
     * 测试 sentinel 限流熔断
     * @return
     */
    @SentinelResource(value = "sentinelTest",blockHandlerClass = SentinelHandler.class, blockHandler = "maxRequestHandleException")
    @GetMapping("/help/center/sentinel/test")
    public BaseResult sentinelTest() {
        return BaseResult.ok("sentinel限流熔断测试");
    }


}
