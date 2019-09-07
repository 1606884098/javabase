package base.java2dataStructure.tree;

/**
 * 树：树状图是一种数据结构，它是由n（n>=1）个有限结点组成一个具有层次关系的集合。把它叫做“树”是因为它看起来像一棵倒挂的树，也就是说它是根朝上，而叶朝下的。
 * 特点：
 * 每个结点有零个或多个子结点（node）；
 * 没有父结点的结点称为根结点或树根（root）；
 * 每一个非根结点有且只有一个父结点；
 * 除了根结点外，每个子结点可以分为多个不相交的子树
 *
 * jdk里的东西一定是最优秀的东西
 */
public class Tree {
    public static void main(String[] args) {

        /**
         * 二叉树
         */
        int data[]={8,7,2,9,12,93,78,23,41,88};
        BinaryTree root=new BinaryTree(data[0]);
        for(int i=1;i<data.length;i++){
            root.insert(root,data[i]);//插入就进行排序了
        }
        System.out.println("中序遍历为：");
        root.in(root);

    }

    /**
     * 树结构
     */
    class TreeNode{
        String id;//当前节点
        String data;//属性
        String parentId;//父节点的id，如果是空就是root节点
    }

    /**
     * 二叉树：二叉排序树（Binary Sort Tree），又称二叉查找树（Binary Search Tree），亦称二叉搜索树。
     * 特点：
     * 1.如果它的左子树不为空，则左子树上结点的值都小于根节点。
     * 2.如果它的右子树不为空，则右子树上结点的值都大于根节点。
     * 3.子树同样也要尊选以上两点。满足3个特点的就是二叉搜索树
     * 遍历方法：
     *  前序遍历 NLR：访问根结点的操作发生在遍历其左右子树之前
     *  中序遍历 LNR：访问根结点的操作发生在遍历其左右子树之中（间）
     *  后序遍历 LRN：访问根结点的操作发生在遍历其左右子树之后
     *
     *  20亿个点 要找几次？非常高效的查找 最多查32次  2的32次方=21亿  每次都少一半 二分查找是很高效的(前提是有序)
     *
     *  时间复杂度是：log(n) n/2,n/2......
     *
     *  弊端：第一次插入的节点就是根节点，如果第一次是最小就是链条，时间复杂度就是o(n)
     */
    static class BinaryTree{
        int data;//数据
        BinaryTree lchild;//左节点
        BinaryTree rchild;//右节点

        public BinaryTree(int data) {
            this.data=data;
            lchild=null;
            rchild=null;
        }

        /**
         * 添加
         * @param root
         * @param data
         */
        public void insert(BinaryTree root,int data){
            if(root.data<data){//根节点小于data 插入右子树
                if(root.rchild==null){//右边没有值 直接插入
                    root.rchild=new BinaryTree(data);
                }else{
                    insert(root.rchild,data);
                }
            }else {
                if(root.lchild==null){
                    root.lchild=new BinaryTree(data);
                }else {
                    insert(root.lchild,data);
                }
            }

        }

        /**
         * 中序遍历
         * @param root
         */
        public void in(BinaryTree root){
            if(root!=null){
                in(root.lchild);
                System.out.println(root.data+" ");
                in(root.rchild);
            }
        }
    }


    /**
     * AVL树：平衡二叉树 通过左旋和右旋让二叉树变平衡 AVL(追求极致平衡，空间和时间花销太大，实验室的环境)。红黑树是AVL的子集
     * 也就是说是平衡二叉树的一种，比较折中,既能达到80%的效果，又能达到高效，所以红黑树使用广泛
     *
     * 红黑树：是二叉树的一种，是平衡二叉树的一种
     * 特点：
     * 1.每个结点不是红色就是黑色
     * 2.不能可能有连在一起的红色结点
     * 3.根结点都是黑色
     * 4.每个红结点的两个子结点都是黑色，叶子结点都是黑色（下面没有子结点称为叶子结点）有时候为空省略不画
     *
     *
     * 插入的时候全是红色的
     * 旋转和变色规则：
     *
     *
     */

    static class RedBlackTree{

    }
}
