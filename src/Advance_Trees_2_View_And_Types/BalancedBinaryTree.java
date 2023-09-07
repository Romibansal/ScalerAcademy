package Advance_Trees_2_View_And_Types;

//Q=Problem Description
//        Given a root of binary tree A, determine if it is height-balanced.
//
//        A height-balanced binary tree is defined as a binary tree in which the depth of the two
//        subtrees of every node never differ by more than 1.
//
//
//
//        Problem Constraints
//        1 <= size of tree <= 100000


//Example Input
//        Input 1:
//
//        1
//       / \
//      2   3
//        Input 2:
//
//
//        1
//       /
//      2
//     /
//    3

//
//Example Output
//        Output 1:
//
//        1

//        Output 2:
//
//        0

public class BalancedBinaryTree {
    public int isBalanced(TreeNode A) {
        if(checkBalanced(A) == 0) {
            return 0;
        }
        return 1;
    }
    int flag=0;
    public int checkBalanced(TreeNode A) {
        if(A == null) {
            return 0;
        }
        int left = checkBalanced(A.left);
        int right = checkBalanced(A.right);
        if(flag==1){
            return 0;
        }
        if(Math.abs(left-right) > 1) {
            flag=1;
            return 0;
        }

        return Math.max(left, right)+1;
    }
    public static void main(String[] args) {
        BalancedBinaryTree I = new BalancedBinaryTree();
        TreeNode A=new TreeNode(6);
        TreeNode A2=new TreeNode(9);
        TreeNode A3=new TreeNode(4);
        TreeNode A4=new TreeNode(8);
        TreeNode A5=new TreeNode(3);

        A.left=A2;
        A.right=A3;
        A3.left=A4;
        A4.right=A5;

        System.out.println( I.isBalanced(A));
    }
}

