package com.example;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: guo wei
 * 2020-07-14
 */
public class TestReentryLock {
    static long x = 0;

    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        Runnable runnable = () -> {
            reentrantLock.lock();
            int i = 10000;
            while (i > 0) {
                x++;
                i--;
            }
            reentrantLock.unlock();
        };
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);
        Thread thread4 = new Thread(runnable);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(x);
    }
}
