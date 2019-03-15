package structures;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(){
        this.val = -1;
        this.left = null;
        this.right = null;
    }

    public TreeNode(int value){
        this.val = value;
        this.left = null;
        this.right = null;
    }

    public TreeNode(int value, TreeNode left, TreeNode right){
        this.val = value;
        this.left = left;
        this.right = right;
    }

    public static void preOrder(TreeNode root){
        if(root!=null){
            System.out.print(root.val);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public static void inOrder(TreeNode root){
        if(root!=null){
            inOrder(root.left);
            System.out.print(root.val);
            inOrder(root.right);
        }
    }

    public static void lastOrder(TreeNode root){
        if(root!=null){
            lastOrder(root.left);
            lastOrder(root.right);
            System.out.print(root.val);
        }
    }

}
