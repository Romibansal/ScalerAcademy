package Advance_Trees_2_View_And_Types;


//Q=Problem Description
//        Given a Binary Tree A consisting of N integer nodes, you need to find the diameter of the tree.
//
//        The diameter of a tree is the number of edges on the longest path between two nodes in the tree.
//
//
//
//        Problem Constraints
//        0 <= N <= 10^5
//
//
//
//        Input Format
//        First and only Argument represents the root of binary tree A.
//
//
//
//        Output Format
//        Return an single integer denoting the diameter of the tree.
//
//
//
//        Example Input
//
//        Input 1:
//
//        1
//      /   \
//     2     3
//    / \
//   4   5
//
//      Input 2:
//
//        1
//      /   \
//     2     3
//    / \     \
//   4   5     6
//
//
//        Example Output

//        Output 1:
//
//        3

//        Output 2:
//
//        4
//
//
//        Example Explanation

//        Explanation 1:
//
//        Longest Path in the tree is 4 -> 2 -> 1 -> 3 and the number of edges
//        in this path is 3 so diameter is 3.


public class DiameterOfBinaryTree {
    int height(TreeNode node){
        if(node==null){
            return -1;
        }
        int left=height(node.left);
        int right=height(node.right);
        return (Math.max(left,right)+1);
    }
    public int solve(TreeNode A) {
        if(A==null){
            return 0;
        }
        int l=height(A.left);
        int r=height(A.right);
        int left_subtree=solve(A.left);
        int right_subtree=solve(A.right);
        return Math.max(l+r+2,Math.max(left_subtree,right_subtree));
    }
    public static void main(String[] args) {
        RightViewOfBinaryTree I = new RightViewOfBinaryTree();
        TreeNode A=new TreeNode(1);
        TreeNode A2=new TreeNode(2);
        TreeNode A3=new TreeNode(3);
        TreeNode A4=new TreeNode(4);
        TreeNode A5=new TreeNode(5);
        TreeNode A6=new TreeNode(6);
        TreeNode A7=new TreeNode(7);
        TreeNode A8=new TreeNode(8);
        A.left=A2;
        A.right=A3;
        A2.left=A4;
        A2.right=A5;
        A3.left=A6;
        A3.right=A7;
        A4.left=A8;

        System.out.println( I.solve(A));
    }
}

