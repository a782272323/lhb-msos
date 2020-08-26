package lhb.msos.provider.manager.user.dubbo;

import lhb.msos.commons.utils.BaseResult;
import lhb.msos.dubbo.user.ManagerUserDubbo;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Value;

/**
 * @Description  dubbo 远程调用实现类
 * @author Herbie Leung(梁鸿斌)
 * @date 2020/8/23
 * @time 11:09
 */
@Service(version = "1.0.0")
public class ManagerUserDubboImpl implements ManagerUserDubbo {

    @Value("${dubbo.protocol.port}")
    private String port;

    @Value("${server.port}")
    private String getPort;

    /**
     * 测试dubbo远程调用
     * @param string
     * @return
     */
    @Override
    public BaseResult echo(String string) {
        return BaseResult.ok("测试dubbo远程调用 " + string + ", dubbo-port = " + port +
                " ,application-port = " + getPort);
    }
}
