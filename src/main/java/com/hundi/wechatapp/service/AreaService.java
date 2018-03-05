package com.hundi.wechatapp.service;

import com.hundi.wechatapp.entity.Area;

import java.util.List;

/**
 * @author LZHONG
 * @package com.hundi.wechatapp.service
 * @date 3/5/2018
 */
public interface AreaService {
    List<Area> queryArea();
    Area queryAreaById(int areaId);
    boolean insertArea(Area area);
    boolean updateArea(Area area);
    boolean deleteArea(int areaId);
}
