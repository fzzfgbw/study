package com.example;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * @Author: guo wei
 * 2020-07-15
 *
 * 守护线程顾名思义是线程中的守护者，为非守护线程（也就是用户线程）提供服务。
 * 所以当进程不存在或主线程停止，守护线程失去了存在意义，就会被停止。
 * 最好的例子就是垃圾回收线程
 */
public class TestDaemonThread {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("main thread begin");
        Thread thread = new Thread(() -> {
            while (Thread.currentThread().isAlive()){
                System.out.println(Thread.currentThread().getName());
            }
        },"daemon thread");
        thread.setDaemon(true);
        thread.start();
        for (int i = 0; i <1 ; i++) {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+i);
        }
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        threadGroup.setMaxPriority(1);
//        thread.isInterrupted();
//        System.out.println(threadGroup.toString());
//        System.out.println(threadGroup.getMaxPriority());
//        ThreadGroup aa = new ThreadGroup("aa");
//        Thread ad = new Thread(aa, "AD");


    }
}
