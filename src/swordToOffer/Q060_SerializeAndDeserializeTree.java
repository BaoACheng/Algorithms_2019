package swordToOffer;

import structures.TreeNode;

public class Q060_SerializeAndDeserializeTree {
    /*
     * 问题描述:
     *  请实现两个函数，分别用来序列化和反序列化二叉树
     * 解决思路(初始):
     *
     * 解决思路(改进):
     *
     * 容易出错的点:
     *
     * Tips:
     */

    public String Serialize(TreeNode root) {
        if (root == null)
            return "";
        String serialStr = "";
        serialStr = SerializeCore(root, serialStr);
        return serialStr;
    }

    public String SerializeCore(TreeNode root, String str) {
        if (root == null) {
            str += "#!";
            return str;
        }
        str += root.val;
        str += "!";
        str = SerializeCore(root.left, str);
        str = SerializeCore(root.right, str);
        return str;
    }
    int index = -1;
    public TreeNode Deserialize(String str) {
        if(str==null)
            return null;
        index++;
        String[] strs = str.split("!");
        TreeNode node = null;
        System.out.println(strs[index]);
        if(!strs[index].equals("#")){
            node = new TreeNode(Integer.valueOf(strs[index]));
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        }
        return node;

    }

    public static void main(String[] args) {
        Q060_SerializeAndDeserializeTree serialize = new Q060_SerializeAndDeserializeTree();
        TreeNode root = TreeNode.getTree();
        String res = serialize.Serialize(root);
        System.out.println(res);
        System.out.println();
        TreeNode node = serialize.Deserialize(res);
        TreeNode.inOrder(node);
    }
}
