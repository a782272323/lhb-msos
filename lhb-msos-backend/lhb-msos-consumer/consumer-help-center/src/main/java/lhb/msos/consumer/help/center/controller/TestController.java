package lhb.msos.consumer.help.center.controller;

import lhb.msos.commons.utils.BaseResult;
import lhb.msos.dubbo.user.ManagerUserDubbo;
import lhb.msos.dubbp.file.QiniuDubbo;
import lhb.msos.feign.user.ManagerUserFeign;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Description
 * @author Herbie Leung(梁鸿斌)
 * @date 2020/8/24
 * @time 01:59
 */
@RestController
public class TestController {

    @Reference(version = "1.0.0")
    private ManagerUserDubbo managerUserDubbo;

    @Reference(version = "1.0.0")
    private QiniuDubbo qiniuDubbo;

    @Autowired
    private ManagerUserFeign managerUserFeign;

    /**
     * 服务启动测试
     * @return
     */
    @GetMapping("/help/center/test")
    public BaseResult test01() {
        return BaseResult.ok("帮助中心服务启动测试");
    }

    /**
     * dubbo远程调用测试
     * @return
     */
    @GetMapping("/help/center/dubbo/test")
    public BaseResult test02() {
        return managerUserDubbo.echo("dubbo测试,");
    }

    /**
     * dubbo远程调用七牛图片上传测试(暂时废弃) todo 有空修复
     * @param file
     * @param key
     * @return
     * @throws Exception
     */
    @PostMapping("/help/center/dubbo/qiniu")
    public BaseResult test03(MultipartFile file, String key) throws Exception{
        return qiniuDubbo.dubboUploadOne(file, key);
    }

    /**
     * feign远程调用测试
     * @return
     */
    @GetMapping("/help/center/feign")
    public BaseResult test04() {
        return managerUserFeign.test02();
    }
}
