package com.example;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @Author: guo wei
 * 2020-07-22
 */
public class TestFinal {
    public static final int i = 0;
    public static void main(String[] args) {
        HashSet<StringBuilder> stringBuilders = new HashSet<>();
        HashMap<StringBuilder, Object> stringBuilderObjectHashMap = new HashMap<>();
        StringBuilder stringBuilder1 = new StringBuilder("123");
        StringBuilder stringBuilder2 = new StringBuilder("123qaz");
//        stringBuilders.add(stringBuilder1);
//        stringBuilders.add(stringBuilder2);
        stringBuilderObjectHashMap.put(stringBuilder1,"wqeq");
        stringBuilderObjectHashMap.put(stringBuilder2,"wqeqdasda");
        System.out.println(stringBuilderObjectHashMap.get(stringBuilder1));
        StringBuilder stringBuilder3 = stringBuilder1;
        stringBuilder3.append("qaz");
//        System.out.println(stringBuilders);
        System.out.println(stringBuilderObjectHashMap.get(stringBuilder1));
//ClassLoader.getSystemResourceAsStream()
    }
}
