package com.hundi.wechatapp.dao;

import com.hundi.wechatapp.entity.Area;

import java.util.List;

/**
 * @author LZHONG
 * @package com.hundi.wechatapp.dao
 * @date 3/5/2018
 */
public interface AreaDao {
    List<Area> queryArea();
    Area queryAreaById(int areaId);
    int insertArea(Area area);
    int updateAre(Area area);
    int deleteArea(int areaId);
}
