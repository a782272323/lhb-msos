package lhb.msos.provider.user.controller;

import lhb.msos.commons.utils.BaseResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


    @Value("${spring.mvc.date-format}")
    private String nacosUrl;

    @Value("${server.port}")
    private String port;


    @GetMapping("/user/test")
    public BaseResult test(@RequestParam("name") String name) {
        return BaseResult.ok("用户服务提供者测试111,被" + name + "服务远程调用");
    }


    @GetMapping("lhb/test")
    public BaseResult test02() {
        return BaseResult.ok("lhb");
    }

    @GetMapping("/test/111")
    public BaseResult test03() {
        System.out.println("**** 111 ***");
        return BaseResult.ok("lhb111");
    }

    /**
     * 远程配置文件测试
     * @return
     */
    @GetMapping("/config/test")
    public BaseResult configTest() {
        return BaseResult.ok("nacos的url为 = " + nacosUrl);
    }

    /**
     * todo 负载均衡测试失败，有空解决
     * feign负载均衡测试
     * @return
     */
    @GetMapping("/port/test")
    public BaseResult portTest() {
        return BaseResult.ok("fegin负载均衡测试,端口号 = " + port);
    }
}
