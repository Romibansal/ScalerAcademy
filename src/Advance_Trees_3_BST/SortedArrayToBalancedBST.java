package Advance_Trees_3_BST;
//
//
//Q=Problem Description
//        Given an array where elements are sorted in ascending order,
//        convert it to a height Balanced Binary Search Tree (BBST).
//
//        Balanced tree : a height-balanced binary tree is defined as a binary
//        tree in which the depth of the two subtrees of every node never differ by more than 1.
//
//
//
//        Problem Constraints
//        1 <= length of array <= 100000
//
//
//
//        Input Format
//        First argument is an integer array A.
//
//
//
//        Output Format
//        Return a root node of the Binary Search Tree.
//
//
//
//        Example Input
//        Input 1:
//
//        A : [1, 2, 3]
//        Input 2:
//
//        A : [1, 2, 3, 5, 10]
//
//
//
//        Example Output
//
//        Output 1:
//
//        2
//       /   \
//      1     3
//
//        Output 2:
//
//        3
//       /   \
//      2     5
//     /       \
//    1         10


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

public class SortedArrayToBalancedBST {

    TreeNode tree(int[] A,int start,int end){
        if(start>end){
            return null;
        }
        int mid=(start+end)/2;
        TreeNode node=new TreeNode(A[mid]);
        node.left=tree(A,start,mid-1);
        node.right=tree(A,mid+1,end);
        return node;
    }
    public TreeNode sortedArrayToBST(final int[] A) {
        return (tree( A,0,A.length-1));
    }

    public static void main(String[] args) {
        SortedArrayToBalancedBST I = new SortedArrayToBalancedBST();
        int[]A=new int[5];
        A[0]=1;A[1]=2;A[2]=3;A[3]=5;A[4]=10;
        System.out.println(I.sortedArrayToBST(A));
    }
}



