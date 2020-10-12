package com.fiberhome.calculator.consumer;

/**
 * @author zhoujian
 * @date 2020/7/21
 */
import com.fiberhome.calculator.ICalculator;
import com.fiberhome.calculator.common.ServerConfig;
import com.fiberhome.calculator.iface.Calculator;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TJSONProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Consumer {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"META-INF/spring/calculator-consumer.xml"});
        context.start();

        /*// Obtaining a remote service proxy
        ICalculator calculator = (ICalculator) context.getBean("calculator1");
        // Executing remote methods
        int sum = calculator.add(1, 1);
        // Display the call result
        System.out.println("dubbo sum = "+ sum);*/

        Calculator.Iface iface =(Calculator.Iface) context.getBean("calculator2");
        iface.add(2,2);
        iface.add(1,1);
        iface.add(1,2);
        iface.add(1,3);
//        System.out.println("thrift sum = "+ sum);

        /*TTransport transport = new TFramedTransport(new TSocket(ServerConfig.SERVER_IP, ServerConfig.SERVER_PORT, ServerConfig.TIMEOUT));
        // 协议要和服务端一致
        TProtocol protocol = new TCompactProtocol(transport);
        Calculator.Client client = new Calculator.Client(protocol);
        transport.open();

        int result = client.add(2,2);
        System.out.println("thrift:sum = " + result);
        transport.close();*/
    }
}
