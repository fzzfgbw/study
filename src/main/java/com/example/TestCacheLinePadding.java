package com.example;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @Author: guo wei
 * 2020-07-17
 *
 * CacheLine == 64 bit
 * long == 8bit
 * 从第九个long对象开始就不在一个缓存行，不互相影响不失效
 */
public class TestCacheLinePadding {
//    public static  long[] a = new long[2];
    public static  long[] a = new long[16];
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i <2000000000 ; i++) {
                a[0] = i;
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i <2000000000 ; i++) {
//                a[1] = i;
                a[8] = i;
            }
        });
        long start = System.currentTimeMillis();
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis()- start );
    }
}
