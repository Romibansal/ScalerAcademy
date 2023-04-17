package Tree_Basics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class PostOrderTraversalWithStack {
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
    public ArrayList<Integer> postorderTraversal(TreeNode A) {
        ArrayList<Integer> ans=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<TreeNode>();
        while(A!=null || !stack.isEmpty()){
            while(A!=null){
                ans.add(A.val);
                stack.push(A);
                A=A.right;
            }
            A=stack.pop();
            A=A.left;
        }
        Collections.reverse(ans);
        return ans;
    }
    public static void main(String[] args) {
        PostOrderTraversalWithStack I = new PostOrderTraversalWithStack();
        TreeNode A=new TreeNode(1);
        TreeNode A1=new TreeNode(6);
        TreeNode A2=new TreeNode(2);
        TreeNode A3=new TreeNode(3);
        A.left=A1;
        A.right=A2;
        A2.left=A3;
        System.out.println( I.postorderTraversal(A));
    }
}




