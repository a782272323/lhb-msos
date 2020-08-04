package lhb.msos.provider.user.controller;

import lhb.msos.commons.utils.BaseResult;
import lhb.msos.provider.user.remote.OAuth2Remote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private OAuth2Remote oAuth2Remote;


    @GetMapping("/user/test")
    public BaseResult test() {
        return BaseResult.ok("用户服务提供者测试");
    }

    @GetMapping("/user/feign")
    public BaseResult test01(@RequestParam("username") String username) {
        return oAuth2Remote.testFeign(username);
    }

    @GetMapping("lhb/test")
    public BaseResult test02() {
        return BaseResult.ok("lhb");
    }
}
