package cn.appsys.service.backend;

import cn.appsys.dao.backenduser.BackendUserMapper;
import cn.appsys.pojo.BackendUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BackendUserServiceImpl implements BackendUserService {
    @Resource
    BackendUserMapper manager;

    /**
     * 前端传输用户名和密码
     * 判断用户名是否存在   ----yes
     * 则进行密码匹配
     *
     * @param userCode
     * @param userPassword
     * @return
     * @throws Exception
     */
    @Override
    public BackendUser login(String userCode, String userPassword) throws Exception {
        BackendUser user = null;
        user = manager.getLoginUser(userCode);
        //匹配密码
        if (user != null) {
            if (!user.getUserPassword().equals(userPassword)) {
                user = null;
            }
        }
        return user;
    }
}
