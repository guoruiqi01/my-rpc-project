package com.grq.example.provider;

import com.grq.example.common.service.UserService;
import com.grq.myrpc.registry.LocalRegistry;
import com.grq.myrpc.server.HttpServer;
import com.grq.myrpc.server.VertxHttpServer;

/**
 * 简易服务提供者示例
 */
public class EasyProviderExample {
    public static void main(String[] args) {
        // 注册服务
        LocalRegistry.register(UserService.class.getName(), UserServiceImpl.class);

        // 启动web服务
        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(8080);
    }
}
