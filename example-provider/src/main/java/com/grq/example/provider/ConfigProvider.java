package com.grq.example.provider;

import com.grq.example.common.service.UserService;
import com.grq.myrpc.RpcApplication;
import com.grq.myrpc.registry.LocalRegistry;
import com.grq.myrpc.server.HttpServer;
import com.grq.myrpc.server.VertxHttpServer;

/**
 * 使用配置文件提供者示例
 */
public class ConfigProvider {
    public static void main(String[] args) {
        // RPC框架初始化
        RpcApplication.init();

        // 注册服务
        LocalRegistry.register(UserService.class.getName(), UserServiceImpl.class);

        // 根据配置文件端口，启动web服务
        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(RpcApplication.getRpcConfig().getServerPort());
    }
}
