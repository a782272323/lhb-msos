package lhb.msos.feign.qiniu.upload.fallback;

import com.qiniu.http.Response;
import lhb.msos.commons.utils.BaseResult;
import lhb.msos.feign.qiniu.upload.QiniuUploadFeign;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Description  熔断处理类
 * @author Herbie Leung(梁鸿斌)
 * @date 2020/8/10
 * @time 14:38
 */
@Component
public class QiniuUploadFeignFallback implements QiniuUploadFeign {


    @Override
    public BaseResult uploadOne(MultipartFile file, String key) throws Exception {
        return BaseResult.error("七牛文件上传服务出现异常");
    }

    @Override
    public Response deleteOne(String key) throws Exception {
        return null;
    }

    @Override
    public BaseResult ttt() {
        return null;
    }
}
