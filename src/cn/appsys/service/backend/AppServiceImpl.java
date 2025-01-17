package cn.appsys.service.backend;

import cn.appsys.dao.appinfo.AppInfoMapper;
import cn.appsys.pojo.AppInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AppServiceImpl implements AppService {
    @Resource
    private AppInfoMapper mapper;
    @Override
    public List<AppInfo> getAppInfoList(String querySoftwareName, Integer queryCategoryLevel1, Integer queryCategoryLevel2, Integer queryCategoryLevel3, Integer queryFlatformId, Integer currentPageNo, Integer pageSize) throws Exception {
        return mapper.getAppInfoList(querySoftwareName, 1, queryCategoryLevel1, queryCategoryLevel2,
                queryCategoryLevel3, queryFlatformId, null, (currentPageNo - 1) * pageSize, pageSize);
    }
    @Override
    public int getAppInfoCount(String querySoftwareName, Integer queryCategoryLevel1, Integer queryCategoryLevel2, Integer queryCategoryLevel3, Integer queryFlatformId) throws Exception {
        return mapper.getAppInfoCount(querySoftwareName, 1, queryCategoryLevel1, queryCategoryLevel2,
                queryCategoryLevel3, queryFlatformId, null);
    }
    @Override
    public AppInfo getAppInfo(Integer id) throws Exception {
        return mapper.getAppInfo(id, null);
    }
    @Override
    public boolean updateSatus(Integer status, Integer id) throws Exception {
        boolean flag = false;
        if (mapper.updateSatus(status, id) > 0) {
            flag = true;
        }
        return flag;
    }
}