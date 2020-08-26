package lhb.msos.feign.user;

import lhb.msos.commons.utils.BaseResult;
import lhb.msos.feign.user.fallback.ManagerUserFeignFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Description  管理网站用户服务远程调用
 * @author Herbie Leung(梁鸿斌)
 * @date 2020/8/26
 * @time 19:58
 */
@Component
@FeignClient(name = "provider-manager-user", fallback = ManagerUserFeignFallback.class)
public interface ManagerUserFeign {

    /**
     * 用户服务feign远程调用测试
     * @return
     */
    @GetMapping("/manager/user/feign")
    public BaseResult test02();
}
