package com.fiberhome.calculator.provider.ice;

import com.fiberhome.calculator.ice.ICalculator;
import com.zeroc.Ice.Current;

/**
 * @author zhoujian
 * @date 2020/7/24
 */
public class CalculatorIce implements ICalculator {
    @Override
    public int add(int num1, int num2, Current current) {
        System.out.println("ICE:add(" + num1 + "," + num2 + ")");
        return num1 + num2;
    }
}
