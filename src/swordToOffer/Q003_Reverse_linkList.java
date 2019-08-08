package swordToOffer;

import structures.ListNode;

import java.util.ArrayList;
import java.util.Stack;

public class Q003_Reverse_linkList {
    /*
     * 题目描述：
     *   输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
     * 算法思想：
     *   最初考虑：
     *      遍历链表，将链表的数据读入到一个数组中，然后逆序进行创建，返回新创建的链表头，算法空间复杂度为O(n)
     *   简洁思路：
     *      考虑该方法符合栈的特性，因此与栈相结合，可以简化效率
     *   思路描述：
     *
     */
    public static ArrayList<Integer> reverse(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if (listNode == null || listNode.next == null)
            return list;
        Stack<Integer> stack = new Stack<>();
        ListNode p = listNode;
        while (p != null) {
            stack.push(p.val);
            p = p.next;
        }
        while (!stack.isEmpty())
            list.add(stack.pop());
        return list;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.getList();
        ArrayList list = reverse(head);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
