package com.example;

import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;

/**
 * @Author: guo wei
 * 2020-07-09
 */
public class TestLambda {
    public static void main(String[] args) {
        BinaryOperator<Integer> binaryOperator = Integer::sum;
        BinaryOperator<Integer> binaryOperator1 = BinaryOperator.maxBy(Comparator.naturalOrder());
        System.out.println(binaryOperator1.apply(5,4));
        System.out.println(binaryOperator.apply(1,3));
        IntBinaryOperator intBinaryOperator = (left, right) -> left - right;
        System.out.println(intBinaryOperator.applyAsInt(3,4));
    }
}
