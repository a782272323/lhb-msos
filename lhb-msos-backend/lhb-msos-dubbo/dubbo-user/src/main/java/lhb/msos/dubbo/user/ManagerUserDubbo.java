package lhb.msos.dubbo.user;

import lhb.msos.commons.utils.BaseResult;

/**
 * @Description  dubbo api
 * @author Herbie Leung(梁鸿斌)
 * @date 2020/8/23
 * @time 10:04
 */
public interface ManagerUserDubbo {

    /**
     * 测试dubbo远程调用
     * @param string
     * @return
     */
    BaseResult echo(String string);
}
