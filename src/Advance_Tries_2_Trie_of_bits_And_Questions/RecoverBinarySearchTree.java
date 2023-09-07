package Advance_Tries_2_Trie_of_bits_And_Questions;

import java.util.ArrayList;

public class RecoverBinarySearchTree {
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
   TreeNode prev=null;
   TreeNode first=null;
   TreeNode second=null;
  void find(TreeNode curr){
       if(curr==null){
           return;
       }
       find(curr.left);
       if(prev!=null && prev.val> curr.val){
           if(first==null){
               first=prev;
               second=curr;
           }
           else{
               second=curr;
           }
       }
       prev=curr;
       find(curr.right);

  }
    public ArrayList<Integer> recoverTree(TreeNode A) {
      find(A);
      ArrayList<Integer> ans=new ArrayList<>();

      ans.add(second.val);
        ans.add(first.val );
      return ans;
    }

    public static void main(String[] args) {
        RecoverBinarySearchTree I = new RecoverBinarySearchTree();
        TreeNode A=new TreeNode(15);
        TreeNode a1=new TreeNode(10);
        TreeNode a2=new TreeNode(13);
        A.left=a1;
        A.right=a2;

        TreeNode a3=new TreeNode(5);
        TreeNode a4=new TreeNode(24);
        a1.left=a3;
        a1.right=a4;

        TreeNode a5=new TreeNode(18);
        TreeNode a6=new TreeNode(35);
        a2.left=a5;
        a2.right=a6;

        TreeNode a7=new TreeNode(3);
        TreeNode a8=new TreeNode(8);
        a3.left=a7;
        a3.right=a8;

        TreeNode a9=new TreeNode(16);
        TreeNode a10=new TreeNode(20);
        a5.left=a9;
        a5.right=a10;

        TreeNode a11=new TreeNode(11);
        TreeNode a12=new TreeNode(22);
        a4.left=a11;
        a10.right=a12;

        System.out.println(I.recoverTree(A));
    }
}


