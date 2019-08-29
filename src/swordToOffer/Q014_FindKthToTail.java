package swordToOffer;

import structures.ListNode;

public class Q014_FindKthToTail {
    /*
     * 问题描述:
     *  输入一个链表，输出该链表中倒数第k个结点。
     * 解决思路:
     *  在链表中设定两个指针，一个指针指向开头，一个指针指向开头后的第k个结点，然后依次后移，当后一个指针指向最后一个节点时，第一个指针指向
     *  的即为倒数第k个结点
     * 容易出错的点:
     *  边界判定：首先当链表长度不足k时，应作出越界提醒
     *  空指针判定：要注意到在判定时不能以节点的next为准则，而要判断节点自身
     * Tips:
     */

    public static ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k < 0)
            return null;
        ListNode pre = head, post = head;
        for (int i = 0; i < k; i++) {
            if (post != null)
                post = post.next;
            else
                return null;
        }
        while (post != null) {
            pre = pre.next;
            post = post.next;
        }
        return pre;
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

        ListNode k = FindKthToTail(a1, 5);

        while(k!=null){
            System.out.println(k.val);
            k = k.next;
        }
    }
}
