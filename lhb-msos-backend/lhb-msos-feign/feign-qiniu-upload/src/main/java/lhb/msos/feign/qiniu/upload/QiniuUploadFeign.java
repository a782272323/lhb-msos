package lhb.msos.feign.qiniu.upload;

import com.qiniu.http.Response;
import lhb.msos.commons.utils.BaseResult;
import lhb.msos.feign.qiniu.upload.fallback.QiniuUploadFeignFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Description  七牛文件上传服务远程调用
 * @author Herbie Leung(梁鸿斌)
 * @date 2020/8/10
 * @time 14:36
 */
@Component
@FeignClient(name = "provider-qiniu-upload", fallback = QiniuUploadFeignFallback.class)
public interface QiniuUploadFeign {

    /**
     * 单文件上传
     *
     * @param file
     * @param key
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/qiniu/upload/one", consumes = {"multipart/form-data"})
    public BaseResult uploadOne(@RequestPart("file") MultipartFile file,
                                @RequestParam("key") String key) throws Exception;

    /**
     * 删除单个文件
     *
     * @param key
     * @return
     */
    @GetMapping("/qiniu/delete/one/{key}")
    public Response deleteOne(@PathVariable("key") String key) throws Exception;

    @GetMapping("/qiniu/ttt")
    public BaseResult ttt();
}
