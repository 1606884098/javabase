package com.javabase;

import java.util.concurrent.atomic.LongAdder;

/**
 * debug模式    查看运行逻辑
 */
public class TEST {
    public static void main(String[] args) {
        Object o=new Object();
        /**
         * 1.
         * String  是用final修饰的类，是不允许修改的，修改了就是一个新的字符串。public final class String
         *
         *
         * 使用字符串常量池，每当我们使用字面量（String s=”1”;）创建字符串常量时，JVM会首先检查字符串常量池，
         * 如果该字符串已经存在常量池中，那么就将此字符串对象的地址赋值给引用s（引用s在Java栈中）。如果字符串
         * 不存在常量池中，就会实例化该字符串并且将其放到常量池中，并将此字符串对象的地址赋值给引用s（引用s在Java栈中）。
         *
         *使用字符串常量池，每当我们使用关键字new（String s=new String(”1”);）创建字符串常量时，JVM会首先检查字符串常量池，
         * 如果该字符串已经存在常量池中，那么不再在字符串常量池创建该字符串对象，而直接堆中复制该对象的副本，然后将堆中对象
         * 的地址赋值给引用s，如果字符串不存在常量池中，就会实例化该字符串并且将其放到常量池中，然后在堆中复制该对象的副本，
         * 然后将堆中对象的地址赋值给引用s。
         */
        String string=new String("1");
        String string1="1";
        String string2="1";
        System.out.println(string==string1);//string new的内存的引用  string1是常量池“1”的引用
        System.out.println(string1==string2);//常量池里同一个对象
        /**
         * equals  用于对象的比较，不能用于基本数据类型
         * Object默认比较的时对象的引用，也就时内存地址  return (this == obj);。
         * String重写了equals方法
         * public boolean equals(Object anObject) {
         *         if (this == anObject) {//是否是重常量池的同一个对象
         *             return true;
         *         }
         *         if (anObject instanceof String) {
         *             String anotherString = (String)anObject;
         *             int n = value.length;//private final char value[];
         *             if (n == anotherString.value.length) {//逐个比较
         *                 char v1[] = value;
         *                 char v2[] = anotherString.value;
         *                 int i = 0;
         *                 while (n-- != 0) {
         *                     if (v1[i] != v2[i])
         *                         return false;//有一个字符不相同 就返回false 说明不相同
         *                     i++;
         *                 }
         *                 return true;
         *             }
         *         }
         *         return false;
         *     }
         *
         */
        System.out.println(string.equals(string1));

        /**
         * 2.
         * ==比较的是两个变量的大小
         * 基本数据类型比较的是值的大小
         * 如果是引用数据类型比较的是内存地址是否一样,因为变量保存的是对象的引用也就是内存地址
         */
        int a=1000;
        int b=1000;
        System.out.println(a==b);//true
        /**
         * 如果A B的值 在 -128-127 范围时，== 返回true。因为IntegerCache 缓存了这个数组 使用的时同一个对象的引用
         *  不在这个范围  返回false  对象的引用不同。
         */
        Integer A=-128;
        Integer B=-128;
        System.out.println(A==B);
        /**
         * equals  用于对象的比较，不能用于基本数据类型
         * Object默认比较的时对象的引用，也就时内存地址  return (this == obj);。
         * Integer 重写了 equals方法 比较的时值的大小
         *     public boolean equals(Object obj) {
         *         if (obj instanceof Integer) {
         *             return value == ((Integer)obj).intValue();
         *         }
         *         return false;
         *     }
         */
        System.out.println(A.equals(B));

        /**
         *
         */

        LongAdder longAdder=new LongAdder();
        longAdder.add(1l);
        System.out.println(longAdder);
    }
}
