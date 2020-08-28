package com.example;

import java.util.concurrent.CountDownLatch;

/**
 * @author: Guowei
 * 2020-06-27
 */
public class Cas {
    public static void main(String[] args) {
        Thread[] threads = new Thread[100];
        CountDownLatch countDownLatch = new CountDownLatch(threads.length);
        countDownLatch.countDown();
    }
}
