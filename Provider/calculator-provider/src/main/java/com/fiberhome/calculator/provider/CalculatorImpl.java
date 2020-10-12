package com.fiberhome.calculator.provider;

import com.fiberhome.calculator.iface.Calculator;
import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

/**
 * @author zhoujian
 * @date 2020/7/21
 */
public class CalculatorImpl implements Calculator.Iface {
    private static final Logger logger = LoggerFactory.getLogger(CalculatorImpl.class);
    private final ConcurrentHashMap<String, Future<Integer>> cache = new ConcurrentHashMap<>();
    @Override
    public int add(int num1, int num2) throws TException {
//        logger.info("*** CalculatorImpl start ***");
        String key = num1 + "+" + num2;
        Future<Integer> future = cache.get(key);
        if (future == null) {
            Callable<Integer> callable = new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
//                    System.out.println("thrift:add(" + num1 + "," + num2 + ")");
                    logger.info("thrift:a dd(" + num1 + "," + num2 + ")");
                    return num1 + num2;
                }
            };
            // 创建任务
            FutureTask<Integer> futureTask = new FutureTask<Integer>(callable);
            future = cache.putIfAbsent(key, futureTask);
            if (future == null) {
                future = futureTask;
                futureTask.run();
            }
        }
        try {
            return future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
//        System.out.println("thrift:add(" + num1 + "," + num2 + ")");
//        return num1 + num2;
        return -1;
    }
}
