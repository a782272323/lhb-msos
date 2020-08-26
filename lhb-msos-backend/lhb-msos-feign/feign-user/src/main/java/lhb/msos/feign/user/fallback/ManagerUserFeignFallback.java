package lhb.msos.feign.user.fallback;

import lhb.msos.commons.utils.BaseResult;
import lhb.msos.feign.user.ManagerUserFeign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Description  管理网站用户服务feign远程调用实现类
 * @author Herbie Leung(梁鸿斌)
 * @date 2020/8/26
 * @time 19:59
 */
@Component
public class ManagerUserFeignFallback implements ManagerUserFeign {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public BaseResult test02() {
        logger.debug("管理网站用户服务feign远程调用失败");
        return BaseResult.error("系统繁忙,请稍后重试");
    }
}
