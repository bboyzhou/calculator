package com.fiberhome.calculator.consumer.ice;

import com.fiberhome.calculator.ice.ICalculatorPrx;

/**
 * @author zhoujian
 * @date 2020/7/24
 */
public class Client {
    public static void main(String[] args)
    {
        try(com.zeroc.Ice.Communicator communicator = com.zeroc.Ice.Util.initialize(args))
        {
//            communicator.getProperties().setProperty("Ice.Default.Package", "com.zeroc.demos.Ice.minimal");
            ICalculatorPrx calculator = ICalculatorPrx.checkedCast(communicator.stringToProxy("calculator:default -h localhost -p 12345"));
            int sum = calculator.add(1,2);
            System.out.println("sum = " +sum);
        }
    }
}
