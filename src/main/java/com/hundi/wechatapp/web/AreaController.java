package com.hundi.wechatapp.web;

import com.hundi.wechatapp.entity.Area;
import com.hundi.wechatapp.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LZHONG
 * @package com.hundi.wechatapp.web
 * @date 3/5/2018
 */
@RestController
@RequestMapping("/superadmin")
public class AreaController {
    @Autowired
    private AreaService areaService;

    @RequestMapping(value="/listarea", method= RequestMethod.GET)
    private Map<String , Object> listArea(){
        Map<String,Object> modelMap = new HashMap<String,Object>();
        List<Area> list = areaService.getAreaList();
        modelMap.put("areaList",list);
        return modelMap;
    }

    @RequestMapping(value="/getAreaById", method= RequestMethod.GET)
    private Map<String , Object> getAreaById(Integer areaId){
        Map<String,Object> modelMap = new HashMap<String,Object>();
        Area area = areaService.queryAreaById(areaId);
        modelMap.put("areaInfo",area);
        return modelMap;
    }

    @RequestMapping(value="/addArea", method= RequestMethod.POST)
    private Map<String , Object> addArea(@RequestBody Area area){
        Map<String,Object> modelMap = new HashMap<String,Object>();
        modelMap.put("success", areaService.insertArea(area));
        return modelMap;
    }

    @RequestMapping(value="/modifyArea", method= RequestMethod.POST)
    private Map<String , Object> modifyArea(@RequestBody Area area){
        Map<String,Object> modelMap = new HashMap<String,Object>();
        modelMap.put("success", areaService.updateArea(area));
        return modelMap;
    }

    @RequestMapping(value="/removeArea", method= RequestMethod.GET)
    private Map<String , Object> removeArea(Integer Id){
        Map<String,Object> modelMap = new HashMap<String,Object>();
        modelMap.put("success", areaService.deleteArea(Id));
        return modelMap;
    }
}
