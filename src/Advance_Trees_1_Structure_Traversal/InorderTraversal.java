package Advance_Trees_1_Structure_Traversal;

//Q=Problem Description
//        Given a binary tree, return the inorder traversal of its nodes' values.
//
//
//
//        Problem Constraints
//        1 <= number of nodes <= 10^5




import java.util.ArrayList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}
public class InorderTraversal {
    ArrayList<Integer> ans=new ArrayList<>();
    public ArrayList<Integer> inorderTraversal(TreeNode A) {
        if(A==null){
            return ans;
        }
        inorderTraversal(A.left);
        ans.add(A.val);
        inorderTraversal(A.right);
        return ans;
    }
    public static void main(String[] args) {
        InorderTraversal I = new InorderTraversal();
        TreeNode A=new TreeNode(1);
        TreeNode A1=new TreeNode(6);
        TreeNode A2=new TreeNode(2);
        TreeNode A3=new TreeNode(3);

        A.left=A1;
        A.right=A2;
        A2.left=A3;

        System.out.println( I.inorderTraversal(A));
    }
}



