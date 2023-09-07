package Advance_Trees_5_Problems_On_Trees;

//
//Q=Problem Description
//        Given a binary tree and a sum, determine if the tree has a root-to-leaf path
//        such that adding up all the values along the path equals the given sum.
//
//
//
//        Problem Constraints
//        1 <= number of nodes <= 10^5
//
//        -100000 <= B, value of nodes <= 100000
//
//
//
//        Input Format
//        First argument is a root node of the binary tree, A.
//
//        Second argument is an integer B denoting the sum.
//
//
//
//        Output Format
//        Return 1, if there exist root-to-leaf path such that adding up all
//        the values along the path equals the given sum. Else, return 0.
//
//
//
//        Example Input

//        Input 1:
//
//        Tree:
//        5
//       / \
//      4   8
//     /   / \
//    11  13  4
//   /  \      \
//  7    2      1
//
//        B = 22
//
//        Input 2:
//
//        Tree:
//        5
//       / \
//      4   8
//     /   / \
//   -11 -13  4
//
//        B = -1
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
//        There exist a root-to-leaf path 5 -> 4 -> 11 -> 2 which has sum 22. So, return 1.
//
//        Explanation 2:
//
//        There is no path which has sum -1.

public class PathSum {
    public int hasPathSum(TreeNode A, int B) {
        if(A==null){
            return 0;
        }
        if(A.left==null && A.right==null){
            if(B==A.val){
                return 1;
            }
        }
        int l=hasPathSum(A.left,(B-A.val));
        if(l==1){
            return 1;
        }
        int r=hasPathSum(A.right,(B-A.val));
        if(r==1){
            return 1;
        }
        return 0;
    }
    public static void main(String[] args) {
        PathSum I = new PathSum();
        TreeNode A=new TreeNode(5);
        TreeNode A2=new TreeNode(4);
        TreeNode A3=new TreeNode(8);
        A.left=A2;
        A.right=A3;
        TreeNode A4=new TreeNode(11);
        A2.left=A4;

        TreeNode A6=new TreeNode(13);
        TreeNode A7=new TreeNode(4);
        A3.left=A6;
        A3.right=A7;

        TreeNode A8=new TreeNode(7);
        TreeNode A9=new TreeNode(2);
        A4.left=A8;
        A4.right=A9;
        TreeNode A10=new TreeNode(1);
        A7.right=A10;


        System.out.println( I.hasPathSum(A,22));
    }
}



