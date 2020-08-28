package com.example.jvm.character1;

/**
 * @Author: guo wei
 * 2020-07-26
 */
public class ThreadsOnClinit {
    public static void main(String[] args) {
         Runnable r= ()->{
             System.out.println(Thread.currentThread().getName() + "begin");
             init init = new init();
             System.out.println(Thread.currentThread().getName() + "end");
        };
         new Thread(r,"t1").start();
         new Thread(r,"t2").start();

    }

}
class init{
    static {
        if (true) {
            System.out.println(Thread.currentThread().getName());
            while (true) {
            }
        }

    }
}
