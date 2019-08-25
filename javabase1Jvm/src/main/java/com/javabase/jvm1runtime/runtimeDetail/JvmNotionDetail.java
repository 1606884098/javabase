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
 * 符合jvm语言规范的语言有很多种比如java,scala，Python编译后都能在jvm上运行
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
 *  magic	魔数：0xCAFEBABE 识别是.class文件
 *  还有其他的规范，比如版本号
 *  动态编译asm框架是在编译成字节码的时候动态生成字节码，比如动态代理，创建代理对象的时候织入代码，又比如
 *  aop的时候每次被拦截到的时候都会动态织入字节码
 *  4.字节码文件的执行
 *  java 类名  运行程序时
 *  4.1类的装载
 *      装载类的第一个阶段
 *      取得类的二进制流
 *      转为方法区数据结构
 *      在Java堆中生成对应的java.lang.Class对象
 *  4.2连接验证
          链接 -> 验证
         目的：保证Class流的格式是正确的
         文件格式的验证
         是否以0xCAFEBABE开头
         版本号是否合理
         元数据验证
         是否有父类
         继承了final类？
         非抽象类实现了所有的抽象方法
         字节码验证 (很复杂)
         运行检查
         栈数据类型和操作码数据参数吻合
         跳转指令指定到合理的位置

         链接 -> 准备
         分配内存，并为类设置初始值 （方法区中）
         public static int v=1;
         在准备阶段中，v会被设置为0
         在初始化的<clinit>中才会被设置为1
         对于static final类型，在准备阶段就会被赋上正确的值
         public static final  int v=1;

    4.3加载
         ClassLoader是一个抽象类
         ClassLoader的实例将读入Java字节码将类装载到JVM中
         ClassLoader可以定制，满足不同的字节码流获取方式（网络上装载，本地等方式）
         ClassLoader负责类装载过程中的加载阶段

        查找这个类是否加载，是从最低层开始查找的 app extension bootstrap  如果app 目录找到了直接返回
        ture说明已经找到，如果没有找到委托父类 extension目录找 以此类推

        加载的过程是从顶层开始往下装载（顶层的ClassLoader是无法加载底层的ClassLoader的类的），如果bootstrap
        没有加载不了此类就往下委托 extension 以此类推。一个类只会加载一次

        还有一个问题就是  没有办法看到 其他的加载器的内容，以下解决
         Thread. setContextClassLoader()
         上下文加载器
         是一个角色
         用以解决顶层ClassLoader无法访问底层ClassLoader的类的问题
         基本思想是，在顶层ClassLoader中，传入底层ClassLoader的实例

        默认是双亲，也可以是其他的Tomcat的WebappClassLoader 就会先加载自己的Class，找不到再委托parent

    4.4内存分配
        运行时数据区：
        1.共享区：java堆--对象实例，常量池    method区 类信息，字节码信息
        2.线程私有：程序计数器，java栈，本地方法栈

        内存模型
        每一个线程有一个工作内存和主存独立
        工作内存存放主存中变量的值的拷贝

        当数据从主内存复制到工作存储时，必须出现两个动作：第一，由主内存执行的读（read）操作；
        第二，由工作内存执行的相应的load操作；当数据从工作内存拷贝到主内存时，
        也出现两个操作：第一个，由工作内存执行的存储（store）操作；
        第二，由主内存执行的相应的写（write）操作
        每一个操作都是原子的，即执行期间不会被中断
        对于普通变量，一个线程中更新的值，不能马上反应在其他变量中

         保证可见性的方法
         volatile volatile规则：volatile变量的写，先发生于读  指令重排
         synchronized （unlock之前，写变量值回主存）
         final(一旦初始化完成，其他线程就可见)


 *  关于热点代码
 *  JIT
 * 当虚拟机发现某个方法或代码块运行特别频繁时，就会把这些代码认定为“Hot Spot Code”（热点代码），
 * 为了提高热点代码的执行效率，在运行时，虚拟机将会把这些代码编译成与本地平台相关的机器码）
 *
 * -XX:CompileThreshold=1000
 * -XX:+PrintCompilation
 *
 * -Xint
 * 解释执行
 * -Xcomp
 * 全部编译执行
 * -Xmixed
 * 默认，混合
 *
 *
    5.jvm配置参数
        内存配置基本原则：
         新生代=Eden区+2*Survivor（也叫from to 或者s0 s1）
         Java总内存在机器的3/4
         堆最大和堆最小一样大，为了防止内存抖动
         新生代栈总堆的3/8
         幸存代为新生代的1/10也就是-XX:SurvivorRatio=8
    6.gc
     Java中，GC的对象是堆空间和永久区,可以触及的对象不可以回收，不可以触及的对象可以回收，gc不是由程序控制的
     引用计数法:
     引用计数器的实现很简单，对于一个对象A，只要有任何一个对象引用了A，则A的引用计数器就加1，
     当引用失效时，引用计数器就减1。只要对象A的引用计数器的值为0，则对象A就不可能再被使用。
     引用计数法的问题
     引用和去引用伴随加法和减法，影响性能
     很难处理循环引用

     标记清除:
    标记-清除算法是现代垃圾回收算法的思想基础。标记-清除算法将垃圾回收分为两个阶段：
    标记阶段和清除阶段。一种可行的实现是，在标记阶段，首先通过根节点，标记所有从根节
    点开始的可达对象。因此，未被标记的对象就是未被引用的垃圾对象。然后，在清除阶段，
    清除所有未被标记的对象。

     标记压缩
    标记-压缩算法适合用于存活对象较多的场合，如老年代。它在标记-清除算法的基础上做了
    一些优化。和标记-清除算法一样，标记-压缩算法也首先需要从根节点开始，对所有可达对象做一次标记。
    但之后，它并不简单的清理未标记的对象，而是将所有的存活对象压缩到内存的一端。之后，清理边界外所有的空间。


    复制算法
     与标记-清除算法相比，复制算法是一种相对高效的回收方法
     不适用于存活对象较多的场合 如老年代
     将原有的内存空间分为两块，每次只使用其中一块，在垃圾回收时，
    将正在使用的内存中的存活对象复制到未使用的内存块中，之后，清除正在使用的内存块中的所有对象，
    交换两个内存的角色，完成垃圾回收

     Stop-The-World
     Java中一种全局暂停的现象
     全局停顿，所有Java代码停止，native代码可以执行，但不能和JVM交互
     多半由于GC引起
     Dump线程
     死锁检查
     堆Dump

     GC时为什么会有全局停顿？
     类比在聚会时打扫房间，聚会时很乱，又有新的垃圾产生，房间永远打扫不干净，只有让大家停止活动了，才能将房间打扫干净。
     危害
     长时间服务停止，没有响应   老年代的gc时有时候也会发生这样的情况
     遇到HA系统，可能引起主备切换，严重危害生产环境。

     回收器：
    串行收集器
    最古老，最稳定
     效率高
     可能会产生较长的停顿
     -XX:+UseSerialGC （开始串行回收 下面具体回收方式）
     新生代、老年代使用串行回收
     新生代复制算法
     老年代标记-压缩

     并行收集器
     ParNew（1.并行收集器）
     -XX:+UseParNewGC（开始并行收集器 下面具体回收方式）
     新生代并行
     老年代串行
     Serial收集器新生代的并行版本
     复制算法
     多线程，需要多核支持
     -XX:ParallelGCThreads 限制线程数量  多核性能好

     Parallel收集器（2.也是并行收集器）
     类似ParNew
     新生代复制算法
     老年代 标记-压缩
     更加关注吞吐量
     -XX:+UseParallelGC
     使用Parallel收集器+ 老年代串行
     -XX:+UseParallelOldGC
     使用Parallel收集器+ 并行老年代

     并行收集器参数设置
     -XX:MaxGCPauseMills
     最大停顿时间，单位毫秒
     GC尽力保证回收时间不超过设定值
     -XX:GCTimeRatio
     0-100的取值范围
     垃圾收集时间占总时间的比
     默认99，即最大允许1%时间做GC
     这两个参数是矛盾的。因为停顿时间和吞吐量不可能同时调优



     CMS收集器
     Concurrent Mark Sweep 并发标记清除
     标记-清除算法
     与标记-压缩相比
     并发阶段会降低吞吐量
     老年代收集器（新生代使用ParNew，新生代不会使用cms收集器）
     -XX:+UseConcMarkSweepGC
     CMS运行过程比较复杂，着重实现了标记的过程，可分为
     初始标记
     根可以直接关联到的对象
     速度快
     并发标记（和用户线程一起）
     主要标记过程，标记全部对象
     重新标记
     由于并发标记时，用户线程依然运行，因此在正式清理前，再做修正
     并发清除（和用户线程一起）
     基于标记结果，直接清理对象
     特点
     尽可能降低停顿
     会影响系统整体吞吐量和性能
     比如，在用户线程运行过程中，分一半CPU去做GC，系统性能在GC阶段，反应速度就下降一半
     清理不彻底
     因为在清理阶段，用户线程还在运行，会产生新的垃圾，无法清理
     因为和用户线程一起运行，不能在空间快满时再清理
     -XX:CMSInitiatingOccupancyFraction设置触发GC的阈值
     如果不幸内存预留空间不够，就会引起concurrent mode failure
     -XX:+ UseCMSCompactAtFullCollection Full GC后，进行一次整理
     整理过程是独占的，会引起停顿时间变长
     -XX:+CMSFullGCsBeforeCompaction
     设置进行几次Full GC后，进行一次碎片整理
     -XX:ParallelCMSThreads
     设定CMS的线程数量

     -XX:+ UseCMSCompactAtFullCollection Full GC后，进行一次整理
     整理过程是独占的，会引起停顿时间变长
     -XX:+CMSFullGCsBeforeCompaction
     设置进行几次Full GC后，进行一次碎片整理
     -XX:ParallelCMSThreads
     设定CMS的线程数量
 为减轻GC压力
     软件如何设计架构
     代码如何写
     堆空间如何分配

 直接内存

 堆外内存，又被称为直接内存。这部分内存不是由jvm管理和回收的。需要我们手动的回收。

 堆内内存是属于jvm的，由jvm进行分配和管理，属于"用户态"，而推外内存是由操作系统管理的，属于"内核态"

 在jdk1.4中新加入了NIO类，他可以调用native函数库直接分配堆外内存，然后通过java堆中的DirectByteBuffer

 对象来指向这块内存，进行内存分配等工作。
 采用直接内存的优点：

 1：对于频繁的io操作，我们需要不断把内存中的对象复制到直接内存。然后由操作系统直接写入磁盘或者读出磁盘。

 这时候用到直接内存就减少了堆的内外内存来回复制的操作。

 2：我们在运行程序的过程中可能需要新建大量对象，对于一些声明周期比较短的对象，可以采用对象池的方式。但

 是对于一些生命周期较长的对象来说，不需要频繁调用gc，为了节省gc的开销，直接内存是必备之选。

 3：扩大程序运行的内存，由于jvm申请的内存有限，这时候可以通过堆外内存来扩大内存。


 *
 *
 *
 */
public class JvmNotionDetail {
}
