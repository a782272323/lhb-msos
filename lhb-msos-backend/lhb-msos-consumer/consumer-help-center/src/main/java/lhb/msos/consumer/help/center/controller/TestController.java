package lhb.msos.consumer.help.center.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.SentinelRpcException;
import com.google.common.collect.Maps;
import lhb.msos.commons.constant.HttpConstant;
import lhb.msos.commons.constant.ResponseConstant;
import lhb.msos.commons.utils.BaseResult;
import lhb.msos.consumer.help.center.handler.SentinelHandler;
import lhb.msos.feign.user.UserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

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

    /**
     * todo 远程调用时，token出现权限认证失败
     * 测试远程调用
     * @return
     */
    @GetMapping("/help/center/feign/test")
    public BaseResult feignTest() {
        return userFeign.test(serverName);
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

    /**
     * 负载均衡测试
     * @return
     */
    @GetMapping("port")
    public BaseResult port() {
        return userFeign.portTest();
    }
}
