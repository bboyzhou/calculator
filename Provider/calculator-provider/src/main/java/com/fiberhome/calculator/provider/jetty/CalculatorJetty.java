package com.fiberhome.calculator.provider.jetty;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.eclipse.jetty.server.Server;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zhoujian
 * @date 2020/8/3
 */
public class CalculatorJetty extends AbstractHandler {
    @Override
    public void handle(String s, Request request, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, ServletException {
        /*httpServletResponse.setContentType("text/html;charset=utf-8");
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        request.setHandled(true);
        httpServletResponse.getWriter().println("<h1>Hello World</h1>");*/
    }

    public static void main(String[] args) throws Exception {
        Server server = new Server(8888);
        server.setHandler(new CalculatorJetty());

        server.start();
        server.join();
    }
}
