package swordToOffer;

import structures.TreeNode;

import java.util.ArrayList;

public class Q024_FindPath {
    /*
     * 问题描述:
     *  输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点
     *  所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
     * 解决思路(初始):
     *  从种子结点开始，依次将其加入到list序列中
     * 解决思路(改进):
     *
     * 容易出错的点:
     *  边界值：当传入的结点为空时
     * Tips:
     *  对于该函数是如何
     */
    ArrayList<ArrayList<Integer>> all = new ArrayList<ArrayList<Integer>>();
    //创建一个公共变量记录当前的路径，所有函数共同维护这一变量
    ArrayList<Integer> list = new ArrayList<Integer>();

    public  ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        //若传入的结点为空，则直接返回结果，在程序的递归调用中，这里表示分支的终结，因为并没有对结果值进行接收
        if (root == null)
            return all;
        //将节点加入到路径中，并减去该结点值，生成新的target
        list.add(root.val);
        target -= root.val;
        //若该结点为叶子节点，且路径已达到要求，则生成路径，并加入到all中
        if (target == 0 && root.left == null && root.right == null)
            all.add(new ArrayList<>(list));

        //若子节点非空，则继续下一步的递归调用
        if (root.left != null)
            FindPath(root.left, target);
        if (root.right != null)
            FindPath(root.right, target);
        //当调用结束后，回到该分支的父节点
        list.remove(list.size() - 1);
        return all;
    }
}
