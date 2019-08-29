package swordToOffer;

import structures.TreeNode;

public class Q017_HasSubtree {
    /*
     * 问题描述:
     *  输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
     * 解决思路(初始):
     *  对于判定树结构，通常想到的是递归，当判定两个树的根节点数据相同时，则继续判定其左子树与右子树
     * 解决思路(改进):
     *
     * 容易出错的点:
     *
     * Tips:
     *
     */

    public static boolean hasSubtree(TreeNode root1, TreeNode root2){
        if(root1 == null || root2 == null)
            return false;
        boolean check = false;

        if(root1.val == root2.val){
            check = mainCheck(root1, root2);
        }
        if(!check)
            check = mainCheck(root1.left, root2);
        if(!check)
            check = mainCheck(root1.right, root2);
        return check;
    }

    public static boolean mainCheck(TreeNode root1, TreeNode root2){
        if(root2 == null)
            return true;
        if(root1 == null)
            return false;
        if(root1.val == root2.val){
            boolean checkLeft = mainCheck(root1.left,root2.left);
            boolean checkRight = mainCheck(root1.right,root2.right);
            if(checkLeft && checkRight)
                return true;
        }
        return false;
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

        boolean check = hasSubtree(root, a2);
        System.out.println("check = " + check);
    }
}
