package patterns.structural.adapter;


import patterns.structural.adapter.impl.AudioPlayer;

/**
 * what:适配器模式（Adapter Pattern）是作为两个不兼容的接口之间的桥梁。它结合了两个独立接口的功能。
 * 这种模式涉及到一个单一的类，该类负责加入独立的或不兼容的接口功能。举个真实的例子，读卡器是作为内
 * 存卡和笔记本之间的适配器。您将内存卡插入读卡器，再将读卡器插入笔记本，这样就可以通过笔记本来读取内存卡。
 * <p>
 * why:将一个类的接口转换成客户希望的另外一个接口。适配器模式使得原本由于接口不兼容而不能一起工作的那些类可以一起工作。
 * 主要解决在软件系统中，常常要将一些"现存的对象"放到新的环境中，而新环境要求的接口是现对象不能满足的。
 * 应用场景：
 * 1、美国电器 110V，中国 220V，就要有一个适配器将 110V 转化为 220V。
 * 2、JAVA JDK 1.1 提供了 Enumeration 接口，而在 1.2 中提供了 Iterator 接口，
 * 想要使用 1.2 的 JDK，则要将以前系统的 Enumeration 接口转化为 Iterator 接口，
 * 这时就需要适配器模式。
 * 3、在 LINUX 上运行 WINDOWS 程序。 4、JAVA 中的 jdbc。
 * 4、系统需要使用现有的类，而此类的接口不符合系统的需要。
 * 5、想要建立一个可以重复使用的类，用于与一些彼此之间没有太大关联的一些类，
 * 包括一些可能在将来引进的类一起工作，这些源类不一定有一致的接口。
 * how:适配器继承或依赖已有的对象，实现想要的目标接口。
 * example:播放器媒体类型
 * 1.原来的播放器接口：MediaPlayer 只能播放MP3
 * 2.升级后播放器的接口：AdvanceMediaPlayer 实现类可以播放mp4.vlc等
 * 3.适配器类：MediaAdapter 实现原来的接口，将新的功能加入进来
 * 4.整合功能类：AudioPlayer 将原来的功能和现在的功能整合在一起
 */
public class AdapterApp {

    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.paly("mp3", "光辉岁月.mp3");
        audioPlayer.paly("mp4", "道士下山.mp4");
        audioPlayer.paly("vlc", "鬼片.vlc");
        audioPlayer.paly("avi", "美人鱼.avi");

    }
}
