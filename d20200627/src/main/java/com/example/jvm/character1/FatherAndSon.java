package com.example.jvm.character1;

/**
 * @Author: guo wei
 * 2020-07-26
 */
public class FatherAndSon {
    static class Father{
        public static int x = 1;
        static{
             x= 3;
        }
    }

    static class Son extends Father{
       public static  int y = x;
    }

    public static void main(String[] args) {
        System.out.println(Son.y);
    }
}
