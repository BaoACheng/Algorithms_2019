package swordToOffer;

import structures.ListNode;

public class Q015_ReverseList {
    /*
     * 问题描述:
     *  输入一个链表，反转链表后，输出新链表的表头。
     * 解决思路(初始):
     *  最开始的设想是读出链表中的左右数据，然后依次创建一个新的链表
     * 解决思路(改进):
     *  直接在原链表的基础上进行修改，尝试使用两个指针进行链表的翻转
     * 容易出错的点:
     *  边界判定;
     *  反转过程小心断链;
     * Tips:
     */

    public static ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode reverseHead = null;
        ListNode p1 = null;
        ListNode p2 = head;

        while (p2 != null) {
            ListNode p3 = p2.next;

            if(p2.next == null)
                reverseHead = p2;

            p2.next = p1;
            p1 = p2;
            p2 = p3;
        }

        return reverseHead;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);

        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;

        ListNode head = ReverseList(a1);
        while(head!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
