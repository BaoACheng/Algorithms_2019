package sword_to_offer;

import structures.TreeNode;

public class Q018_MirrorTree {
    /*
     * 问题描述:
     *  操作给定的二叉树，将其变换为源二叉树的镜像。
     * 解决思路(初始):
     *  对树的操作，通常使用递归来进行，在本题中对二叉树进行进项操作，因此我们可以考虑不断的交换其左右子树
     * 解决思路(改进):
     *
     * 容易出错的点:
     *  边界判定：应考虑传入空树时的判定
     * Tips:
     */

    public static void mirrorTree(TreeNode root){
        if(root == null)
            return;
        mirrorSwap(root);
        mirrorTree(root.left);
        mirrorTree(root.right);
    }

    public static void mirrorSwap(TreeNode root){
        if(root == null)
            return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode a1 = new TreeNode(2);
        TreeNode a2 = new TreeNode(3);
        TreeNode a3 = new TreeNode(4);
        TreeNode a4 = new TreeNode(5);
        TreeNode a5 = new TreeNode(6);

        root.left = a1;
        root.right = a2;
        a1.left = a3;
        a1.right = a4;
        a2.left = a5;

        TreeNode.preOrder(root);
        mirrorTree(root);
        TreeNode.preOrder(root);
    }
}
