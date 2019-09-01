package com.javabase;

import java.util.concurrent.atomic.AtomicInteger;
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
         *    private static final Unsafe unsafe = Unsafe.getUnsafe();
         *     private static final long valueOffset;//value这个值的内存地址方便查找
         *
         *     static {
         *         try {
         *             valueOffset = unsafe.objectFieldOffset
         *                 (AtomicInteger.class.getDeclaredField("value"));
         *         } catch (Exception ex) { throw new Error(ex); }
         *     }
         *
         *     private volatile int value;//AtomicInteger当前的值
         *
         *     volatile：禁止指令的重排序优化，对volatile变量所有的写操作都能立即反应到其他线程中，换句话说，
         *     volatile变量在各个线程中是一致的（得益于java内存模型—"先行发生原则"）；
         *
         *    CAS:Compare-And-Swap比较并交换见CAS.png
         *
         *     public final int incrementAndGet() {
         *         for (;;) {
         *             int current = get();//获取到的是value的值
         *             int next = current + 1;//需要更新的值
         *             if (compareAndSet(current, next))// 如果内存的值也就是valueOffset地址的值，如果和预期值也就是value的中相同说明没有更新，更新成为 需要更新的值，如果与预期的值不一样，就会将value值改成预期的值。
         *                 return next;//返回根系的值
         *         }
         *    }
         *
         *   CAS的ABA问题
         * （1）线程1读取出指定内存地址的数据A，加载到寄存器，此时读取出来的原值不仅将作为要被计算的值A，还会作为比较值A。
         * （2）此时线程1的cpu被线程2抢占了，线程2也从同样的内存地址中读取了同样的数据A，线程2还比线程1先执行完，线程2产
         *      生了新数据B，并且遵守了CAS原理把新数据B存入该内存地址。 （这个时候内存的值由A被该为B）
         * （3）还没完，线程2执行完之后，线程1又没抢过其它线程，此时cpu被线程3抢占，之后步骤和第（2）步一样，线程3从同样
         *      的内存地址中读取了数据B，线程3还比线程1先执行完，线程3产生了新数据A（没错，与一开始的A相等，但值相等并不
         *      意味着此A就是彼A，已经被替换了），并且遵守了CAS原理把新数据A存入该内存地址。（这个时候内存的值由B又变为A）
         *
         *      ABA问题  对库存类的数据不影响，因为整体AtomicInteger的值是没有改变的
         */
        AtomicInteger atomicInteger=new AtomicInteger();
        atomicInteger.addAndGet(1);
        /**
         *  LongAdder在AtomicLong的基础上将单点的更新压力分散到各个节点，在低并发的时候通过对base的直接更新可以很好的保障
         *   和AtomicLong的性能基本保持一致，而在高并发的时候通过分散提高了性能。
         *  缺点是LongAdder在统计的时候如果有并发更新，可能导致统计的数据有误差。
         */
        LongAdder longAdder=new LongAdder();
        longAdder.add(1l);
        System.out.println(longAdder);


        String[] arry=new String[3];
        System.out.println(arry[0]);

    }
}
