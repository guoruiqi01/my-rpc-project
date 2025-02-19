package com.grq.myrpc.registry;

import com.grq.myrpc.model.ServiceMetaInfo;

import java.util.List;

/**
 * 注册中心服务本地缓存（消费者）
 */
public class RegistryServiceCache {
    /**
     * 服务缓存
     */
    List<ServiceMetaInfo> serviceCache;

    /**
     * 写缓存
     * @param newServiceCache
     */
    void writeCache(List<ServiceMetaInfo> newServiceCache) {
        System.out.println("写缓存");
        this.serviceCache = newServiceCache;
    }

    /**
     * 读缓存
     * @return
     */
    List<ServiceMetaInfo> readCache() {
        System.out.println("读缓存");
        return this.serviceCache;
    }

    /**
     * 清空缓存
     */
    void clearCache() {
        System.out.println("清除缓存");
        this.serviceCache = null;
    }
}
