package cn.appsys.service.developer;

import cn.appsys.pojo.DevUser;

public interface DevUserService {
    /**
     * 开发者登录
     * @param devCode
     * @param devPassword
     * @return
     * @throws Exception
     */
    public DevUser login(String devCode, String devPassword) throws Exception;

}
