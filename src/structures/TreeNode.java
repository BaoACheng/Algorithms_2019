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

    public static TreeNode getSimpleTree(){
        TreeNode root = new TreeNode(1);
        TreeNode a1 = new TreeNode(2);
        TreeNode a2 = new TreeNode(3);
        TreeNode b1 = new TreeNode(4);
        TreeNode b2 = new TreeNode(5);


        root.left = a1;
        root.right = a2;
        a1.left = b1;
        a1.right = b2;


        return root;
    }

    public static TreeNode getTree(){
        TreeNode root = new TreeNode(10);
        TreeNode a1 = new TreeNode(6);
        TreeNode a2 = new TreeNode(14);
        TreeNode b1 = new TreeNode(4);
        TreeNode b2 = new TreeNode(8);
        TreeNode b3 = new TreeNode(12);
        TreeNode b4 = new TreeNode(16);

        root.left = a1;
        root.right = a2;
        a1.left = b1;
        a1.right = b2;
        a2.left = b3;
        a2.right = b4;

        return root;
    }

}
