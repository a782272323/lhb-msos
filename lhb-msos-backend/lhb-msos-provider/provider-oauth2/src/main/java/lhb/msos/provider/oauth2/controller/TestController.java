package lhb.msos.provider.oauth2.controller;

import lhb.msos.commons.utils.BaseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @author Herbie Leung(梁鸿斌)
 * @date 2020/8/26
 * @time 01:06
 */
@RestController
public class TestController {

    @GetMapping("/oauth2/test")
    public BaseResult test() {
        return BaseResult.ok("认证服务启动测试");
    }
}
