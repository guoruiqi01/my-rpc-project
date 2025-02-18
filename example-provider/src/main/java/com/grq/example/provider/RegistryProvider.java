package com.grq.example.provider;

import cn.hutool.core.net.NetUtil;
import com.grq.example.common.service.UserService;
import com.grq.myrpc.RpcApplication;
import com.grq.myrpc.config.RegistryConfig;
import com.grq.myrpc.config.RpcConfig;
import com.grq.myrpc.model.ServiceMetaInfo;
import com.grq.myrpc.registry.LocalRegistry;
import com.grq.myrpc.registry.Registry;
import com.grq.myrpc.registry.RegistryFactory;
import com.grq.myrpc.server.HttpServer;
import com.grq.myrpc.server.VertxHttpServer;


/**
 * 服务提供者示例
 */
public class RegistryProvider {

    public static void main(String[] args) {
        // RPC 框架初始化
        RpcApplication.init();

        // 注册服务
        String serviceName = UserService.class.getName();
        LocalRegistry.register(serviceName, UserServiceImpl.class);

        // 注册服务到注册中心
        RpcConfig rpcConfig = RpcApplication.getRpcConfig();
        RegistryConfig registryConfig = rpcConfig.getRegistryConfig();
        Registry registry = RegistryFactory.getInstance(registryConfig.getRegistry());
        ServiceMetaInfo serviceMetaInfo = new ServiceMetaInfo();
        serviceMetaInfo.setServiceName(serviceName);
        serviceMetaInfo.setServiceHost(rpcConfig.getServerHost());
        serviceMetaInfo.setServicePort(rpcConfig.getServerPort());
        try {
            registry.register(serviceMetaInfo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // 启动 web 服务
        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(RpcApplication.getRpcConfig().getServerPort());
    }
}
