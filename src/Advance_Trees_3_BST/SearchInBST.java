package Advance_Trees_3_BST;

//Q=Problem Description
//        Given a Binary Search Tree A. Check whether there exists a node with value B in the BST.
//
//
//        Problem Constraints
//        1 <= Number of nodes in binary tree <= 105
//
//        0 <= B <= 10^6
//
//
//
//        Input Format
//        First argument is a root node of the binary tree, A.
//
//        Second argument is an integer B.
//
//
//
//        Output Format
//        Return 1 if such a node exist and 0 otherwise
//
//
//
//        Example Input
//        Input 1:
//
//         15
//       /    \
//      12      20
//     / \    /  \
//    10  14  16  27
//   /
//  8
//
//        B = 16
//
//        Input 2:
//
//        8
//       / \
//      6  21
//     / \
//    1   7
//
//        B = 9
//
//
//        Example Output
//        Output 1:
//
//        1
//        Output 2:
//
//        0


public class SearchInBST {
    public int solve(TreeNode A, int B) {
        TreeNode temp=A;
        while(temp!=null){
            if(temp.val==B){
                return 1;
            }
            else if(temp.val<B){
                temp=temp.right;
            }
            else{
                temp=temp.left;

            }
        }
        return 0;
    }
    public static void main(String[] args) {
        SearchInBST I = new SearchInBST();
       TreeNode A=new TreeNode(15);
        TreeNode A1=new TreeNode(12);TreeNode A2=new TreeNode(20);
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
        System.out.println(I.solve(A,16));
    }
}




