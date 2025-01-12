package com.orange.jpa;

import com.alibaba.fastjson.JSONArray;
import com.orange.jpa.n.plus.one.JpaApplication;
import com.orange.jpa.n.plus.one.domain.Area;
import com.orange.jpa.n.plus.one.repository.AreaRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by xieyong on 2018/10/16 17:02.
 */
@SpringBootTest(classes = {JpaApplication.class})
@RunWith(SpringRunner.class)
public class AreaRepositoryTest {


    @Autowired
    private AreaRepository areaRepository;

    /**
     * 新增区域测试
     */
    @Test
    public void addArea() {

        // 广东省 (顶级区域)
        Area guangdong = new Area();
        guangdong.setName("广东省");
        areaRepository.save(guangdong);

        //广东省 下面的 广州市(二级区域)
        Area guangzhou = new Area();
        guangzhou.setName("广州市");
        guangzhou.setParent(guangdong);
        areaRepository.save(guangzhou);

        //广州市 下面的 天河区(三级区域)
        Area tianhe = new Area();
        tianhe.setName("天河区");
        tianhe.setParent(guangzhou);
        areaRepository.save(tianhe);

        //广东省 下面的 湛江市(二级区域)
        Area zhanjiang = new Area();
        zhanjiang.setName("湛江市");
        zhanjiang.setParent(guangdong);
        areaRepository.save(zhanjiang);

        //湛江市 下面的 霞山区(三级区域)
        Area xiashan = new Area();
        xiashan.setName("霞山区");
        xiashan.setParent(zhanjiang);
        areaRepository.save(xiashan);

    }


    /**
     * 触发懒加载查询 典型的 N+1 现象
     */
    @Test
    @Transactional
    public void findAllArea() {
        List<Area> areas = areaRepository.findAll();
        System.out.println(JSONArray.toJSONString(areas.get(0)));
    }
}
