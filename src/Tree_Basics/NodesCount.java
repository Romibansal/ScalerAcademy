package Tree_Basics;

//Q=You are given the root node of a binary tree A. You have to find the number of nodes in this tree.
//
//
//
//        Problem Constraints
//        1 <= Number of nodes in the tree <= 10^5
//
//        0 <= Value of each node <= 10^7

public class NodesCount {
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
        int r =solve(A.right);
        return l+r+1;

    }
    public static void main(String[] args) {
        NodesCount I = new NodesCount();
        TreeNode A=new TreeNode(1);
        TreeNode A1=new TreeNode(6);
        TreeNode A2=new TreeNode(2);
        TreeNode A3=new TreeNode(3);
        A.left=A1;
        A.right=A2;
        A2.left=A3;

        System.out.println( I.solve(A));
    }
}


