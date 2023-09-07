package Advance_Trees_1_Structure_Traversal;

import java.util.ArrayList;


//Q=Problem Description
//        Given a binary tree, return the preorder traversal of its nodes values.
//
//
//
//        Problem Constraints
//        1 <= number of nodes <= 10^5
//

public class PreorderTraversal {
    ArrayList<Integer> ans=new ArrayList<>();
    public ArrayList<Integer> preorderTraversal(TreeNode A) {
        if(A==null){
            return ans;
        }
        ans.add(A.val);
        preorderTraversal(A.left);

        preorderTraversal(A.right);
        return ans;
    }
    public static void main(String[] args) {
        PreorderTraversal I = new PreorderTraversal();
        TreeNode A=new TreeNode(1);
        TreeNode A1=new TreeNode(6);
        TreeNode A2=new TreeNode(2);
        TreeNode A3=new TreeNode(3);

        A.left=A1;
        A.right=A2;
        A2.left=A3;

        System.out.println( I.preorderTraversal(A));
    }
}




