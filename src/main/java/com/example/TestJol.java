package com.example;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author: Guowei
 * 2020-06-27
 */
public class TestJol {
    public static void main(String[] args) {
        Object o = new Object();
        String o1 = new String();
        String s = ClassLayout.parseInstance(o).toPrintable();
        System.out.println(s);
        System.out.println("----------");
        synchronized (o){
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
        synchronized (o1){
            System.out.println(ClassLayout.parseInstance(o1).toPrintable());
        }

    }
}
