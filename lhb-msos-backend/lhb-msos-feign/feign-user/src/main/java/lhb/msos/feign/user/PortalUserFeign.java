package lhb.msos.feign.user;

import lhb.msos.commons.utils.BaseResult;
import lhb.msos.feign.user.fallback.PortalUserFeignFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Description  门户网站用户服务远程调用
 * @author Herbie Leung(梁鸿斌)
 * @date 2020/8/7
 * @time 10:48
 */
@Component
@FeignClient(name = "provider-portal-user", fallback = PortalUserFeignFallback.class)
public interface PortalUserFeign {

    @GetMapping("/feign")
    public BaseResult feign();
}
