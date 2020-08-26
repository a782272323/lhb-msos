package lhb.msos.feign.file.fallback;

import com.qiniu.http.Response;
import lhb.msos.commons.utils.BaseResult;
import lhb.msos.feign.file.QiniuFeign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class QiniuFeignFallback implements QiniuFeign {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public BaseResult uploadOne(MultipartFile file, String key) throws Exception {
        logger.debug("管理网站用户服务feign远程调用失败");
        return BaseResult.error("系统繁忙,请稍后重试");
    }

    @Override
    public Response deleteOne(String key) throws Exception {
        logger.debug("管理网站用户服务feign远程调用失败");
        return null;
    }
}
