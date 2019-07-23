package sword_to_offer;

import structures.ListNode;

public class Q054_EntryNodeOfLoop {
    /*
     * 问题描述:
     *  给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
     * 解决思路(初始):
     *  拿到问题的时候一脸茫然(完全没有思路) 20190718
     * 解决思路(改进):
     *
     * 容易出错的点:
     *
     * Tips:
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode fast = pHead, low = pHead;
        while ( fast != null && fast.next != null ) {
            fast = fast.next.next;
            low = low.next;
            if(fast == low){
                low = pHead;
                while(low != fast){
                    low = low.next;
                    fast = fast.next;
                }
                if(low == fast)
                    return low;
            }
        }
        return null;
    }
}
