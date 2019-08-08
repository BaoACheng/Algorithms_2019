package swordToOffer;

import structures.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Q059_PrintSpecial2 {
    /*
     * 问题描述:
     *  从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
     * 解决思路(初始):
     *  在牛客网的视频中有学习到相关问题，此时可以使用两个指针来进行是否换行操作
     * 解决思路(改进):
     *
     * 容易出错的点:
     *
     * Tips:
     */
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> all = new ArrayList<>();
        if (pRoot == null)
            return all;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        TreeNode p1 = null, p2 = pRoot;
        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            while (p1 != p2) {
                p1 = queue.poll();
                list.add(p1.val);
                if (p1.left != null)
                    queue.add(p1.left);
                if (p1.right != null)
                    queue.add(p1.right);
            }
            all.add(list);
            p2 = ((LinkedList<TreeNode>) queue).peekLast();
        }
        return all;
    }

    public static void main(String[] args) {
        Q059_PrintSpecial2 print = new Q059_PrintSpecial2();
        TreeNode root = TreeNode.getTree();
        System.out.println(print.Print(root));
    }
}
