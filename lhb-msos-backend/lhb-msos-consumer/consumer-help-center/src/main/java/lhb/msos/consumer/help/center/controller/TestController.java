package lhb.msos.consumer.help.center.controller;

import lhb.msos.commons.utils.BaseResult;
import lhb.msos.feign.user.UserFeign;
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

    @Autowired
    private UserFeign userFeign;

    @GetMapping("/help/center/test")
    public BaseResult test01() {
        return BaseResult.ok("帮助中心服务测试");
    }

    @GetMapping("/help/center/feign/test")
    public BaseResult feignTest() {
        return userFeign.test(serverName);
    }
}
