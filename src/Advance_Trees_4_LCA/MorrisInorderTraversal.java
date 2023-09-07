package Advance_Trees_4_LCA;


import java.util.ArrayList;


//Q=Problem Description
//        Given a binary tree, return the inorder traversal of its nodes' values.
//
//        NOTE: Using recursion and stack are not allowed.
//
//
//
//        Problem Constraints
//        1 <= number of nodes <= 10^5
//
//
//
//        Input Format
//        First and only argument is root node of the binary tree, A.
//
//
//
//        Output Format
//        Return an integer array denoting the inorder traversal of the given binary tree.
//
//
//
//        Example Input
//        Input 1:
//
//        1
//         \
//         2
//        /
//       3
//        Input 2:
//
//        1
//       / \
//      6   2
//     /
//    3
//
//
//        Example Output

//        Output 1:
//
//        [1, 3, 2]

//        Output 2:
//
//        [6, 1, 3, 2]
//



class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) {
       val = x;
       left=null;
       right=null;
      }
  }

public class MorrisInorderTraversal {
    TreeNode find_rightmost_node_in_lst(TreeNode curr){
        TreeNode temp=curr.left;
        while(temp.right!=null && temp.right!=curr){
            temp=temp.right;
        }
        return temp;
    }
    public ArrayList<Integer> solve(TreeNode A) {
        ArrayList<Integer> ans=new ArrayList<>();
        TreeNode curr=A;
        while(curr!=null){
            if(curr.left==null){
                ans.add(curr.val);
                curr=curr.right;
            }
            else{
                TreeNode r=find_rightmost_node_in_lst(curr);
                if(r.right==null){
                    r.right=curr;
                    curr=curr.left;
                }
                else{
                    r.right=null;
                    ans.add(curr.val);
                    curr=curr.right;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        MorrisInorderTraversal I = new MorrisInorderTraversal();
        TreeNode A=new TreeNode(1);
        TreeNode A1=new TreeNode(6);
        TreeNode A2=new TreeNode(2);
        TreeNode A3=new TreeNode(3);

        A.left=A1;
        A.right=A2;
        A2.left=A3;
        System.out.println(I.solve(A));
    }
}

