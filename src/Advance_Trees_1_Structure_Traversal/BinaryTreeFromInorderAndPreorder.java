package Advance_Trees_1_Structure_Traversal;

import java.util.ArrayList;
import java.util.HashMap;

//Q=Problem Description
//        Given preorder and inorder traversal of a tree, construct the binary tree.
//
//        NOTE: You may assume that duplicates do not exist in the tree.
//
//
//
//        Problem Constraints
//        1 <= number of nodes <= 10^5

public class BinaryTreeFromInorderAndPreorder {
    TreeNode node(ArrayList<Integer> Preorder,ArrayList<Integer> Inorder,int start,
                  int end, int start_pre,HashMap<Integer,Integer>map){

        if(start>end){
            return null;
        }
        TreeNode n1=new TreeNode(Preorder.get(start_pre));
        int i=map.get(Preorder.get(start_pre));
        int left_length=i-start;
        n1.left=node(Preorder,Inorder,start,i-1,start_pre+1,map);
        n1.right=node(Preorder,Inorder,i+1,end,start_pre+1+left_length,map);
        return n1;
    }
    public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
        TreeNode root;
        HashMap<Integer,Integer>map =new HashMap<>();
        for(int i=0;i<B.size();i++){
            map.put(B.get(i),i);
        }
        root= node(A,B,0,B.size()-1,0,map);
        return root;
    }

    public static void main(String[] args) {
        BinaryTreeFromInorderAndPreorder I = new BinaryTreeFromInorderAndPreorder();
        ArrayList<Integer>A=new ArrayList<>();
        ArrayList<Integer>B=new ArrayList<>();

        B.add(5);B.add(6);B.add( 1);B.add( 2);B.add(3);B.add( 4);

        A.add(2);A.add( 1);A.add( 6);A.add( 5);A.add( 3);A.add( 4);

        System.out.println( I.buildTree(A,B));
    }
}


