package lhb.msos.provider.manager.user.controller;

import lhb.msos.commons.utils.BaseResult;
import lhb.msos.feign.qiniu.upload.QiniuUploadFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Description  测试控制层
 * @author Herbie Leung(梁鸿斌)
 * @date 2020/8/7
 * @time 10:24
 */
@RestController
@RequestMapping("/manager/user")
public class TestController {

    @Autowired
    private QiniuUploadFeign qiniuUploadFeign;

    /**
     * 测试不带token访问
     * @return
     */
    @GetMapping("/web/token")
    public BaseResult webToken() {
        return BaseResult.ok("管理网站用户服务测试不带token访问");
    }

    @GetMapping("/gateway")
    public BaseResult gateway() {
        return BaseResult.ok("管理网站用户服务网关测试");
    }

    @GetMapping("/test01")
    public BaseResult test01() {
        return BaseResult.ok("管理网站用户服务启动测试");
    }

    @GetMapping("/feign")
    public BaseResult feign() {
        return BaseResult.ok("管理网站用户服务feign远程调用测试");
    }

    @GetMapping("/ttt")
    public BaseResult ttt() {
        return qiniuUploadFeign.ttt();
    }

    /**
     * 七牛文件上传服务远程调用测试
     * @param file
     * @param key
     * @return
     * @throws Exception
     */
    @PostMapping("/feign/upload")
    public BaseResult feignUpload(@RequestPart("file") MultipartFile file,
                                  @RequestParam("key") String key) throws Exception{
        return qiniuUploadFeign.uploadOne(file, key);
    }

}
