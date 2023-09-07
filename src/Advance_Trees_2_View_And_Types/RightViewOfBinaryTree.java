package Advance_Trees_2_View_And_Types;

//Q=Problem Description
//        Given a binary tree of integers denoted by root A. Return an array of integers representing the right view of the Binary tree.
//
//        Right view of a Binary Tree is a set of nodes visible when the tree is visited from Right side.
//
//
//
//        Problem Constraints
//        1 <= Number of nodes in binary tree <= 100000
//
//        0 <= node values <= 10^9



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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

public class RightViewOfBinaryTree {
    public ArrayList<Integer> solve(TreeNode A) {
        ArrayList<Integer>ans=new ArrayList<>();
        if(A==null){
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(A);

        while(!queue.isEmpty()){
            int size=queue.size();
            int data=-1;
            for(int i=0;i<size;i++){
                TreeNode curr_node=queue.peek();
                queue.remove();
                data=curr_node.val;
                if(curr_node.left!=null){
                    queue.add(curr_node.left);
                }
                if(curr_node.right!=null){
                    queue.add(curr_node.right);
                }
            }
            ans.add(data);
        }
        return ans;
    }
    public static void main(String[] args) {
        RightViewOfBinaryTree I = new RightViewOfBinaryTree();
        TreeNode A=new TreeNode(1);
        TreeNode A2=new TreeNode(2);
        TreeNode A3=new TreeNode(3);
        TreeNode A4=new TreeNode(4);
        TreeNode A5=new TreeNode(5);
        TreeNode A6=new TreeNode(6);
        TreeNode A7=new TreeNode(7);
        TreeNode A8=new TreeNode(8);
        A.left=A2;
        A.right=A3;
        A2.left=A4;
        A2.right=A5;
        A3.left=A6;
        A3.right=A7;
        A4.left=A8;

        System.out.println( I.solve(A));
    }
}




