package sword_to_offer;

import structures.ListNode;

public class Q016_MergeList {
    /*
     * 问题描述:
     *  输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
     * 解决思路(初始):
     *  这是考察归并排序在链表中的应用，初步设想是逐个对比，将较小的节点链接到新的链表中，并将记录指针后移
     * 解决思路(改进):
     *  所书写代码可以完成基本功能，但过于繁琐，存在很多可以复用的部分，应当尽量简化代码流程，因此可以考虑递归的调用自身
     * 容易出错的点:
     *
     * Tips:
     */

    public static ListNode mergeList(ListNode p1, ListNode p2) {
        if (p1 == null)
            return p2;
        if (p2 == null)
            return p1;

        ListNode head;
        if(p1.val<p2.val) {
            head = p1;
            p1 = p1.next;
        }else{
            head = p2;
            p2 = p2.next;
        }
        ListNode p = head;
        while (p1 != null && p2 != null) {
            if(p1.val< p2.val){
                p.next = p1;
                p = p.next;
                p1 = p1.next;
            }else {
                p.next = p2;
                p = p.next;
                p2 = p2.next;
            }
        }
        if(p1 != null)
            p.next = p1;
        if(p2 != null)
            p.next = p2;

        return head;
    }

    public static ListNode mergeList_new(ListNode list1, ListNode list2){
        if(list1 == null)
            return list2;
        if(list2 == null)
            return list1;

        ListNode head;
        if(list1.val<list2.val){
            head = list1;
            head.next = mergeList_new(list1.next, list2);
        }else{
            head = list2;
            head.next = mergeList_new(list1, list2.next);
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(5);
        ListNode a4 = new ListNode(7);
        ListNode a5 = new ListNode(10);

        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;

        ListNode b1 = new ListNode(2);
        ListNode b2 = new ListNode(4);
        ListNode b3 = new ListNode(6);
        ListNode b4 = new ListNode(8);
        ListNode b5 = new ListNode(9);

        b1.next = b2;
        b2.next = b3;
        b3.next = b4;
        b4.next = b5;

        ListNode head = mergeList_new(a1,b1);
        while(head!=null){
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
