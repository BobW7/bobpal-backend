package com.bob.test;

import com.bob.bobpal.BobPalApplication;
import org.junit.jupiter.api.Test;
import org.redisson.api.RList;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest(classes = BobPalApplication.class)
public class RedissonTest {

    @Resource
    private RedissonClient redissonClient;
    @Test
    void test(){
        //list  发现和用java集合一毛一样！！！
        List<String> list =new ArrayList<>();
        list.add("bob");
        System.out.println(list.get(0));
            list.remove(0);

            //RList继承了List接口，自己做的一些重写
        RList<String> rList = redissonClient.getList("testList");//设置key
        rList.add("bob");
        System.out.println(rList.get(0));
          rList.remove(0);
        //map
        Map<String,Integer> map = new HashMap<>();
        map.put("Bob",100);
        System.out.println(map.get("Bob"));
        //set
        RMap<String, Integer> rMap = redissonClient.getMap("testMap");
        rMap.put("rBob",100);
        System.out.println(rMap.get("rBob"));
    }
}
