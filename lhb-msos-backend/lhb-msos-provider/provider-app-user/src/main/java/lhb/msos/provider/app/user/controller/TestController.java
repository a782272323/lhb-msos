package lhb.msos.provider.app.user.controller;

import lhb.msos.commons.utils.BaseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description  测试控制层
 * @author Herbie Leung(梁鸿斌)
 * @date 2020/8/7
 * @time 10:24
 */
@RestController
//@RequestMapping("")
public class TestController {

    /**
     * 测试不带token访问
     * @return
     */
    @GetMapping("/web/app/user/token")
    public BaseResult webToken() {
        return BaseResult.ok("小程序用户服务测试不带token访问");
    }

    @GetMapping("/app/user/gateway")
    public BaseResult gateway() {
        return BaseResult.ok("小程序用户服务网关测试");
    }

    @GetMapping("/app/user/test01")
    public BaseResult test01() {
        return BaseResult.ok("小程序用户服务启动测试");
    }

    @GetMapping("/app/user/feign")
    public BaseResult feign() {
        return BaseResult.ok("小程序用户服务feign远程调用测试");
    }
}
