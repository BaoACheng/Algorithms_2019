package sword_to_offer;

import structures.TreeNode;
import exceptions.NotExistException;

public class Q004_ReConstruct_BinaryTree {
    /*
     * 题目描述：
     *   输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     *   例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
     * 算法思想：
     *   最初考虑：
     *      根据二叉树的原理，我们根据前序序列与中序序列可以重建出二叉树，想到的简单思路是递归，将两个序列不断进行划分
     *   简洁思路：
     *
     *   思路描述：
     *
     *   可能的异常输入：
     *      1.输入的序列为空
     *      2.输入的前序序列与中序序列不匹配(*)
     *
     */
    public static TreeNode reConstruct(int[] pre, int[] mid){
        if (pre.length == 0 || mid.length == 0) {
            return null;
        }
        TreeNode root = reConstruct(pre, 0, pre.length - 1, mid, 0, mid.length - 1);
        return root;
    }

    public static TreeNode reConstruct(int[] pre, int preStart, int preEnd, int[] mid, int midStart, int midEnd){
        if (preStart > preEnd || midStart > midEnd) {
            return null;
        }
        // 根据前序序列的首位创建树节点
        TreeNode root = new TreeNode(pre[preStart]);
        // 找到根在中序序列的位置
        for (int i = 0; i < mid.length; i++) {
            if (mid[i] == pre[preStart]) {
                root.left = reConstruct(pre, preStart + 1, preStart + i - midStart, mid, midStart, i - 1);
                root.right = reConstruct(pre, preStart + i - midStart + 1, preEnd, mid, i + 1, midEnd);
            }
        }
        //书写的错误代码，但是目前不知道错误原因 20190316
        //root.left = reConstruct(pre, preStart + 1, preStart + index, mid, midStart, midStart + index - 1);
        //root.right = reConstruct(pre, preStart + index + 1, preEnd, mid, midStart + index + 1, midEnd);

        return root;
    }

    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] mid = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode root = reConstruct(pre, mid);
        TreeNode.lastOrder(root);

    }
}
