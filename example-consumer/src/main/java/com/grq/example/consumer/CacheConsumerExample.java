package com.grq.example.consumer;

import com.grq.example.common.model.User;
import com.grq.example.common.service.UserService;
import com.grq.myrpc.proxy.ServiceProxyFactory;

/**
 * 简易服务消费者示例
 */
public class CacheConsumerExample {
    public static void main(String[] args) {
        // 静态代理
        // UserService userService = new UserServiceProxy();

        // 动态代理
        UserService userService = ServiceProxyFactory.getProxy(UserService.class);
        User user = new User();
        user.setName("grq");

        // 调用
        User newUser = userService.getUser(user);
        if (newUser != null) {
            System.out.println(newUser.getName());
        } else {
            System.out.println("user == null");
        }
        long number = userService.getNumber();
        System.out.println(number);


        long number1 = userService.getNumber();
        System.out.println(number1);

        for (int i = 0; i < 20; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        long number2 = userService.getNumber();
        System.out.println(number2);



    }
}
