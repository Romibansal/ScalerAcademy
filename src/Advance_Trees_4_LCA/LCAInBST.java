package Advance_Trees_4_LCA;

//Q=Problem Description
//        Given a Binary Search Tree A. Also given are two nodes B and C. Find the lowest
//        common ancestor of the two nodes.
//
//        Note 1 :- It is guaranteed that the nodes B and C exist.
//
//        Note 2 :- The LCA of B and C in A is the shared ancestor of B and C that is located farthest from the root.
//
//
//
//        Problem Constraints
//        1 <= Number of nodes in binary tree <= 10^5
//
//        1 <= B , C <= 10^5
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
//        Return the LCA of the two nodes
//
//
//
//        Example Input
//        Input 1:
//
//        15
//       /    \
//      12      20
//      / \    /  \
//     10  14  16  27
//     /
//    8
//
//        B = 8
//        C = 20
//
//        Input 2:
//
//         8
//        / \
//       6  21
//      / \
//     1   7
//
//        B = 7
//        C = 1
//
//
//        Example Output
//
//         Output 1:
//
//         15
//
//         Output 2:
//
//        6



public class LCAInBST {
    public int solve(TreeNode A, int B, int C) {
        TreeNode curr=A;
        while(curr!=null){
            if(curr.val>B && curr.val>C){
                curr=curr.left;
            }
            else if(curr.val<B && curr.val<C){
                curr=curr.right;
            }
            else{
                return curr.val;
            }
        }
        return curr.val;
    }
    public static void main(String[] args) {
        LCAInBST I = new LCAInBST();
        TreeNode A=new TreeNode(8);
        TreeNode A1=new TreeNode(6);
        TreeNode A2=new TreeNode(21);
        TreeNode A3=new TreeNode(1);
        TreeNode A4=new TreeNode(7);

        A.left=A1;
        A.right=A2;
        A1.left=A3;
        A1.right=A4;
        System.out.println(I.solve(A,7,1));
    }
}


