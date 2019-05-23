package sword_to_offer;

import structures.TreeNode;

public class Q004_ReConstruct_BinaryTree {
    /*
     * 题目描述：
     *   输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     *   例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
     * 算法思想：
     *   最初考虑：
     *      根据二叉树的原理，我们根据前序序列与中序序列可以重建出二叉树，想到的简单思路是递归，将两个序列不断进行划分,以此来构建重建二叉树
     *   简洁思路：
     *
     *   思路描述：
     *
     *   可能的异常输入：
     *      1.输入的序列为空
     *      2.输入的前序序列与中序序列不匹配(*)
     *
     */
    public  TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length == 0 || in.length == 0) {
            return null;
        }
        TreeNode root = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }

    public  TreeNode reConstructBinaryTree(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
        int len = inEnd - inStart + 1;
        if (preStart>preEnd||inStart>inEnd)
            return null;
        // 以先序序列的第一个数字创建新的根节点
        TreeNode root = new TreeNode(pre[preStart]);

        for (int i = 0; i < len; i++) {
            // 找到根节点在中序序列中的位置
            if (in[i + inStart] == pre[preStart]) {
                root.left = reConstructBinaryTree(pre, preStart + 1, preStart + i, in, inStart, inStart + i - 1);
                root.right = reConstructBinaryTree(pre, preStart + i + 1, preEnd, in, inStart + i + 1, inEnd);
            }
        }

        return root;
    }

    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        Q004_ReConstruct_BinaryTree re = new Q004_ReConstruct_BinaryTree();
        TreeNode root = re.reConstructBinaryTree(pre, in);
        System.out.print("后序:");
        TreeNode.lastOrder(root);
        System.out.print("\n先序:");
        TreeNode.preOrder(root);
        System.out.print("\n中序:");
        TreeNode.inOrder(root);
        // 答案为 {7，4，2，5，8，6，3，1}
    }
}
