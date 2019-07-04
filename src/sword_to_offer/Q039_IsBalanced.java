package sword_to_offer;


import structures.TreeNode;

public class Q039_IsBalanced {
    /*
     * 问题描述:
     *  输入一棵二叉树，判断该二叉树是否是平衡二叉树。
     * 解决思路(初始):
     *  平衡二叉树--树中的任何子树都为平衡二叉树
     *  平衡二叉树的定义为：其中的任何左右子树，其深度差都不超过1
     *  对二叉树的处理一般直接使用递归判断会比较简单
     * 解决思路(改进):
     *
     * 容易出错的点:
     *
     * Tips:
     *
     */
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null)
            return true;

        return getDepth(root) != -1;
    }

    public int getDepth(TreeNode root) {
        if (root == null) return 0;
        int left = getDepth(root.left);
        if (left == -1) return -1;
        int right = getDepth(root.right);
        if (right == -1) return -1;
        return Math.abs(left - right) > 1 ? -1 : 1 + Math.max(left, right);

    }
}
