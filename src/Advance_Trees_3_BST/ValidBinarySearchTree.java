package Advance_Trees_3_BST;

//Q=Problem Description
//        You are given a binary tree represented by root A. You need to check if it is a Binary Search Tree or not.
//
//        Assume a BST is defined as follows:
//
//        1) The left subtree of a node contains only nodes with keys less than the node's key.
//
//        2) The right subtree of a node contains only nodes with keys greater than the node's key.
//
//        3) Both the left and right subtrees must also be binary search trees.
//
//
//
//        Problem Constraints
//        1 <= Number of nodes in binary tree <= 10^5
//
//        0 <= node values <= 2^32-1
//
//
//
//        Input Format
//        First and only argument is head of the binary tree A.
//
//
//
//        Output Format
//        Return 0 if false and 1 if true.
//
//
//
//        Example Input

//        Input 1:
//
//
//        1
//       /  \
//      2    3
//
//        Input 2:
//
//        2
//       / \
//      1   3
//
//
//
//    Example Output
//
//        Output 1:
//
//        0
//
//        Output 2:
//
//        1



public class ValidBinarySearchTree {

    public int isValidBST(TreeNode A) {
        return validBST(A,Integer.MIN_VALUE,Integer.MAX_VALUE)?1:0;
    }
    public boolean validBST(TreeNode A,int min,int max) {
        if(A==null){
            return true;
        }
       if(min>A.val || max<A.val){
           return false;
       }
       else{
           boolean f1=validBST(A.left,min,A.val-1);
           boolean f2=validBST(A.right,A.val+1,max);
           return f1&&f2;
       }
    }

    public static void main(String[] args) {
        ValidBinarySearchTree I = new ValidBinarySearchTree();

        TreeNode A=new TreeNode(3);
        TreeNode A1=new TreeNode(2);
        TreeNode A2=new TreeNode(4);
        A.left=A1;A.right=A2;
        TreeNode A3=new TreeNode(1);
        TreeNode A4=new TreeNode(3);
        A1.left=A3;
        A1.right=A4;


        System.out.println(I.isValidBST(A));
    }
}




