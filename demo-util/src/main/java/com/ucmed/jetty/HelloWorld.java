package com.ucmed.jetty;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloWorld extends AbstractHandler {

    public static void main(String[] args) throws Exception {
        //创建一个应用服务监听8080端口
        Server server = new Server(8080);
        server.setHandler(new HelloWorld());
        //启动应用服务并等待请求
        server.start();
        System.out.println("HelloWorld start ================");
        server.join();
    }
    @Override
    public void handle(String s, Request request, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws IOException, ServletException {
        httpServletResponse.setContentType("text/html; charset=utf-8");
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);

        //获取入参，其他信息貌似用不到
        String req=httpServletRequest.getParameter("req");
        System.out.println(httpServletRequest.getPathInfo());
        String res="hello,"+req;
        // 请求的返回值
        httpServletResponse.getWriter().print(res);

        // 通知Jetty request使用此处理器处理请求
        request.setHandled(true);
    }
}
