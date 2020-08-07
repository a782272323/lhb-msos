package lhb.msos.feign.user.fallback;

import lhb.msos.commons.utils.BaseResult;
import lhb.msos.feign.user.PortalUserFeign;

/**
 * @Description  熔断
 * @author Herbie Leung(梁鸿斌)
 * @date 2020/8/7
 * @time 10:49
 */
public class PortalUserFeignFallback implements PortalUserFeign {
    @Override
    public BaseResult feign() {
        return BaseResult.error("feign调用门户网站用户服务出现异常");
    }
}
