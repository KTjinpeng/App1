package cn.appsys.service.developer;

import cn.appsys.dao.devuser.DevUserMapper;
import cn.appsys.pojo.DevUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DevUserServiceImpl implements DevUserService {

    @Resource
    private DevUserMapper manager;

    /**
     * 前端传输开发者用户名和密码
     * 判断用户名是否存在   ----  yes
     * 则进行密码匹配
     * @param devCode
     * @param devPassword
     * @return
     * @throws Exception
     */
    @Override
    public DevUser login(String devCode, String devPassword) throws Exception {
        DevUser devUser = null;
        devUser = manager.getLoginUser(devCode);
        if (devUser != null) {
            if (!devUser.getDevPassword().equals(devPassword)) {
                devUser = null;
            }
        }
        return devUser;
    }
}
