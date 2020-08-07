package lhb.msos.feign.user.fallback;

import lhb.msos.commons.utils.BaseResult;
import lhb.msos.feign.user.AppUserFeign;
import org.springframework.stereotype.Component;

/**
 * @Description  小程序用户服务feign远程调用熔断类
 * @author Herbie Leung(梁鸿斌)
 * @date 2020/8/7
 * @time 10:47
 */
@Component
public class AppUserFeignFallback implements AppUserFeign {

    @Override
    public BaseResult feign() {
        return BaseResult.error("feign调用小程序用户服务出现异常");
    }
}
