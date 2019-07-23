package com.javabase.jvm;

import java.text.SimpleDateFormat;
import java.util.BitSet;
import java.util.Date;

/**
计算机基础知识：
    1.计量单位：
    位：我们常说的bit，位就是传说中提到的计算机中的最小数据单位：说白了就是0或者1；
    计算机内存中的存储都是01这两个东西。

    字节：英文单词：（byte），byte是存储空间的基本计量单位。1byte 存1个英文字母，
    2个byte存一个汉字。规定上是1个字节等于8个比特（1Byte = 8bit）。

    字：字就是由一些字符组成的，是据算计处理数据时一次存取，加工和传送的数据长度。
    字由若干字节构成，字的位数叫字长，一台8位机子：一个字等于1个字节，字长为8位，
    如果是16位的机子，一个字等于2个字节，字长为16，字是计算机处理数据和运算的单位。
    由此可见，计算机的字长决定了其CPU一次操作处理实际位数的多少，即：计算机的字长越大，其性能越好。

      1byte=8bit; 1kb=1024byte;
      1mb=1024kb; 1gb=1024mb;
      1tb=1024gb; 1pb=1024tb; 1eb=1024pb

    2.计算机的文字，图片，视频等数据都是二进制存储运算的。（基本数据类型，引用数据类型，对象，音频，视频）
    计算机与人类交互是按照人的习惯利用算法输入输出（十进制，图片显示）
    计算机启动：接通电源开关，主板，内存，cpu，硬盘，显卡等硬件接通电源。
    主板连接电源按需要分配控制他硬件的电流。BIOS安全检查，如果发现安装有系统，
    将安装好的系统文件（安装系统，就是把系统文件编译成机器码保存到硬盘）加载到内存，
    启动系统。桌面上的图标都是根据鼠标时间触发事件或者命令，将内存中的指令交与cpu执行，
    得到结果，根据指令保存到内存，或再根据指令报错到硬盘，或根据指令直接清除。
学习的思路
 学习软件编程的捷径--敲，狂敲
 学习新技术的四点：
    1，该技术是什么what？
    2，该技术有什么特点(使用注意)why?
    3，该技术怎么使用demo,该技术什么时候用？再test。whereAndHow
 写代码：
    1，分析需求。我要做什么？What do
    2，分析思路。我要怎么做？How do确定步骤。每一个思路部分用到哪些语句，方法，和对象。
    3，代码实现。用具体的java语言代码把思路体现出来。代码仅仅是思想的一种体现，先思想在写代码。
    技术跟业务场景结合（才是重点）
 平时的积累：
    学习接口：学习接口的方法怎么用，就掌握了该接口
    启动服务器时，要先看下日志，没有报错的时候再访问
    对于数据的原则是先判断再使用，比如非空校验
    例如：Sting name=null;
    Name.charAt();报空指针异常，因为用一个空的对象去调用方法(实际时内存没有这个方法)。
    接口也可以用匿名类的形式创建对象
    在互联网行业的项目中尽可能的减少表的关联查询。使用冗余解决表的关联问题。有利于分库分表。
    改错误千万不要对字，鼠标移过去开错误学会这个错误语句一回生两回熟
    java反编译 javap -c -l -private 类名  对class文件还原java代码
    有带参数的构造函数，无参数的构造函数就没有了
    switch case类型byte char short int String 枚举类型 case语句后面跟的枚举值，只需要枚举值即可，不需要声明是具体的枚举类Season.spring将报错
    java的继承private修饰的成员，构造函数。

    window 转换目录用cd  如果转换盘符直接d:就可以了
    cmd窗口编码utf-8 直接输入：chcp 65001
    cmd窗口编码gbk 直接输入：chcp 936

 * jvm基础：
 *      jre=jvm+java核心类库
 *      jvm=jdk1.8.0_171\jre\bin\server\jvm.dll就是java虚拟机 java核心类库=jdk1.8.0_171\jre\lib\rt.jar
 *      jdk=jre+java开发工具包
 *      java规范：
 *      1.jvm规范：定了二进制class文件和jvm指令集，运行
 *      2.java语言规范：定义了什么是java语言
 *      .class文件是可以运行在任何支持Java虚拟机的硬件平台或者java虚拟机的操作系统上的二进制文件.
 *      类加载待续
 */
public class ComputerBase {
    public static void main(String[] args) {
        BitSet a=new BitSet();
        a.set(1);
        a.set(11);
        a.set(19);
        a.set(14);
        a.set(16);
        a.set((int) 199999999922222L);

        Date currentTime = new Date();
        String currentStr = new SimpleDateFormat("yyyy-MM-dd").format(currentTime);
        System.out.println(currentStr);
        System.out.println(a.size());
        System.out.println(a.cardinality());

        System.out.println(a.get(1));
    }
}
