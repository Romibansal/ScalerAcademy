package Tree_Basics;

//Q=Problem Description
//        You are given the root node of a binary tree A. You have to find the height of the given tree.
//
//        A binary tree's height is the number of nodes
//        along the longest path from the root node down to the farthest leaf node.
//
//
//
//        Problem Constraints
//        1 <= Number of nodes in the tree <= 10^5
//
//        0 <= Value of each node <= 10^9

public class TreeHeight {
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
        int l=solve(A.left);
        int r=solve(A.right);
        return Math.max(l,r)+1;
    }
    public static void main(String[] args) {
        TreeHeight I = new TreeHeight();
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

