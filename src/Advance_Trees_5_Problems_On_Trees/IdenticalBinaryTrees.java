package Advance_Trees_5_Problems_On_Trees;


//Q=Problem Description
//        Given two binary trees, check if they are equal or not.
//
//        Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
//
//
//
//        Problem Constraints
//        1 <= number of nodes <= 10^5
//
//
//
//        Input Format
//        The first argument is a root node of the first tree, A.
//
//        The second argument is a root node of the second tree, B.
//
//
//
//        Output Format
//        Return 0 / 1 ( 0 for false, 1 for true ) for this problem.
//
//
//
//        Example Input
//        Input 1:
//
//        1       1
//       / \     / \
//      2   3   2   3
//        Input 2:
//
//        1       1
//       / \     / \
//      2   3   3   3
//
//
//        Example Output
//
//        Output 1:
//
//        1
//
//        Output 2:
//
//        0
//
//
//        Example Explanation
//
//        Explanation 1:
//
//        Both trees are structurally identical and the nodes have the same value.
//
//        Explanation 2:
//
//        Values of the left child of the root node of the trees are different.



public class IdenticalBinaryTrees {
    public int isSameTree(TreeNode A, TreeNode B) {
        if(A==null && B==null){
            return 1;
        }
        if(A==null && B!=null){
            return 0;
        }
        if(A!=null && B==null){
            return 0;
        }
        if(A.val!=B.val){
            return 0;
        }


        int l=isSameTree(A.left,B.left);
        int r=isSameTree(A.right,B.right);

        if(l==0 || r==0){
            return 0;
        }
        return 1;

    }
    public static void main(String[] args) {
        IdenticalBinaryTrees I = new IdenticalBinaryTrees();
        TreeNode A=new TreeNode(1);
        TreeNode A2=new TreeNode(2);
        TreeNode A3=new TreeNode(3);
        A.left=A2;
        A.right=A3;
        TreeNode A4=new TreeNode(4);
        TreeNode A5=new TreeNode(5);
        A2.left=A4;
        A2.right=A5;
        TreeNode A6=new TreeNode(6);
        TreeNode A7=new TreeNode(7);
        A3.left=A6;
        A6.right=A7;

        TreeNode B=new TreeNode(1);
        TreeNode B2=new TreeNode(2);
        TreeNode B3=new TreeNode(3);
        B.left=B2;
        B.right=B3;
        TreeNode B4=new TreeNode(4);
        TreeNode B5=new TreeNode(8);
        B2.left=B4;
        B2.right=B5;
        TreeNode B6=new TreeNode(6);
        TreeNode B7=new TreeNode(7);
        B3.left=B6;
        B6.right=B7;

        System.out.println( I.isSameTree(A,B));
    }
}



