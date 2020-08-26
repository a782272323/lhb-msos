package lhb.msos.feign.file;

import com.qiniu.http.Response;
import lhb.msos.commons.utils.BaseResult;
import lhb.msos.feign.file.fallback.QiniuFeignFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Description  七牛图片上传服务feign远程调用
 * @author Herbie Leung(梁鸿斌)
 * @date 2020/8/26
 * @time 20:38
 */
@Component
@FeignClient(name = "provider-file", fallback = QiniuFeignFallback.class)
public interface QiniuFeign {

    /**
     * 单文件上传
     *
     * @param file
     * @param key
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/file/qiniu/upload/one", consumes = {"multipart/form-data"})
    public BaseResult uploadOne(@RequestPart("file") MultipartFile file,
                                @RequestParam("key") String key) throws Exception;

    /**
     * 删除单个文件
     *
     * @param key
     * @return
     */
    @GetMapping("/file/qiniu/delete/one/{key}")
    public Response deleteOne(@PathVariable("key") String key) throws Exception;

}
