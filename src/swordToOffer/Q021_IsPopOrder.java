package swordToOffer;

import java.util.Stack;

public class Q021_IsPopOrder {
    /*
     * 问题描述:
     *  输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。
     *  例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列
     *  的弹出序列。（注意：这两个序列的长度是相等的）
     * 解决思路(初始):
     *  拿到题目时的思路是模拟出栈序列的过程，但如何细化操作没有太详细的想法
     * 解决思路(改进):
     *  通过利用一个辅助栈来进行模拟栈的压入与弹出，每压入一个元素到栈内，就判断，其是否与当前出栈队列第一个元素相同，若相同，则两者弹出，
     *  若不同，则继续将后续元素压入栈，直到所有元素入栈。若此时栈内有元素，且栈顶元素与出栈队里元素不同，该弹出序列与入栈序列不匹配。
     *  1、首先将入栈序列压栈，然后检查，若与出栈队列元素相同，则出栈，并将两个指针后移
     *  2、当所有元素入栈，且出栈队列不为空，则判定不匹配
     * 容易出错的点:
     *  边界判定：虽然题目中给出了提出，两个序列长度相等，但还是应当考虑当传入两个空序列时的特殊情况，应当直接直接返回false
     * Tips:
     */

    public static boolean IsPopOrder(int[] push, int[] pop){
        int lenPush = push.length;
        int lenPop = pop.length;
        if(lenPop == 0 || lenPush == 0)
            return false;
        Stack<Integer> stack = new Stack<Integer>();

        int i = 0, j = 0;
        for(;i<lenPush && j<lenPop;i++){
            //首先将元素入栈
            stack.push(push[i]);
            //检查栈顶元素是否与出栈序列相同
            while(!stack.isEmpty() && stack.peek() == pop[j]){
                //若相同则直接出栈，并将出栈序列后移
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] push = {1,2,3,4,5};
        //int[] pop = {4,5,3,2,1};
        int[] pop = {4,3,5,1,2};

        boolean check = IsPopOrder(push, pop);
        System.out.println("check = :" + check);
    }
}
