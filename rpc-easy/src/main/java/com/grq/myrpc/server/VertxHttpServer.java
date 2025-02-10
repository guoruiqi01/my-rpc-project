package com.grq.myrpc.server;

import io.vertx.core.Vertx;


/**
 * Vertx HTTP服务器
 */
public class VertxHttpServer implements HttpServer {
    /**
     * 启动服务器
     * @param port
     */
    @Override
    public void doStart(int port) {
        // 创建Vert.x实例
        Vertx vertx = Vertx.vertx();

        // 创建Http服务器
        io.vertx.core.http.HttpServer server = vertx.createHttpServer();

        // 监听端口并处理请求
        server.requestHandler(new HttpServerHandler());


//        // 监听端口并处理请求
//        server.requestHandler(request -> {
//            // 处理HTTP请求
//            System.out.println("Received request: " + request.method() + " " + request.uri());
//
//            // 发送HTTP请求
//            request.response()
//                    .putHeader("content-type", "text/plain")
//                    .end("Hello from Vert.x HTTP server!");
//        });
//
        // 启动HTTP服务器并监听指定端口
        server.listen(port, result -> {
            if (result.succeeded()) {
                System.out.println("Server is now listening on port " + port);
            } else {
                System.out.println("Failed to start server: " + result.cause());
            }
        });
    }
}
