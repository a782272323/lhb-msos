package lhb.msos.provider.oauth2.controller;

import lhb.msos.commons.utils.BaseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class OAuth2Controller {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("portal/222")
    public BaseResult test02() {
        return BaseResult.ok("测试绕过token");
    }


    /**
     * 获取授权用户信息
     * 一定要配置，否则别的服务认证会失败
     * @param principal
     * @return
     */
    @GetMapping("/oauth2/info")
    public Principal user(Principal principal) {
        logger.debug(principal.toString());
        System.out.println(principal.toString());
        return principal;
    }
}
