package com.example.jvm.character1;

import sun.misc.Launcher;

import java.net.URL;

/**
 * @Author: guo wei
 * 2020-07-26
 */
public class TestClassLoader {
    public static void main(String[] args) {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
//        sun.misc.Launcher$AppClassLoader@18b4aac2
        ClassLoader parent = systemClassLoader.getParent();
//        sun.misc.Launcher$ExtClassLoader@14ae5a5
        ClassLoader parent1 = parent.getParent();
//        null
//        bootstrap classloader
        System.out.println(systemClassLoader);
        System.out.println(parent);
        System.out.println(parent1);
//        sun.misc.Launcher$AppClassLoader@18b4aac2
        ClassLoader classLoader = TestClassLoader.class.getClassLoader();
        System.out.println(classLoader);
//             null
        //        bootstrap classloader

        ClassLoader classLoader1 = String.class.getClassLoader();
        System.out.println(classLoader1);


        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        for (URL urL : urLs) {
            System.out.println(urL.toExternalForm());
        }

        //扩展类加载器
        String property = System.getProperty("java.ext.dirs");
        String[] split = property.split(";");
        for (String s : split) {
            System.out.println(s);
        }

    }
}
