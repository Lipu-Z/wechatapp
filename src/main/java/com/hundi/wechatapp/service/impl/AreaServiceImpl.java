package com.hundi.wechatapp.service.impl;

import com.hundi.wechatapp.dao.AreaDao;
import com.hundi.wechatapp.entity.Area;
import com.hundi.wechatapp.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author LZHONG
 * @package com.hundi.wechatapp.service.impl
 * @date 3/5/2018
 */
@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaDao areaDao;

    @Override
    public List<Area> queryArea() {
        return areaDao.queryArea();
    }

    @Override
    public Area queryAreaById(int areaId) {
        return areaDao.queryAreaById(areaId);
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public boolean insertArea(Area area) {
        if (area.getAreaName() != null && area.getAreaName() != "") {
            area.setCreatTime(new Date());
            area.setLastEditTime(new Date());
            try {
                int effectedNum = areaDao.insertArea(area);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("failed to insert");
                }
            } catch (Exception e) {
                throw new RuntimeException("failed to insert " + e.getMessage());
            }
        } else {
            throw new RuntimeException("field should not be empty");
        }
    }


    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public boolean updateArea(Area area) {
        if (area.getAreaId() != null && area.getAreaName() != "") {
            area.setLastEditTime(new Date());
            try {
                int effectedNum = areaDao.updateArea(area);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("failed to update");
                }
            } catch (Exception e) {
                throw new RuntimeException("failed to update " + e.getMessage());
            }
        } else {
            throw new RuntimeException("field should not be empty");
        }
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public boolean deleteArea(int areaId) {
        if (areaId > 0) {
            try {
                int effectedNum = areaDao.deleteArea(areaId);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("failed to delete");
                }
            } catch (Exception e) {
                throw new RuntimeException("failed to delete " + e.getMessage());
            }
        } else {
            throw new RuntimeException("cant delete");
        }

    }
}
