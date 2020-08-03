package lhb.msos.oauth2.controller;

import lhb.msos.commons.utils.BaseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
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
        return BaseResult.ok("错误，权限分配没起作用");
    }
}
