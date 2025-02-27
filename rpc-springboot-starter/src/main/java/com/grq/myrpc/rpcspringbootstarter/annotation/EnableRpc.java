package com.grq.myrpc.rpcspringbootstarter.annotation;

import com.grq.myrpc.rpcspringbootstarter.bootstrap.RpcConsumerBootstrap;
import com.grq.myrpc.rpcspringbootstarter.bootstrap.RpcInitBootstrap;
import com.grq.myrpc.rpcspringbootstarter.bootstrap.RpcProviderBootstrap;
import org.springframework.context.annotation.Import;
import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import({RpcInitBootstrap.class, RpcProviderBootstrap.class, RpcConsumerBootstrap.class})
public @interface EnableRpc {

    /**
     * 需要启动 server
     *
     * @return
     */
    boolean needServer() default true;
}

