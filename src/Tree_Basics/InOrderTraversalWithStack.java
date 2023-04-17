package Tree_Basics;

import java.util.ArrayList;
import java.util.Stack;

public class InOrderTraversalWithStack {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
            left=null;
            right=null;
        }
    }
    public ArrayList<Integer> inorderTraversal(TreeNode A) {
        ArrayList<Integer> ans=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<TreeNode>();
        while(A!=null || !stack.isEmpty()){
            while(A!=null){
                stack.push(A);
                A=A.left;
            }
            A=stack.pop();
            ans.add(A.val);
            A=A.right;
        }
        return ans;
    }
    public static void main(String[] args) {
        InOrderTraversalWithStack I = new InOrderTraversalWithStack();
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




