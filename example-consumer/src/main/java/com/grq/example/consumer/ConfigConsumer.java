package com.grq.example.consumer;

import com.grq.myrpc.config.RpcConfig;
import com.grq.myrpc.utils.ConfigUtils;

/**
 * 使用配置文件进行消费者示例
 */
public class ConfigConsumer {
    public static void main(String[] args) {
        RpcConfig rpcConfig = ConfigUtils.loadConfig(RpcConfig.class, "rpc");
        System.out.println(rpcConfig);
    }
}
