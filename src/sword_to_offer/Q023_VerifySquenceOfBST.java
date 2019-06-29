package sword_to_offer;

public class Q023_VerifySquenceOfBST {
    /*
     * 问题描述:
     *  输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字
     *  都互不相同。
     * 解决思路(初始):
     *  在该题目中的关键字为二叉搜索树与后序遍历
     *  二叉搜索树拥有如下特性，对于任何一个结点，若其子节点非空，则左子树上的结点小于根节点，右子树上的结点都大于根节点。
     *  后序遍历序列有如下特性：遍历顺序为左右根，即根节点永远在最后面
     *  两个特性结合后，该遍历序列可以分为明显的两部分，一部分是比根节点小的左子树，一部分是比根节点大的右子树
     *  在对树的判定中，通常使用递归，不断的进行划分，若均满足条件，则可以认为该序列是二叉搜索树后续遍历的结果
     * 解决思路(改进):
     *
     * 容易出错的点:
     *
     * Tips:
     */

    public static boolean VerifySquenceOfBST(int[] sequence) {
        if(sequence == null||sequence.length <=0)
            return false;

        return checkSearchTree(sequence, 0, sequence.length-1);
    }

    public static boolean checkSearchTree(int[] sequence, int start, int end){
        if(start>end)
            return true;
        int i = start;
        while(i<end && sequence[i]<sequence[end])
            i++;
        for (int j = i; j < end; j++) {
            if(sequence[j]<=sequence[end])
                return false;
        }
        return checkSearchTree(sequence,start,i-1) && checkSearchTree(sequence, i, end-1);
    }

    public static void main(String[] args) {
        int[] sequence = {4,8,6,12,16,14,10};
        boolean res = VerifySquenceOfBST(sequence);
        System.out.println("res = " + res);
    }
}
