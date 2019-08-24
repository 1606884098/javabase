package com.javabase.jvm1runtime.runtimeDetail;

/**
 *
 * 1.虚拟机
 * JVM是Java Virtual Machine的简称。意为Java虚拟机
 * 虚拟机
 * 指通过软件模拟的具有完整硬件系统功能的、运行在一个完全隔离环境中的完整计算机系统
 * 有哪些虚拟机
 * VMWare
 * Visual Box
 * JVM
 * VMWare或者Visual Box都是使用软件模拟物理CPU的指令集
 * JVM使用软件模拟Java 字节码的指令集
 *
 *  * jvm基础：
 *  *      jre=jvm+java核心类库
 *  *
 *  *      jvm=jdk1.8.0_171\jre\bin\server\jvm.dll就是java虚拟机 java核心类库=jdk1.8.0_171\jre\lib\rt.jar
 *  *
 *  *      jdk=jre+java开发工具包
 *  *
 *  *     即时编译器(JIT)
 *  *     即时编译器是种特殊的编译器，它通过有效的把字节码变成机器码来提高JVM的效率。JIT这种功效很特殊，
 *  *     因为他把检测到的相似的字节码编译成单一运行的机器码，从而节省了CPU的使用。这和其他的字节码编译器不同，因为他是运行时
 *  *
 *  *     jni
 *  *     JNI是Java Native Interface的缩写，它提供了若干的API实现了Java和其他语言的通信（主要是C&C++）

 *
 * 2.jvm规范
 * 2.1java语言规范
 * 语法
 * 变量
 * 类型
 * 文法
 * 符合jvm语言规范的语言有很多种比如java,scala，编译后都能在jvm上运行
 * Java语言的规范主要是定义使用的规范和实现机制，也就是定义了什么是java语言
 * 图2.1语法定义
 * 比如：if语句
 * 参数列表
 * 2.2jvm规范
 * Class文件类型
 * 运行时数据
 * 帧栈
 * 虚拟机的启动
 * 虚拟机的指令集
 * 主要是虚拟机运行规范（二进制的处理），直接执行的是jvm指令代码
 * 定了二进制class文件和jvm指令集，运行
 * .class文件是可以运行在任何支持Java虚拟机的硬件平台或者java虚拟机的操作系统上的二进制文件.
 * 3.class文件的结构
 *  java 文件编译规则：就是将java文件按照3系列图的规则编译成.class文件
 *
 *
 */
public class JvmNotionDetail {
}
