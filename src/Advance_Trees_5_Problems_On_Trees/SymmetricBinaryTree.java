package Advance_Trees_5_Problems_On_Trees;

//Q=Problem Description
//        Given a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
//
//
//
//        Problem Constraints
//        1 <= number of nodes <= 10^5
//
//
//
//        Input Format
//        First and only argument is the root node of the binary tree.
//
//
//
//        Output Format
//        Return 0 / 1 ( 0 for false, 1 for true ).
//
//
//
//        Example Input
//        Input 1:
//
//        1
//       / \
//      2   2
//     / \ / \
//    3  4 4  3
//
//        Input 2:
//
//        1
//       / \
//      2   2
//       \   \
//        3    3
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
//        The above binary tree is symmetric.
//
//        Explanation 2:
//
//        The above binary tree is not symmetric.


public class SymmetricBinaryTree {
    TreeNode Clone_Tree(TreeNode A){
        if(A==null){
            return null;
        }
        TreeNode root=new TreeNode(A.val);
        root.left = Clone_Tree(A.left);
        root.right = Clone_Tree(A.right);
        return root;
    }
    TreeNode Invert(TreeNode root){
        if(root==null){
            return null;
        }
        TreeNode temp=root.left;
        root.left=Invert(root.right);
        root.right=Invert(temp);
        return  root;
    }
    int Is_same(TreeNode A,TreeNode B){
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
        int l=Is_same(A.left,B.left);
        int r=Is_same(A.right,B.right);
        if(l==0 || r==0){
            return 0;
        }
        return 1;
    }

    public int isSymmetric(TreeNode A) {
        TreeNode clone=Clone_Tree(A);
        TreeNode invert=Invert(clone);
        return Is_same(A,invert);

    }
    public static void main(String[] args) {
        SymmetricBinaryTree I = new SymmetricBinaryTree();
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
        A3.right=A7;

        System.out.println( I.isSymmetric(A));
    }
}



