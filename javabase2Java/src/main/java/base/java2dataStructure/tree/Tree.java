package base.java2dataStructure.tree;

/**
 * 树：树状图是一种数据结构，它是由n（n>=1）个有限结点组成一个具有层次关系的集合。把它叫做“树”是因为它看起来像一棵倒挂的树，也就是说它是根朝上，而叶朝下的。
 * 特点：
 * 每个结点有零个或多个子结点（node）；
 * 没有父结点的结点称为根结点或树根（root）；
 * 每一个非根结点有且只有一个父结点；
 * 除了根结点外，每个子结点可以分为多个不相交的子树
 */
public class Tree {
    public static void main(String[] args) {

    }

    /**
     * 树结构
     */
    class TreeNone{
        String id;//当前节点
        String data;//属性
        String parentId;//父节点的id，如果是空就是root节点
    }

    /**
     * 二叉树：二叉排序树（Binary Sort Tree），又称二叉查找树（Binary Search Tree），亦称二叉搜索树。
     */
    class BinaryTree{
        int data;//数据
        BinaryTree lchild;//左节点
        BinaryTree rchild;//右节点
    }

}
