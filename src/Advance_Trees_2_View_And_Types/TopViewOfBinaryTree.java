package Advance_Trees_2_View_And_Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;


//Q=Problem Description
//        Given a binary tree of integers denoted by root A. Return an array of integers representing the top view of the Binary tree.
//
//        The top view of a Binary Tree is a set of nodes visible when the tree is visited from the top.
//
//        Return the nodes in any order.
//
//
//
//        Problem Constraints
//        1 <= Number of nodes in binary tree <= 100000
//
//        0 <= node values <= 10^9
//


//Example Input
//        Input 1:
//
//
//         1
//       /   \
//      2    3
//     / \  / \
//    4   5 6  7
//   /
//  8
//        Input 2:
//
//
//        1
//       /  \
//      2    3
//       \
//        4
//         \
//          5
//
//
//        Example Output

//        Output 1:
//
//        [1, 2, 4, 8, 3, 7]
//        Output 2:
//
//        [1, 2, 3]

public class TopViewOfBinaryTree {
    public ArrayList<Integer> solve(TreeNode A) {
        int max=0;
        int min= 0;
        Queue<Pair> q=new LinkedList<>();
        HashMap<Integer,ArrayList<Integer>>map=new HashMap<>();
        Pair p=new Pair(A,0);
        q.add(p);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                Pair remove = q.remove();
                TreeNode node = remove.node;
                int level = remove.vtlevel;
                max=Math.max(max,level);
                min=Math.min(min,level);
                if(map.containsKey(level)){
                    ArrayList a=map.get(level);
                    a.add(node.val);
                    map.put(level,a);
                }
                else{
                    ArrayList<Integer> n=new ArrayList<>();
                    n.add(node.val);
                    map.put(level,n);
                }
                if(node.left!=null){
                    Pair p1=new Pair(node.left,level-1);
                    q.add(p1);
                }
                if(node.right!=null){
                    Pair p1=new Pair(node.right,level+1);
                    q.add(p1);
                }
            }
        }
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=min;i<=max;i++){
            ans.add(map.get(i).get(0));
        }
        return ans;
    }
    public static void main(String[] args) {
        TopViewOfBinaryTree I = new TopViewOfBinaryTree();
        TreeNode A = new TreeNode(6);
        TreeNode A2 = new TreeNode(9);
        TreeNode A3 = new TreeNode(4);
        TreeNode A4 = new TreeNode(8);
        TreeNode A5 = new TreeNode(3);
        A.left = A2;
        A.right = A3;
        A3.left = A4;

        A4.right = A5;

        System.out.println(I.solve(A));
    }
}

