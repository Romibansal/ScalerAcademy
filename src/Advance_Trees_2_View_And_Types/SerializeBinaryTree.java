package Advance_Trees_2_View_And_Types;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//
//Q=Problem Description
//        Given the root node of a Binary Tree denoted by A. You have to Serialize the given Binary
//        Tree in the described format.
//
//        Serialize means encode it into a integer array denoting the Level Order Traversal of
//        the given Binary Tree.
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
//Example Input
//        Input 1:
//
//                  1
//                /   \
//               2     3
//              / \
//             4   5
//
//           Input 2:
//
//                 1
//               /   \
//              2     3
//             / \     \
//            4   5     6
//
//
//        Example Output
//        Output 1:
//
//        [1, 2, 3, 4, 5, -1, -1, -1, -1, -1, -1]
//        Output 2:
//
//        [1, 2, 3, 4, 5, -1, 6, -1, -1, -1, -1, -1, -1]


public class SerializeBinaryTree {
    public ArrayList<Integer> solve(TreeNode A) {
        Queue<TreeNode> q=new LinkedList<>();
        ArrayList<Integer>ans=new ArrayList<>();
        if(A==null){
            return ans;
        }
        q.add(A);

        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode node=q.peek();
                q.remove();
                ans.add(node.val);
                if(node.left!=null){
                    q.add(node.left);
                }
                else if(node.val!=-1 && node.left==null ){
                    q.add(new TreeNode(-1));
                }
                if(node.right!=null){
                    q.add(node.right);
                }
                else if(node.val!=-1 && node.right==null ){
                    q.add(new TreeNode(-1));
                }

            }
        }
        return ans;
    }
    public static void main(String[] args) {
        SerializeBinaryTree I = new SerializeBinaryTree();
        TreeNode A = new TreeNode(1);
        TreeNode A2 = new TreeNode(2);
        TreeNode A3 = new TreeNode(3);
        TreeNode A4 = new TreeNode(4);
        TreeNode A5 = new TreeNode(5);
        A.left = A2;
        A.right = A3;
        A2.left=A4;
        A2.right=A5;


        System.out.println(I.solve(A));
    }
}

