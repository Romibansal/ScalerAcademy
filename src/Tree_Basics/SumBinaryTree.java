package Tree_Basics;

//Q=Problem Description
//        Given the root of a binary tree A. Return the sum of all the nodes of the binary tree.
//
//        Problem Constraints
//        1 <= Number of nodes in A <= 10^4
//
//        1 <= value of each node <= 10^4




public class SumBinaryTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
            left=null;
            right=null;
        }
    }
    public int solve(TreeNode A) {
        if(A==null){
            return 0;
        }
        int r=solve(A.right);
        int l=solve(A.left);
        return r+l+A.val;
    }
    public static void main(String[] args) {
        SumBinaryTree I = new SumBinaryTree();
        TreeNode A=new TreeNode(1);
        TreeNode A1=new TreeNode(4);
        TreeNode A2=new TreeNode(3);
        TreeNode A3=new TreeNode(2);
        A.left=A1;
        A.right=A2;
        A1.left=A3;

        System.out.println( I.solve(A));
    }
}


