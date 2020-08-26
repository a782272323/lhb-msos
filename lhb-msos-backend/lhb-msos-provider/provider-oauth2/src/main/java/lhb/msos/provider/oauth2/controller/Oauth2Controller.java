package lhb.msos.provider.oauth2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @Description
 * @author Herbie Leung(梁鸿斌)
 * @date 2020/8/26
 * @time 14:10
 */
@RestController
public class Oauth2Controller {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

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
