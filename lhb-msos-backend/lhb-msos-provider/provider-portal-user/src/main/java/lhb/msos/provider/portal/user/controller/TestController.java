package lhb.msos.provider.portal.user.controller;

import lhb.msos.commons.utils.BaseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @author Herbie Leung(梁鸿斌)
 * @date 2020/8/26
 * @time 17:56
 */
@RestController
public class TestController {

    @GetMapping("/portal/user/test")
    public BaseResult test() {
        return BaseResult.ok("门户网站用户服务启动测试");
    }
}
