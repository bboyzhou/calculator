package com.fiberhome.calculator.provider;

import com.fiberhome.calculator.common.ServerConfig;
import com.fiberhome.calculator.iface.Calculator;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TJSONProtocol;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zhoujian
 * @date 2020/7/21
 */
public class Provider {
    public static void main(String[] args) throws Exception {
        System.setProperty("java.net.preferIPv4Stack", "true");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"META-INF/spring/calculator-provider.xml"});
        context.start();

        /*// Thrift Server
        // 处理层co
        TProcessor tprocessor = new Calculator.Processor<Calculator.Iface>(new CalculatorImpl());
        TNonblockingServerSocket tnbSocketTransport = new TNonblockingServerSocket(ServerConfig.SERVER_PORT);

        TNonblockingServer.Args tnbArgs = new TNonblockingServer.Args(tnbSocketTransport);
        tnbArgs.processor(tprocessor);
        // 传输层
        tnbArgs.transportFactory(new TFramedTransport.Factory());
        // 协议层 JSON 编码解码
        tnbArgs.protocolFactory(new TJSONProtocol.Factory());

        // 服务层
        // 使用非阻塞式IO服务端和客户端需要指定TFramedTransport数据传输的方式
        TServer server = new TNonblockingServer(tnbArgs);
        System.out.println("Running Non-blocking Server");
        server.serve();*/

        System.out.println("Provider started.");
        System.in.read(); // press any key to exit
    }
}
