package com.grq.example.consumer;

import com.grq.example.common.model.User;
import com.grq.example.common.service.UserService;
import com.grq.myrpc.bootstrap.ConsumerBootstrap;
import com.grq.myrpc.proxy.ServiceProxyFactory;

/**
 * 简易服务消费者示例
 */
public class CallConsumer {

    public static void main(String[] args) {
        // 服务提供者初始化
        ConsumerBootstrap.init();

        // 获取代理
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
    }
}

