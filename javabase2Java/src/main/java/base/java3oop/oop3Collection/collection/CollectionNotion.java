package base.java3oop.oop3Collection.collection;

import java.util.LinkedList;
import java.util.List;

/**
 * 集合:存储对象的容器.
 * 集合和数组的区别:
 * 数组和集合类都是容器
 * 数组存储的是定长同一的数据类型，可以是基本数据类型，也可以是引用数据类型。
 * 集合存储的是变长的不同类型的对象。
 * 注意：集合和数组中存放的都是对象的引用而非对象本身
 * 集合框架体系(面向接口开发的思想，把共有的属性抽象出来，定义成一个接口（规范），实现了这个接口的的就是集合类)
 *
 *
 频繁使用类接口架构：
 ---|Collection: 单列集合 描述所有接口的共性
     ---|List: 有存储顺序, 可重复
     ---|ArrayList:
     ---|LinkedList:
     ---|Vector:
 ---|Set: 无存储顺序, 不可重复
     ---|HashSet
     ---|TreeSet
     ---|LinkedHashSet
 ---| Map: 键值对
     ---|HashMap
     ---|TreeMap
     ---|HashTable
     ---|LinkedHashMap
 为什么出现这么多集合容器，因为每一个容器对数据的存储方式不同，这种存储方式称之为数据结构（data structure）


 什么时候该使用什么样的集合
 Collection	我们需要保存若干个对象的时候使用集合。

 List

 如果我们需要保留存储顺序, 并且保留重复元素, 使用List.
 如果查询较多, 那么使用ArrayList
 如果存取较多, 那么使用LinkedList
 如果需要线程安全, 那么使用Vector


 Set
 如果我们不需要保留存储顺序, 并且需要去掉重复元素, 使用Set.
 如果我们需要将元素排序, 那么使用TreeSet
 如果我们不需要排序, 使用HashSet, HashSet比
 TreeSet效率高.
 如果我们需要保留存储顺序, 又要过滤重复元素, 那么使用LinkedHashSet


Collection接口的共性方法
 增加：
 1：add()	将指定对象存储到容器中
 add 方法的参数类型是Object 便于接收任意对象
 2：addAll() 将指定集合中的元素添加到调用该方法和集合中
 删除：
 3：remove() 将指定的对象从集合中删除
 4：removeAll() 将指定集合中的元素删除
 修改
 5：clear() 清空集合中的所有元素
 判断
 6：isEmpty() 判断集合是否为空
 7：contains() 判断集合何中是否包含指定对象

 8：containsAll() 判断集合中是否包含指定集合
 使用equals()判断两个对象是否相等 是判断内存地址
 获取:   9：int size()    返回集合容器的大小

 转成数组10： toArray()   集合转换数组

 */
public class CollectionNotion {

    public static void main(String[] args) {
        /**
         * 数据结构的线性结构中有连续存储结构和离散存储结构
         * 1.ArrayList
         */

        /**
         * 2.LinkedList
         * 链表的定义：链表是物理存储单元上非连续、非顺序的存储结构，链表的结点间通过指针相连，
         * 每个结点只对应有一个前驱结点和一个后继结点，其中，首结点没有前驱结点，尾节点没有后
         * 继结点。上述表述共同构成了对链表的定义
         *
         * 单链表：当前结点只存储了后续结点引用，相对双向链表而言，空间复杂的较好。
         * public class Linked<E> {
         *
         *     private static class Node<E>{
         *         private E item;
         *         private Node<E> next;
         *
         *         Node(E data, Node<E> next) {
         *             this.item = data;
         *             this.next = next;
         *         }
         *     }
         *
         * }
         * 双向链表：同时存储了前驱和后续，以空间换时间，操作遍历，但空间复杂度增加了。
         * public class DoublyLinked<E> {
         *
         *
         *     private static class Node<E>{
         *      private Node<E> pre;//前驱引用
         *      private E item;//当前
         *      private Node<E> next;//后续引用
         *
         *      }
         *
           }
         *
         * 静态链表：利用数组巧妙的实现链表，好吧，有啥适用场景？暂时脑补不出来。
         *
         * public class StaticLinked<E> {
         *
         *     private static class Node<E> {

         *     E item;//数据

         *     Integer nextIndex;//后续引用的数组下标 默认情况下，应该是当前size
         *     }
         *
         *
                Node[] linkeds;

            }
         *
         * 循环链表：双向链表的变种，正常双向链表，终端结点的后续应该是null，而循环链表，
         * 指向的是链表的第一个结点，从而实现了闭环，大概有种画个圈圈的感觉
         *
         * public class CircleLinked<E> {
         *
         *     private static class Node<E> {
         *         private Node<E> pre;
         *         private E item;
         *         private Node<E> next;//如果是终端结点，这里保存的是第一个结点的引用地址，从而形成一个闭环
         *     }
         * }
         *
         */
        List linkedList=new LinkedList();
        ((LinkedList) linkedList).addFirst("a");
        ((LinkedList) linkedList).getLast();
    }
}
