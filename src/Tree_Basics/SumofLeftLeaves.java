package Tree_Basics;

//Q=Problem Description
//
//        Given a binary tree, find and return the sum of node value of all left leaves in it.
//
//        Problem Constraints
//        1 <= number of nodes <= 5 * 10^5
//
//        1 <= node value <= 10^5

public class SumofLeftLeaves {
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
    int sum(TreeNode N,Boolean B){
        if(N==null){
            return 0;
        }
        int left=sum(N.left,true);
        int right=sum(N.right,false);
        if(B && N.right==null && N.left==null){
            return left+right+N.val;
        }
        else{
            return left+right;
        }
    }
    public int solve(TreeNode A) {
        int ans=sum(A,false);
        return ans;
    }
    public static void main(String[] args) {
        SumofLeftLeaves I = new SumofLeftLeaves();
        TreeNode A=new TreeNode(3);
        TreeNode A1=new TreeNode(9);
        TreeNode A2=new TreeNode(20);
        TreeNode A3=new TreeNode(15);
        TreeNode A4=new TreeNode(7);
        A.left=A1;
        A.right=A2;
        A2.left=A3;
        A2.right=A4;

        System.out.println( I.solve(A));
    }
}


