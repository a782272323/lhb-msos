package lhb.msos.provider.manager.user.controller;

import lhb.msos.commons.utils.BaseResult;
import lhb.msos.feign.file.QiniuFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Description
 * @author Herbie Leung(梁鸿斌)
 * @date 2020/8/24
 * @time 01:21
 */
@RestController
public class TestController {

    @Value("${spring.mvc.date-format}")
    private String dataFormat;

    @Autowired
    private QiniuFeign qiniuFeign;

    /**
     * 服务启动测试
     * @return
     */
    @GetMapping("/manager/user/test")
    public BaseResult test() {
        return BaseResult.ok("后台管理网站用户服务启动测试");
    }

    /**
     * 测试外部化配置
     * @return
     */
    @GetMapping("/manager/user/config")
    public BaseResult test01() {
        return BaseResult.ok("外部化配置文件设置 = " + dataFormat);
//        return BaseResult.ok("外部化配置文件设置");
    }

    /**
     * feign远程调用测试
     * @return
     */
    @PostMapping("/manager/user/feign")
    public BaseResult test02() {
        return BaseResult.ok("用户服务feign远程调用测试");
    }

    /**
     * 七牛文件上传服务远程调用测试
     * @param file
     * @param key
     * @return
     * @throws Exception
     */
    @PostMapping("/manager/user/feign/upload")
    public BaseResult feignUpload(@RequestPart("file") MultipartFile file,
                                  @RequestParam("key") String key) throws Exception{
        return qiniuFeign.uploadOne(file, key);
    }
}
