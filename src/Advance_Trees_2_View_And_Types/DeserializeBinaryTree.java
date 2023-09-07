package Advance_Trees_2_View_And_Types;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//
//Q=Problem Description
//        You are given an integer array A denoting the Level Order Traversal of the Binary Tree.
//
//        You have to Deserialize the given Traversal in the Binary Tree and return the root of the Binary Tree.
//
//        NOTE:
//
//        In the array, the NULL/None child is denoted by -1.
//        For more clarification check the Example Input.
//
//
//        Problem Constraints
//        1 <= number of nodes <= 10^5
//
//        -1 <= A[i] <= 10^5

//     Example Input
//        Input 1:
//
//        A = [1, 2, 3, 4, 5, -1, -1, -1, -1, -1, -1]

//        Input 2:
//
//        A = [1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1]
//
//
//        Example Output
//
//     Output 1:
//
//        1
//      /   \
//     2     3
//    / \
//   4   5
//
//     Output 2:
//
//        1
//      /   \
//     2     3
//    / \     \
//   4   5     6

public class DeserializeBinaryTree {
    public TreeNode solve(ArrayList<Integer> A) {
        Queue<TreeNode>q=new LinkedList<>();
        TreeNode root=new TreeNode(A.get(0));
        q.add(root);
        A.remove(0);
        while(!q.isEmpty()){
            TreeNode node=q.peek();
            q.remove();
            if(A.get(0)!=-1) {
                TreeNode l = new TreeNode(A.get(0));
                node.left = l;
                q.add(l);
            }
            A.remove(0);
            if(A.get(0)!=-1) {
                TreeNode r = new TreeNode(A.get(0));
                node.right = r;
                q.add(r);
            }
            A.remove(0);
        }
        return root;
    }
    public static void main(String[] args) {
        DeserializeBinaryTree I = new DeserializeBinaryTree();
        ArrayList<Integer>A=new ArrayList<>();
        A.add(1); A.add(2); A.add(3); A.add(4);
        A.add(5); A.add(-1); A.add(-1);
        A.add(-1); A.add(-1); A.add(-1);
        A.add(6);A.add(-1);
        A.add(-1);


        System.out.println(I.solve(A));
    }
}


