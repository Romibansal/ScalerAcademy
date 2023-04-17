package Tree_Basics;

import java.util.ArrayList;
import java.util.Stack;


public class PreOrderTraversalWithStack {
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
    public ArrayList<Integer> preorderTraversal(TreeNode A) {
        ArrayList <Integer>B=new ArrayList<>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(A!=null || !stack.isEmpty() ){
            while(A!=null){
                B.add(A.val);
                stack.push(A);
                A=A.left;
            }
            A=stack.pop();
            A=A.right;
        }
        return B;
    }
    public static void main(String[] args) {
        PreOrderTraversalWithStack I = new PreOrderTraversalWithStack();
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




