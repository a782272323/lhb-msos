package lhb.msos.feign.user;

import lhb.msos.commons.utils.BaseResult;
import lhb.msos.feign.user.fallback.AppUserFeignFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Description  小程序feign远程调用
 * @author Herbie Leung(梁鸿斌)
 * @date 2020/8/7
 * @time 10:46
 */
@Component
@FeignClient(name = "provider-app-user", fallback = AppUserFeignFallback.class)
public interface AppUserFeign {

    @GetMapping("/app/user/feign")
    public BaseResult feign();
}
