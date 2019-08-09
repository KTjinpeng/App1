package cn.appsys.service.developer;

import cn.appsys.dao.appinfo.AppInfoMapper;
import cn.appsys.dao.appversion.AppVersionMapper;
import cn.appsys.pojo.AppVersion;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * App version service
 */
@Service
public class AppVersionServiceImpl implements AppVersionService {
    @Resource
    private AppVersionMapper mapper;

    @Resource
    private AppInfoMapper appInfoMapper;

    /**
     * Gets app version list *
     *
     * @param appId app id
     * @return the app version list
     * @throws Exception exception
     */
    @Override
    public List<AppVersion> getAppVersionList(Integer appId) throws Exception {
        return mapper.getAppVersionList(appId);
    }

    /**
     * Appsysadd boolean
     * 业务：新增app的版本信息
     * 1、app_verion表插入数据
     * 2、更新app_info表对应app的versionId字段（记录最新版本id）
     * 注意：事务控制
     *
     * @param appVersion app version
     * @return the boolean
     * @throws Exception exception
     */
    @Override
    public boolean appsysadd(AppVersion appVersion) throws Exception {
        boolean flag = false;
        Integer versionId = null;
        if (mapper.add(appVersion) > 0) {
            versionId = appVersion.getId();
            flag = true;
        }
        if (appInfoMapper.updateVersionId(versionId, appVersion.getAppId()) > 0 && flag) {
            flag = true;
        }
        return flag;
    }

    /**
     * Gets app version by id *
     *
     * @param id id
     * @return the app version by id
     * @throws Exception exception
     */
    @Override
    public AppVersion getAppVersionById(Integer id) throws Exception {
        return mapper.getAppVersionById(id);
    }

    /**
     * Modify boolean
     *
     * @param appVersion app version
     * @return the boolean
     * @throws Exception exception
     */
    @Override
    public boolean modify(AppVersion appVersion) throws Exception {
        Boolean flag = false;
        if (mapper.modify(appVersion) > 0) {
            flag = true;
        }
        return flag;
    }

    /**
     * Delete apk file boolean
     *
     * @param id id
     * @return the boolean
     * @throws Exception exception
     */
    @Override
    public boolean deleteApkFile(Integer id) throws Exception {
        Boolean flag =false;
        if (mapper.deleteApkFile(id)>0) {
            flag =true;
        }
        return flag;
    }
}
