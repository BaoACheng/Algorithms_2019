package sword_to_offer;

import structures.TreeNode;

public class Q057_IsSymmetrical {
    /*
     * 问题描述:
     *  请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
     * 解决思路(初始):
     *  对于二叉树的判定，通常使用递归来进行，我们分别判断其左右子树结点是否相同，若继续往下递归，若中间有任何一步出现问题，则直接返回false
     * 解决思路(改进):
     *
     * 容易出错的点:
     *
     * Tips:
     */
    public boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null)
            return true;
        return MirrorCore(pRoot.left, pRoot.right);
    }

    public boolean MirrorCore(TreeNode left, TreeNode right) {
        //当一个为空，另一个非空，则直接返回false，两个都为空，则返回true
        if(left == null && right == null)
            return true;
        if(left == null || right == null)
            return false;
        // 分别对两个子树进行判定
        if(left.val == right.val)
            return MirrorCore(left.left, right.right) && MirrorCore(left.right, right.left);
        else
            return false;
    }
}
