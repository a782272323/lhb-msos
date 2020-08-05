package lhb.msos.consumer.help.center.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.google.common.collect.Maps;
import lhb.msos.commons.constant.HttpConstant;
import lhb.msos.commons.constant.ResponseConstant;
import lhb.msos.commons.utils.BaseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Description  sentinel 异常处理类 todo 有空搞成全局异常处理
 * @author Herbie Leung(梁鸿斌)
 * @date 2020/8/5
 * @time 17:03
 */
@Component
public class SentinelHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * todo 全局异常统一处理要搞
     * 到达sentinel限流设置的最大阀值/上限
     * @param exception
     * @return
     */
    public BaseResult maxRequestHandleException(BlockException exception) {
        logger.error("该接口已经达到最大阀值!");
        Map<String, Object> map = Maps.newHashMap();
        map.put("errorMsg", exception.getClass().getCanonicalName());
        return BaseResult.error().put(HttpConstant.MAX_REQUEST,
                HttpConstant.MAX_REQUEST_MESSAGE,
                ResponseConstant.DATA,
                map);

    }
}
