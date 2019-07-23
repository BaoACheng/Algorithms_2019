package sword_to_offer;

import structures.ListNode;

import java.util.HashMap;

public class Q055_DeleteDuplicateNode {

    /*
     * 问题描述:
     *  在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
     *  例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
     * 解决思路(初始):
     *  由于题目中讲明是排序的链表，那么我们可以设置一个index来记录前一个结点的值，并与当前结点判断，若相同则不保留
     * 解决思路(改进):
     *
     * 容易出错的点:
     *  第一次出错是因为读题不准确，认为只删除多余出现的结点，但实际是删除所有重复的结点
     *  第二次出错是因为考虑情况不周全，实际存在多种错误输入：
     *  1、如1 3 3 5 5
     *  2、如1 1 1 1 2
     *  3、如1 1 2 2 2
     * Tips:
     *  学会使用语法糖，设置一个新的哨兵结点，可以避免初始结点选取的问题
     */

    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null)
            return pHead;
        HashMap<Integer, Integer> map = new HashMap<>();
        ListNode p1 = pHead, p2;
        while (p1 != null) {
            if (map.containsKey(p1.val)) {
                map.put(p1.val, map.get(p1.val) + 1);
            } else {
                map.put(p1.val, 1);
            }
            p1 = p1.next;
        }

        p1 = pHead;
        boolean hasOneNode = false;
        while (p1 != null) {
            if (map.get(p1.val) == 1) {
                hasOneNode = true;
                break;
            } else
                p1 = p1.next;
        }
        if (!hasOneNode)
            return null;
        pHead = p1;
        p2 = p1.next;
        while (p2 != null) {
            if (map.get(p2.val) > 1) {
                if (p2.next == null) {
                    p1.next = null;
                    break;
                }
                p2 = p2.next;
            } else {
                p1.next = p2;
                p1 = p1.next;
                p2 = p2.next;
            }
        }
        return pHead;
    }

    public ListNode deleteDuplication_new(ListNode pHead) {
        if (pHead == null || pHead.next == null)
            return pHead;
        ListNode newHead = new ListNode(0);
        newHead.next = pHead;
        ListNode p1 = newHead;
        ListNode p2 = newHead.next;
        while (p2 != null) {
            if (p2.next != null && p2.next.val == p2.val) {
                while (p2.next != null && p2.next.val == p2.val) {
                    p2 = p2.next;
                }
                p1.next = p2.next;
                p2 = p2.next;
            } else {
                p1 = p1.next;
                p2 = p2.next;
            }
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        Q055_DeleteDuplicateNode delete = new Q055_DeleteDuplicateNode();
        ListNode node = ListNode.getList();
        ListNode.print(node);
        ListNode res = delete.deleteDuplication_new(node);
        System.out.println();
        ListNode.print(res);
    }
}
