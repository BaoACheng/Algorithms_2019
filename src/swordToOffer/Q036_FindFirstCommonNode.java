package swordToOffer;


import structures.ListNode;

import java.util.Stack;
public class Q036_FindFirstCommonNode {
    /*
     * 问题描述:
     *  输入两个链表，找出它们的第一个公共结点。
     * 解决思路(初始):
     *  借用两个辅助栈来完成，由于链表只能有一个后续节点，因此两个公用节点的链表应为Y形，因此利用栈"后进先出"的特点，就可以找到第一个公共节点
     * 解决思路(改进):
     *
     * 容易出错的点:
     *
     * Tips:
     *  1、注意错误输入，即输入的两个链表并无任何一个相同节点，或两个链表有一个为空
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null||pHead2 == null)
            return null;
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        ListNode pCur1 = pHead1, pCur2 = pHead2;
        while(pCur1!=null){
            stack1.push(pCur1);
            pCur1 = pCur1.next;
        }
        while(pCur2!=null){
            stack2.push(pCur2);
            pCur2 = pCur2.next;
        }
        ListNode res = null;
        while(!stack1.isEmpty()&&!stack2.isEmpty()){
            ListNode node1 = stack1.pop();
            ListNode node2 = stack2.pop();
            if(node1.val == node2.val){
                res = node1;
            }else{
                return res;
            }
        }
        return res;
    }
}
