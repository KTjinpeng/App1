package cn.appsys.service.backend;
import cn.appsys.pojo.BackendUser;

public interface BackendUserService {
    /**
     * 后台用户登录
     * @param userCode
     * @param userPassword
     * @return
     */
    public BackendUser login(String userCode,String userPassword) throws Exception;
}
