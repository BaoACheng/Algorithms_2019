package swordToOffer;

import structures.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class Q058_PrintSpecial {
    /*
     * 问题描述:
     *  请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，
     *  其他行以此类推。
     * 解决思路(初始):
     *  类似二叉树的层次输出问题的进阶，因为涉及倒序正序的输出，考虑的问题是奇数行则使用队列，偶数行则使用栈来保存
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
        boolean isOne = true;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack2.add(pRoot);
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if (isOne) {
                ArrayList<Integer> list = new ArrayList<>();
                while (!stack2.isEmpty()) {
                    TreeNode temp = stack2.pop();
                    list.add(temp.val);
                    if (temp.left != null)
                        stack1.add(temp.left);
                    if (temp.right != null)
                        stack1.add(temp.right);
                }
                all.add(list);
                isOne = false;
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                while (!stack1.isEmpty()) {
                    TreeNode temp = stack1.pop();
                    list.add(temp.val);
                    if (temp.right != null)
                        stack2.add(temp.right);
                    if (temp.left != null)
                        stack2.add(temp.left);
                }
                all.add(list);
                isOne = true;
            }
        }
        return all;
    }

    public static void main(String[] args) {
        Q058_PrintSpecial print = new Q058_PrintSpecial();
        TreeNode root = TreeNode.getSimpleTree();
        TreeNode.inOrder(root);
        ArrayList<ArrayList<Integer>> res = print.Print(root);
        System.out.println(res);
    }
}
