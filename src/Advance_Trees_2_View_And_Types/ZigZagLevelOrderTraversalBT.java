package Advance_Trees_2_View_And_Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

//
//Q=Problem Description
//        Given a binary tree, return the zigzag level order traversal of its nodes values.
//        (ie, from left to right, then right to left for the next level and alternate between).
//
//
//        Problem Constraints
//        1 <= number of nodes <= 10^5

//
//Example Input
//        Input 1:
//
//        3
//       / \
//      9  20
//        /  \
//       15   7
//        Input 2:
//
//         1
//        / \
//       6   2
//      /
//     3
//
//
//        Example Output
//        Output 1:
//
//        [
//        [3],
//        [20, 9],
//        [15, 7]
//        ]
//        Output 2:
//
//        [
//        [1]
//        [2, 6]
//        [3]
//        ]


public class ZigZagLevelOrderTraversalBT {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
        Queue<TreeNode>q=new LinkedList<>();
        q.add(A);
        int level=0;
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        while(!q.isEmpty()){
            int size=q.size();
            ArrayList<Integer>temp=new ArrayList<>();
            level++;
            for(int i=0;i<size;i++){
                TreeNode node=q.peek();
                q.remove();
                temp.add(node.val);
                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
            }
            if(level%2==0){
                Collections.reverse(temp);
                ans.add(temp);
            }
            else{
                ans.add(temp);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ZigZagLevelOrderTraversalBT I = new ZigZagLevelOrderTraversalBT();
        TreeNode A = new TreeNode(1);
        TreeNode A2 = new TreeNode(2);
        TreeNode A3 = new TreeNode(3);
        TreeNode A4 = new TreeNode(4);
        TreeNode A5 = new TreeNode(5);
        A.left = A2;
        A.right = A3;
        A2.left=A4;
        A2.right=A5;


        System.out.println(I.zigzagLevelOrder(A));
    }
}


