package lhb.msos.provider.file.service;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;

import java.io.File;
import java.io.InputStream;

/**
 * @Description  
 * @author Herbie Leung(梁鸿斌)
 * @date 2020/8/10
 * @time 10:48
 */
public interface QiniuUploadService {

    /**
     * 单文件上传（暂时废弃）
     * 以文件形式上传
     * @param file
     * @param key 图片名称
     * @return
     */
    String uploadFile(File file, String key) throws Exception;

    /**
     * 单文件上传
     * 以流的形式上传
     * @param inputStream
     * @return
     */
    String uploadFile(InputStream inputStream, String key) throws Exception;

    /**
     * 删除单个文件
     * @param key
     * @return
     * @throws QiniuException
     */
    Response deleteFile(String key) throws Exception;
}
