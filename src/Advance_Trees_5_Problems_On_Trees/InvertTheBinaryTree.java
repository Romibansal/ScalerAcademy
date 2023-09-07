package Advance_Trees_5_Problems_On_Trees;

//
//Q=Problem Description
//        Given a binary tree A, invert the binary tree and return it.
//
//        Inverting refers to making the left child the right child and vice versa.
//
//
//
//        Problem Constraints
//        1 <= size of tree <= 100000
//
//
//
//        Input Format
//        First and only argument is the head of the tree A.
//
//
//
//        Output Format
//        Return the head of the inverted tree.
//
//
//
//        Example Input
//        Input 1:
//
//
//        1
//       /   \
//      2     3
//
//        Input 2:
//
//
//        1
//      /   \
//     2     3
//    / \   / \
//   4   5 6   7
//
//
//        Example Output
//
//        Output 1:
//
//
//        1
//       /   \
//      3     2
//
//        Output 2:
//
//
//        1
//       /   \
//      3     2
//     / \   / \
//    7   6 5   4
//
//
//        Example Explanation
//
//        Explanation 1:
//
//        Tree has been inverted.
//
//        Explanation 2:
//
//        Tree has been inverted.


class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) {
       val = x;
       left=null;
       right=null;
      }
  }

public class InvertTheBinaryTree {
    public TreeNode invertTree(TreeNode A) {
        if(A==null){
            return null;
        }
        TreeNode temp=A.left;
        A.left=invertTree(A.right);
        A.right=invertTree(temp);
        return A;
    }
    public static void main(String[] args) {
        InvertTheBinaryTree I = new InvertTheBinaryTree();
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
        TreeNode A8=new TreeNode(8);
        A3.right=A6;
        A6.left=A7;
        A6.right=A8;

        System.out.println( I.invertTree(A));
    }
}


