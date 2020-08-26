package lhb.msos.provider.file.dubbo;

import com.google.common.collect.Maps;
import lhb.msos.commons.constant.HttpConstant;
import lhb.msos.commons.constant.ResponseConstant;
import lhb.msos.commons.utils.BaseResult;
import lhb.msos.dubbp.file.QiniuDubbo;
import lhb.msos.provider.file.service.QiniuUploadService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * @Description  七牛图片上传实现类
 * @author Herbie Leung(梁鸿斌)
 * @date 2020/8/26
 * @time 19:32
 */
@Service(version = "1.0.0")
public class QiniuDubboImpl implements QiniuDubbo {

    @Autowired
    private QiniuUploadService qiniuUploadService;

    /**
     * 七牛图片上传
     * @param file
     * @param key
     * @return
     */
    @Override
    public BaseResult dubboUploadOne(MultipartFile file, String key) throws Exception{
        Map<String, Object> map = Maps.newHashMap();
        map.put("url", qiniuUploadService.uploadFile(file.getInputStream(), key));
        return BaseResult.ok().put(
                HttpConstant.OK,
                HttpConstant.UPLOAD_MESSAGE,
                ResponseConstant.DATA,
                map);
    }
}
