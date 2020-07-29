package com.example;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * 2020-07-03
 * 验证指令重排
 * <p>
 * 大多数现代微处理器都会采用将指令乱序执行（out-of-order execution，简称OoOE或OOE）的方法，
 * 在条件允许的情况下，直接运行当前有能力立即执行的后续指令，避开获取下一条指令所需数据时造成的等待。
 * 通过乱序执行的技术，处理器可以大大提高执行效率。
 * 除了处理器，常见的Java运行时环境的JIT编译器也会做指令重排序操作，
 * 即生成的机器指令与字节码指令顺序不一致。
 * <p>
 * <p>
 * as-if-serial语义的意思是，所有的动作（Action）都可以为了优化而被重排序，
 * 但是必须保证它们重排序后的结果和程序代码本身的应有结果是一致的。
 * Java编译器、运行时和处理器都会保证 !单线程 !下的as-if-serial语义,多线程情况下不遵守此原则。
 */
public class OutOfOrderExecution {
    private static int a = 0;
    private static int b = 0;
    private static int x = 0;
    private static int y = 0;

    /**
     * 证明Java代码执行中存在指令重排的情况
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {

        //计数
        int count = 0;

        //线程池，固定两个线程
        ExecutorService executor = Executors.newFixedThreadPool(2);

        //一直执行，直到出现指令重排
        while (true) {

            //所有变量全部恢复初始值
            a = 0;
            b = 0;
            x = 0;
            y = 0;

            //计数加1
            count ++;

            //倒计时门栓，同步两个线程
            CountDownLatch latch = new CountDownLatch(2);

            //第一个线程
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    a = 1;
                    y = b;
                    latch.countDown();
                }
            });

            //第二个线程
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    b = 1;
                    x = a;
                    latch.countDown();
                }
            });

            //阻塞以上两个线程，等两个线程全部执行完毕后，继续执行下面的代码
            latch.await();

            //此时，上面的两个线程已经执行完毕。如果Java代码在执行过程中都是
            //一行一行的代码顺序执行的，那么上面两个线程无论是怎样的先后执行
            //顺序，a=1和b=1，这两句代码作为第一行代码，总有一句是最先执行的，
            //也就是说，到最后x或y肯定都不为0。如果到最后x和y都同时为0了，那
            //么根据反证法原理，Java代码在执行过程中，有可能并不绝对按照代码
            //顺序依次执行，当然也就发生了指令重排，Java代码执行中存在指令重排
            //的情况也就得到了证明

            //如果x和y都等于0了，就输出结果（如果Java代码真的按照顺序一句一句
            //执行的话，是绝对不可能出现x和y同时为0的）
            if (x == 0 && y == 0) {

                //指令重排输出语句
                String message = "第" + count + "次出现指令重排，x=" + x + "，y=" + y;

                //打印，证明完毕
                System.err.println(message);

                //结束程序
                System.exit(0);
            }
        }
    }

}
