package Advance_Trees_1_Structure_Traversal;

import groovyjarjarantlr4.runtime.tree.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;

//Q=Problem Description
//        Given the inorder and postorder traversal of a tree, construct the binary tree.
//
//        NOTE: You may assume that duplicates do not exist in the tree.
//
//
//
//        Problem Constraints
//        1 <= number of nodes <= 10^5

public class BinaryTreeFromInorderAndPostorder {
    TreeNode node(ArrayList<Integer> Inorder,ArrayList<Integer> Postorder,int start,
                  int end,int pos_end,HashMap<Integer,Integer> map){
        if(start>end){
            return null ;
        }

        TreeNode n1=new TreeNode(Postorder.get(pos_end));
        int i=map.get(Postorder.get(pos_end));
        n1.left=node(Inorder,Postorder,start,i-1,pos_end - (end - i + 1),map);
        n1.right=node(Inorder,Postorder,i+1,end,pos_end-1,map);
        return n1;
    }
    public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
        HashMap<Integer,Integer>map =new HashMap<>();
        for(int i=0;i< A.size();i++){
            map.put(A.get(i),i);
        }
       TreeNode root;
       root=node(A,B,0,A.size()-1,B.size()-1,map);
       return root;
    }

    public static void main(String[] args) {
        BinaryTreeFromInorderAndPostorder I = new BinaryTreeFromInorderAndPostorder();
        ArrayList<Integer>A=new ArrayList<>();
        ArrayList<Integer>B=new ArrayList<>();

        A.add(6);A.add( 1);A.add(3);A.add( 2);

        B.add(6);B.add( 3);B.add( 2);B.add( 1);

        System.out.println( I.buildTree(A,B));
    }
}




