package Advance_Trees_3_BST;


//Q=Problem Description
//
//        Given preorder traversal of a binary tree, check if it is possible that it
//        is also a preorder traversal of a Binary Search Tree (BST),
//        where each internal node (non-leaf nodes) have exactly one child.
//
//
//
//        Problem Constraints
//        1 <= number of nodes <= 100000
//
//
//
//        Input Format
//
//        First and only argument is an integer array denoting the preorder traversal of binary tree.
//
//        Output Format
//
//        Return a string "YES" if true else "NO".
//
//
//
//        Example Input
//
//        Input 1:
//
//        A : [4, 10, 5, 8]

//        Input 2:
//
//        A : [1, 5, 6, 4]
//
//
//        Example Output
//
//        Output 1:
//        "YES"

//        Output 2:
//        "NO"
//
//
//        Example Explanation
//
//        Explanation 1:
//
//        The possible BST is:
//        4
//         \
//          10
//          /
//         5
//          \
//           8
//        Explanation 2:
//
//        There is no possible BST which have the above preorder traversal.

//        1
//         \
//          5
//           \
//            6
//           /
//          4



public class CheckForBSTWithOneChild {
    public String solve(int[] A) {
        int prev_l=-1000000000;
        int prev_r= 1000000000;
        for(int i=1;i<A.length;i++){
            if(A[i]>A[i-1]){
                int l=A[i-1]+1;
                int r=prev_r;
                if(A[i]<l || A[i]>r){
                    return "NO";
                }
                prev_l=l;
            }
            else{
                int l=prev_l;
                int r=A[i-1]-1;
                if(A[i]<l || A[i]>r){
                    return "NO";
                }
                prev_r=r;
            }
        }
        return "YES";
    }
    public static void main(String[] args) {
        CheckForBSTWithOneChild I = new CheckForBSTWithOneChild();
        int[]A=new int[4];
        A[0]=4;A[1]=10;A[2]=5;A[3]=8;
        System.out.println(I.solve(A));
    }
}





