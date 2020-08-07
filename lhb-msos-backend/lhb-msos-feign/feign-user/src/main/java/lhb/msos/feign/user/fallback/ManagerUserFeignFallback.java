package lhb.msos.feign.user.fallback;

import lhb.msos.commons.utils.BaseResult;
import lhb.msos.feign.user.ManagerUserFeign;
import org.springframework.stereotype.Component;

/**
 * @Description  管理网站用户服务远程调用熔断类
 * @author Herbie Leung(梁鸿斌)
 * @date 2020/8/7
 * @time 10:45
 */
@Component
public class ManagerUserFeignFallback implements ManagerUserFeign {

    @Override
    public BaseResult feign() {
        return BaseResult.error("feign调用管理网站用户服务出现异常");
    }
}
