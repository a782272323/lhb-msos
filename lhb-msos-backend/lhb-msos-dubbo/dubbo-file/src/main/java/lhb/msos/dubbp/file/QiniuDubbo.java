package lhb.msos.dubbp.file;

import lhb.msos.commons.utils.BaseResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Description  七牛图片上传删除远程调用
 * @author Herbie Leung(梁鸿斌)
 * @date 2020/8/26
 * @time 19:28
 */
public interface QiniuDubbo {

    /**
     * 七牛图片上传
     * @param file
     * @param key
     * @return
     */
    BaseResult dubboUploadOne(MultipartFile file, String key) throws Exception;
}
