package lhb.msos.feign.user;

import lhb.msos.commons.utils.BaseResult;
import lhb.msos.feign.user.fallback.ManagerUserFeignFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Description  管理网站用户服务远程调用
 * @author Herbie Leung(梁鸿斌)
 * @date 2020/8/7
 * @time 10:44
 */
@Component
@FeignClient(name = "provider-manager-user", fallback = ManagerUserFeignFallback.class)
public interface ManagerUserFeign {

    @GetMapping("/feign")
    public BaseResult feign();
}
