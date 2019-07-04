package sword_to_offer;

import structures.RandomListNode;

public class Q025_DuplicateList {
    /*
     * 问题描述:
     *  输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂
     *  链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
     * 解决思路(初始):
     *  在第一遍复制中，先将其按照普通列表进行复制，然后在第二次复制中再复制特殊指针，但问题在于每次去寻找特殊指针时，可能要遍历所有的结点
     *  才可能找到该结点，因此算法的复杂度过高，为O(n^2)，因此不能考虑。
     * 解决思路(改进):
     *  将该问题分解为三步：
     *  1、将链表各结点依次复制，即结点N复制得到的节点N'置于N结节点后；
     *  2、将新链接的节点N'分别按照最初的节点的特殊指针连接；
     *  3、将新得到的复杂链表进行拆分，拆分成一个新的链表以及原始链表；
     * 容易出错的点:
     *
     * Tips:
     */

    public static RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null)
            return null;

        //复制
        RandomListNode currNode = pHead;
        while (currNode != null) {
            RandomListNode newNode = new RandomListNode(currNode.label);
            newNode.next = currNode.next;
            currNode.next = newNode;
            currNode = newNode.next;
        }

        //链接(上次书写过程中主要出问题的部分，下次应当多次注意)
        currNode = pHead;
        while (currNode != null) {
            RandomListNode node = currNode.next;
            if (currNode.random != null)
                node.random = currNode.random.next;
            currNode = node.next;
        }

        //拆分(在自己书写的部分中，是仅仅保留了复制的部分，在这部分代码中，是拆分出两个新的链表)
        currNode = pHead;
        RandomListNode newHead = pHead.next;
        RandomListNode tmp;
        while(currNode.next != null){
            tmp = currNode.next;
            currNode.next = tmp.next;
            currNode = tmp;
        }

        return newHead;
    }



    public static void main(String[] args) {
        RandomListNode root = new RandomListNode(1);
        RandomListNode a1 = new RandomListNode(2);
        RandomListNode a2 = new RandomListNode(3);
        RandomListNode a3 = new RandomListNode(4);

        root.next = a1;
        a1.next = a2;
        a2.next = a3;

        root.random = a2;
        a1.random = a3;
        a2.random = a1;

    }
}
