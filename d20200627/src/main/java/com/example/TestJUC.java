package com.example;

import com.sun.org.apache.bcel.internal.generic.NEW;
import sun.misc.Unsafe;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntUnaryOperator;

/**
 * @Author: guo wei
 * 2020-07-08
 */
public class TestJUC {
    static volatile int a = 1;

    volatile static TestJUC o = new TestJUC();
    public static void main(String[] args) throws NoSuchFieldException, InterruptedException {
        AtomicInteger atomicInteger1 = new AtomicInteger(1);

//        atomicInteger1.compareAndSet(1, 3);
//        int andIncrement = atomicInteger1.getAndIncrement();
//        atomicInteger1.getAndAdd(6);
//        int i = atomicInteger1.incrementAndGet();
//        int andIncrement = atomicInteger1.getAndIncrement();


//        System.out.println(i);
//        利用线程循环打印 A1B2C3
        char[] charS1 = {'A','B','C'};
        char[] charS2 = {'1','2','3'};


        Thread t1 = new Thread(() -> {
            synchronized (o){
                for (char c : charS1) {
                    System.out.println(c);
                    try {
                        o.notify();
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                o.notify();

            }

        });

        Thread t2 = new Thread(() -> {
            synchronized (o) {
                for (char c : charS2) {
                    System.out.println(c);
                    try {
                        o.notify();
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
//                o.notify();
            }
        });
        t1.start();
        t2.start();


        //门闩
        CountDownLatch countDownLatch = new CountDownLatch(2);

        Thread T1 = new Thread(() -> {
//            synchronized (o){
                System.out.println("t1");
                countDownLatch.countDown();
//            }
        });
        Thread T2 = new Thread(() -> {
//            synchronized (o){
                System.out.println("t2");
                countDownLatch.countDown();
//            }
        });
        Thread T3 = new Thread(() -> {
            synchronized (o){
                a = 1;
                System.out.println(a);
                a = 2;
                System.out.println(a);
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                a = 3;
                System.out.println(a);
                a = 4;
                System.out.println(a);
            }
        });

        Thread T4 = new Thread(() -> {
            synchronized (o){
                a = 1;
                System.out.println(a);
                a = 2;
                System.out.println(a);
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                a = 3;
                System.out.println(a);
                a = 4;
                System.out.println(a);
            }
        });
//        T3.start();
//        T1.start();
//        T2.start();

//        Unsafe unsafe = Unsafe.getUnsafe();
//
//        System.out.println(123123);
//        unsafe.park(true,1);
//        unsafe.unpark(Thread.currentThread());
//        System.out.println(1123);

//        long address = unsafe.allocateMemory(10);
//
//
////        unsafe.park();
//        unsafe.freeMemory(address);
//t1.interrupt();
//t1.isInterrupted();

    }


}
