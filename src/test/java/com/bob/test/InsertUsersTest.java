package com.bob.test;

import com.bob.bobpal.BobPalApplication;
import com.bob.bobpal.mapper.UserMapper;
import com.bob.bobpal.model.domain.User;
import com.bob.bobpal.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StopWatch;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadPoolExecutor;

@SpringBootTest(classes = BobPalApplication.class)
public class InsertUsersTest {
    @Resource
    private UserService userService;

    /**
     * 插入用户
     */
    @Test
    public void doInsertUsers() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        final int INSERT_NUM = 100000;
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < INSERT_NUM; i++) {
            User user = new User();
            user.setUsername("假用户");
            user.setUserAccount("fakeBob");
            user.setAvatarUrl("https://cdn.nba.com/headshots/nba/latest/1040x760/1628369.png");
            user.setGender(0);
            user.setUserPassword("12345678");
            user.setPhone("123");
            user.setEmail("123@qq.com");
            user.setUserStatus(0);
            user.setUserRole(0);
            user.setPlanetCode("6666");
            userList.add(user);
        }
        //插入10w条数据耗时在20s内
        userService.saveBatch(userList,10000);
        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeMillis());
    }

    /**
     * 并发批量插入用户
     */
    @Test
    public void doConcurrencyInsertUsers() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        final int INSERT_NUM = 100000;
        //分10组，每组插入1w条
        int j = 0;
        List<CompletableFuture<Void>> futureList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            List<User> userList = new ArrayList<>();
            do {
                j++;
                User user = new User();
                user.setUsername("假用户");
                user.setUserAccount("fakeBob");
                user.setAvatarUrl("https://cdn.nba.com/headshots/nba/latest/1040x760/1628369.png");
                user.setGender(0);
                user.setUserPassword("12345678");
                user.setPhone("123");
                user.setEmail("123@qq.com");
                user.setUserStatus(0);
                user.setUserRole(0);
                user.setPlanetCode("6666");
                userList.add(user);
            } while (j % 10000 != 0);

            //里面执行的操作是异步的
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                System.out.println("threadName: "+Thread.currentThread().getName());
                userService.saveBatch(userList, 10000);
            });
            futureList.add(future);

        }
        CompletableFuture.allOf(futureList.toArray(new CompletableFuture[]{})).join();
        stopWatch.stop();
        //性能优化到了5s
        System.out.println(stopWatch.getTotalTimeMillis());
    }
}