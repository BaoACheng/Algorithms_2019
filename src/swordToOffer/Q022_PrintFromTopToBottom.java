package swordToOffer;

import structures.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Q022_PrintFromTopToBottom {
    /*
     * 问题描述:
     *  从上往下打印出二叉树的每个节点，同层节点从左至右打印。
     * 解决思路(初始):
     *  从问题的描述中，我们可以很轻易的看出，题目是树的层次遍历，需要利用队列来完成操作
     * 解决思路(改进):
     *
     * 容易出错的点:
     *
     * Tips:
     */

    public static ArrayList<Integer> printFromTopToBottom(TreeNode root){

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(root == null)
            return list;
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode temp = ((LinkedList<TreeNode>) queue).pop();
            list.add(temp.val);
            if(temp.left != null)
                queue.offer(temp.left);
            if(temp.right != null)
                queue.offer(temp.right);
        }
        return list;
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

        ArrayList<Integer> list = printFromTopToBottom(root);

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
