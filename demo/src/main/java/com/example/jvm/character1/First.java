package com.example.jvm.character1;

/**
 * @Author: guo wei
 * 2020-07-24
 */
public class First {
    private static int  x = 0;
    private static int  y = 1;
    static {
        int x=2;
    }
    public First(){
        y = 3;
        int z= 123;
    }
    public static void main(String[] args) {
//        int i =1+2;
        int x= 2;
        int y = 3;
        int i = x+y;
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end");
//        System.out.println(x+y);
//        System.out.println(i);
//        System.exit(1);
//        Runtime.getRuntime().exit(1);
        Runtime.getRuntime().halt(1);
    }
}
