package Advance_Trees_3_BST;

//Q=Problem Description
//        Given a binary search tree of integers. You are given a range B and C.
//
//        Return the count of the number of nodes that lie in the given range.
//
//
//
//        Problem Constraints
//        1 <= Number of nodes in binary tree <= 100000
//
//        0 <= B < = C <= 10^9
//
//
//
//        Input Format
//        First argument is a root node of the binary tree, A.
//
//        Second argument is an integer B.
//
//        Third argument is an integer C.
//
//
//
//        Output Format
//        Return the count of the number of nodes that lies in the given range.
//
//
//
//        Example Input
//        Input 1:
//
//         15
//       /    \
//     12      20
//     / \    /  \
//    10  14  16  27
//   /
//  8
//
//        B = 12
//        C = 20

//        Input 2:
//
//         8
//        / \
//       6  21
//       / \
//      1   7
//
//        B = 2
//        C = 20
//
//
//        Example Output
//        Output 1:
//
//        5
//        Output 2:
//
//        3


public class BSTNodesInARange {
    int ans=0;
    int count_nodes(TreeNode A,int B,int C){
        if(A==null){
            return 0;
        }
        count_nodes(A.left,B,C);
        count_nodes(A.right,B,C);
        if(A.val>=B && A.val<=C){
            ans++;
        }
        return ans;
    }
    public int solve(TreeNode A, int B, int C) {
        return (count_nodes(A,B,C));
    }
    public static void main(String[] args) {
        BSTNodesInARange I = new BSTNodesInARange();
        TreeNode A=new TreeNode(15);
        TreeNode A1=new TreeNode(12);
        TreeNode A2=new TreeNode(20);
        A.left=A1;
        A.right=A2;
        TreeNode A3=new TreeNode(10);
        TreeNode A4=new TreeNode(14);
        A1.left=A3;
        A1.right=A4;
        TreeNode A5=new TreeNode(16);
        TreeNode A6=new TreeNode(27);
        A2.left=A5;
        A2.right=A6;
        TreeNode A7=new TreeNode(8);
        A3.left=A7;
        System.out.println(I.solve(A,12,20));
    }
}




