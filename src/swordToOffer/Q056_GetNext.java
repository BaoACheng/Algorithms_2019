package swordToOffer;

import structures.TreeLinkNode;

public class Q056_GetNext {
    /*
     * 问题描述:
     *  给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
     * 解决思路(初始):
     *  中序遍历的顺序是左中右，
     * 解决思路(改进):
     *
     * 容易出错的点:
     *  可能存在的情况：
     *  1、叶子结点->最左叶子结点或最右叶子节点
     *  2、非叶子节点->直接输出结点右孩子的最左
     *  (上述考虑情况不准确 20190718)
     *  可能存在的情况：
     *  1、右子树为空
     *  2、右子树非空
     * Tips:
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        //首先做异常输入判断
        if (pNode == null)
            return null;
        if(pNode.right!=null){
            pNode = pNode.right;
            while(pNode.left!=null)
                pNode = pNode.left;
            return pNode;
        }
        while(pNode.next !=null){
            if(pNode == pNode.next.left)
                return pNode.next;
            pNode = pNode.next;
        }
        return null;
    }
}
