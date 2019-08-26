package base.java3oop.oop3Collection.map;

import java.util.HashMap;
import java.util.Map;

/**
 * 这个不直接写16 位移速度快
 * static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; //1左移动4位  等于乘以4个2
 *
 * 数组+链表+红黑树 见图：HashMap结构.png
 *
 * 每个Node<k,v>的位置计算方法：
 * 根据key（object的hashCode方法）
 * static final int hash(Object key) {
 *     int h;
 *     return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
 * }
 *
 * (h = key.hashCode())^ (h >>> 16)
 * 主要是从速度、功效、质量来考虑的，这么做可以在数组table的length比较小的时候，也能保证考虑到高低Bit都参与到Hash的计算中，同时不会有太大的开销。
 *
 * 得到的hash 用来计算数组下标
 * tab[(n - 1) & hash]
 * tab[] 已经初始化长度为n ,(n - 1) & hash是用来计算Node<k,v>的位置,n是的2的n次方
 * 1.(n - 1) & hash首先保证数组不会越界n-1的高位都是0，&按位与 相当于是砍掉了高位
 *见图：提高散列性减小哈希碰撞.png
 */
public class HashMapCode {
    public static void main(String[] args) {
        Map codeHashMap=new HashMap();
        codeHashMap.put("code","aa");
    }
}
