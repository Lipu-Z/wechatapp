package com.hundi.wechatapp.dao;

import com.hundi.wechatapp.entity.Area;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author LZHONG
 * @package com.hundi.wechatapp.dao
 * @date 3/5/2018
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaDaoTest {
    @Autowired
    private AreaDao areaDao;
    @Test
    public void queryArea() throws Exception {
        List<Area> areaList = areaDao.queryArea();
        assertEquals(2,areaList.size());
    }

    @Test
    public void queryAreaById() throws Exception {
        Area area = areaDao.queryAreaById(1);
        assertEquals(1, (long)area.getAreaId());
    }

    @Test
    public void insertArea() throws Exception {
    }

    @Test
    public void updateAre() throws Exception {
    }

    @Test
    public void deleteArea() throws Exception {
    }

}