package lhb.msos.provider.qiniu.upload.controller;

import com.google.common.collect.Maps;
import com.qiniu.http.Response;
import lhb.msos.commons.constant.HttpConstant;
import lhb.msos.commons.constant.ResponseConstant;
import lhb.msos.commons.utils.BaseResult;
import lhb.msos.provider.qiniu.upload.service.QiniuUploadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * @Description
 * @author Herbie Leung(梁鸿斌)
 * @date 2020/8/10
 * @time 11:11
 */
@RestController
@RequestMapping("/qiniu")
public class QiniuUploadController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private QiniuUploadService qiniuUploadService;

    /**
     * 单文件上传
     * @param file
     * @return
     */
    @PostMapping("/upload/one")
    public BaseResult uploadOne(@RequestPart("file") MultipartFile file,
                                @RequestParam("key") String key) throws Exception{
        Map<String, Object> map = Maps.newHashMap();
        map.put("url", qiniuUploadService.uploadFile(file.getInputStream(), key));
        return BaseResult.ok().put(
                HttpConstant.OK,
                HttpConstant.UPLOAD_MESSAGE,
                ResponseConstant.DATA,
                map);
    }

    /**
     * 删除单个文件
     * @param key
     * @return
     */
    @GetMapping("/delete/one/{key}")
    public Response deleteOne(@PathVariable("key") String key) throws Exception{
        Map<String, Object> map = Maps.newHashMap();
        Response response = qiniuUploadService.deleteFile(key);
        map.put("response", response);
        return response;
    }

    @GetMapping("ttt")
    public BaseResult ttt() {
        return BaseResult.ok("ttt");
    }
}
