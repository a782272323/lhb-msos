package lhb.msos.feign.user.fallback;

import lhb.msos.commons.utils.BaseResult;
import lhb.msos.feign.user.UserFeign;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @author Herbie Leung(梁鸿斌)
 * @date 2020/8/5
 * @time 10:10
 */
@Component
public class UserFeignFallback implements UserFeign {

    @Override
    public BaseResult test(String name) {
        return BaseResult.error("用户服务远程调用出现异常!");
    }
}
