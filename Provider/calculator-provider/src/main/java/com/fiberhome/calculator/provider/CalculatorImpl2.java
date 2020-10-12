package com.fiberhome.calculator.provider;

import com.fiberhome.calculator.ICalculator;

/**
 * @author zhoujian
 * @date 2020/7/22
 */
public class CalculatorImpl2 implements ICalculator {
    @Override
    public int add(int num1, int num2) {
        System.out.println("Dubbo:add(" + num1 + "," + num2 + ")");
        return num1 + num2;
    }
}
