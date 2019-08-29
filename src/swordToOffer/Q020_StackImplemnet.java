package swordToOffer;

import java.util.Stack;

public class Q020_StackImplemnet {
    /*
     * 问题描述:
     *  定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
     * 解决思路(初始):
     *  在刚拿到题目的时候，对题目理解是有疑惑的，即如何实现栈的数据结构。考虑到之前有使用两个队列来实现栈的结构，因此考虑从该着眼点入手。
     *  然后关于寻找最小元素的min函数，考虑是设置一个最小变量来记录minValue。
     * 解决思路(改进):
     *  在查看书本上的讲解后，发现，若最小元素被弹出栈后，会出现找不到次小元素的问题，因此我们需要的是在每一次入栈是都记录当前的最小数据，
     *  然后压入一个辅助栈中，使得每一次数据出栈时，辅助栈都会相应的出栈记录的数据
     * 容易出错的点:
     *
     * Tips:
     */
    int minValue = Integer.MIN_VALUE;
    Stack<Integer> dataStack = new Stack<Integer>();
    Stack<Integer> minStack = new Stack<Integer>();

    public void push(int node){
        dataStack.push(node);

        if(minStack.size() == 0 || node < minStack.peek())
            minStack.push(node);
        else
            minStack.push(minStack.peek());
    }

    public void pop(){
        if(dataStack.size() == 0 || minStack.size() == 0)
            return;
        dataStack.pop();
        minStack.pop();
    }

    public int top(){
        if(dataStack.size() == 0 || minStack.size() == 0)
            return 0;
        return dataStack.peek();
    }

    public int min(){
        if(minStack.size() == 0)
            return -1;
        return minStack.peek();
    }
}
