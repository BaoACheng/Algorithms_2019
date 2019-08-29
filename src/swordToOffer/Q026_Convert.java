package swordToOffer;

import structures.TreeNode;

public class Q026_Convert {
    /*
     * 问题描述:
     *  输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
     * 解决思路(初始):
     *  二叉搜索树：类似于二叉搜索的过程，在节点中若存在左子树和右子树，则左子树的值一定比其父节点的值小，右子树的值一定比其父节点的值大
     *  二叉搜索树的中序遍历即为数组升序序列.
     *  转换方法：我们首先考虑一种特殊情况，当该二叉搜索树中只有根节点与其左右结点的简单情况，我们可以发现，对于该简单树，我们需要做的是，
     *  将左叶子节点的right链接指向root，然后将右叶子节点的left链接指向root。那么我们就可以将这一复杂问题进行分解为一个左子树、根节点与
     *  右子树的问题，然后将每个子树进一步的划分，直到分解为我们可以解决的简单问题，那么我们此时需要一个辅助currLast，来记忆到已完成转换
     *  链表的最后一个节点的位置。
     * 解决思路(改进):
     *
     * 容易出错的点:
     *  根据剑指offer上所书写思路完成的代码，会不断的丢失所有左子树中的last记录，因此必须在函数中将last返回并接收，last的值才会发生改变，
     *  否则在所有的ConvertNode函数中last的值会一直为null
     * Tips:
     */
    public TreeNode Convert(TreeNode pRootOfTree) {
        TreeNode last = null;
        ConvertNode(pRootOfTree, last);
        TreeNode listHead = pRootOfTree;
        while (listHead!=null && listHead.left!=null)
            listHead = listHead.left;
        return listHead;
    }

    public TreeNode ConvertNode(TreeNode root, TreeNode last) {
        //若传入的结点为空，则直接返回
        if (root == null)
            return null;
        TreeNode current = root;
        //寻找树中的最小元素
        if (current.left != null)
            last = ConvertNode(current.left, last);
        //更改链接
        current.left = last;
        //在非初始阶段，需要将最后一个结点的右链接指向根节点
        if (last != null)
            last.right = current;
        //更新last位置
        last = current;
        //根节点的左子树完成，开始迭代右子树
        if (current.right != null)
            last = ConvertNode(current.right, last);
        return last;
    }

    public static void main(String[] args) {
        Q026_Convert convert = new Q026_Convert();
        TreeNode root = TreeNode.getTree();
        TreeNode listHead = convert.Convert(root);
        while(listHead!=null) {
            System.out.print(listHead.val + " ");
            listHead = listHead.right;
        }
    }
}
