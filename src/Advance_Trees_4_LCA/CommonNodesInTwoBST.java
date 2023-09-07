package Advance_Trees_4_LCA;

import java.util.HashSet;


//Q=Problem Description
//        Given two BST's A and B, return the (sum of all common nodes in both A and B) % (10^9 +7) .
//
//        In case there is no common node, return 0.
//
//        NOTE:
//
//        Try to do it one pass through the trees.
//
//
//
//        Problem Constraints
//        1 <= Number of nodes in the tree A and B <= 10^5
//
//        1 <= Node values <= 10^6
//
//
//
//        Input Format
//        First argument represents the root of BST A.
//
//        Second argument represents the root of BST B.
//
//
//
//        Output Format
//        Return an integer denoting the (sum of all common nodes in both BST's A and B) % (109 +7) .
//
//
//
//        Example Input
//        Input 1:
//
//        Tree A:
//        5
//       / \
//      2   8
//       \    \
//        3    15
//            /
//           9
//
//        Tree B:
//        7
//       / \
//      1   10
//       \    \
//        2    15
//            /
//           11
//
//        Input 2:
//
//        Tree A:
//        7
//       / \
//      1   10
//       \    \
//        2    15
//            /
//          11
//
//        Tree B:
//         7
//       /  \
//      1    10
//       \     \
//        2    15
//            /
//           11
//
//
//        Example Output

//        Output 1:
//
//        17
//
//        Output 2:
//
//        46
//
//
//        Example Explanation
//
//        Explanation 1:
//
//        Common Nodes are : 2, 15
//        So answer is 2 + 15 = 17
//
//        Explanation 2:
//
//        Common Nodes are : 7, 2, 1, 10, 15, 11
//        So answer is 7 + 2 + 1 + 10 + 15 + 11 = 46


public class CommonNodesInTwoBST {
    HashSet<Integer> set=new HashSet<>();
    long sum=0;
    void Traversal(TreeNode root){
        if(root==null){
            return;
        }
        Traversal(root.left);
        Traversal(root.right);
        set.add(root.val);
    }
    void Traversal_sum(TreeNode root,int mod){
        if(root==null){
            return;
        }
        Traversal_sum(root.left,mod);
        Traversal_sum(root.right,mod);
        if(set.contains(root.val)){
            sum=((sum%mod)+root.val)%mod;
        }
    }
    public int solve(TreeNode A, TreeNode B) {
        int mod=(int)Math.pow(10,9)+7;
        Traversal(A);
        Traversal_sum(B,mod);
        long ans=sum%mod;
        return (int)ans;
    }
    public static void main(String[] args) {
        CommonNodesInTwoBST I = new CommonNodesInTwoBST();
        TreeNode A=new TreeNode(5);
        TreeNode A1=new TreeNode(2);
        TreeNode A2=new TreeNode(8);
        A.left=A1;
        A.right=A2;
        TreeNode A3=new TreeNode(3);
        A1.right=A3;
        TreeNode A4=new TreeNode(15);
        A2.right=A4;
        TreeNode A5=new TreeNode(9);
        A4.left=A5;

        TreeNode B=new TreeNode(7);
        TreeNode B1=new TreeNode(1);
        TreeNode B2=new TreeNode(10);
        B.left=B1;
        B.right=B2;
        TreeNode B3=new TreeNode(2);
        TreeNode B4=new TreeNode(15);
        B1.right=B3;B2.right=B4;
        TreeNode B5=new TreeNode(11);
        B4.left=B5;

        System.out.println(I.solve(A,B));
    }
}



