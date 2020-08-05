package lhb.msos.feign.user;

import lhb.msos.commons.utils.BaseResult;
import lhb.msos.feign.user.fallback.UserFeignFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description  用户服务远程调用
 * @author Herbie Leung(梁鸿斌)
 * @date 2020/8/5
 * @time 10:07
 */
@Component
@FeignClient(name = "provider-user",fallback = UserFeignFallback.class)
public interface UserFeign {

    @GetMapping("/user/test")
    public BaseResult test(@RequestParam("name") String name);
}
