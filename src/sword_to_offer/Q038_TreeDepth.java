package sword_to_offer;


import structures.TreeNode;

public class Q038_TreeDepth {
    /*
     * 问题描述:
     *  输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
     * 解决思路(初始):
     *  对于二叉树，经常使用的方法是迭代，并在迭代中对左右子树的长度进行对比，并返回最大的深度
     * 解决思路(改进):
     *
     * 容易出错的点:
     *
     * Tips:
     *
     */
    public int TreeDepth(TreeNode root) {
        if(root == null)
            return 0;
        int depth = TreeDepthCore(root, 1);
        return depth;
    }

    public int TreeDepthCore(TreeNode root,int depth){
        int leftDepth = depth, rightDepth = depth;
        if(root.left != null) {
            leftDepth = TreeDepthCore(root.left, depth + 1);
        }
        if(root.right != null) {
            rightDepth = TreeDepthCore(root.right, depth + 1);
        }
        return leftDepth>rightDepth?leftDepth:rightDepth;
    }
}
