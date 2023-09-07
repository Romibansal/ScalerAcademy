package Advance_Trees_5_Problems_On_Trees;


//Q=Problem Description
//        Given a binary tree A. Check whether it is possible to partition the tree to two
//        trees which have equal sum of values after removing exactly one edge on the original tree.
//
//
//
//        Problem Constraints
//        1 <= size of tree <= 100000
//
//        0 <= value of node <= 10^9
//
//
//
//        Input Format
//        First and only argument is head of tree A.
//
//
//
//        Output Format
//        Return 1 if the tree can be partitioned into two trees of equal sum else return 0.
//
//
//
//        Example Input
//        Input 1:
//
//
//        5
//       /  \
//      3    7
//     / \  / \
//    4  6  5  6
//
//        Input 2:
//
//
//        1
//       / \
//      2   10
//     / \
//    20  2
//
//
//        Example Output
//
//        Output 1:
//
//        1
//
//        Output 2:
//
//        0
//
//
//        Example Explanation
//
//        Explanation 1:
//
//        Remove edge between 5(root node) and 7:
//
//        Tree 1 =                                               Tree 2 =

//        5                                                     7
//       /                                                     / \
//      3                                                     5   6
//     / \
//   4   6
//        Sum of Tree 1 = Sum of Tree 2 = 18

//        Explanation 2:
//
//        The given Tree cannot be partitioned.
//


public class EqualTreePartition {
    int ans=0;
    long sum(TreeNode A){
        if(A==null){
            return 0;
        }
        long l=sum(A.left);
        long r=sum(A.right);
        return (l+r+A.val);
    }
    long Possible(TreeNode A, long s){
        if(A==null){
            return 0;
        }
        long l=Possible(A.left,s);
        if(l==s/2){
            ans=1;
        }
        long r=Possible(A.right,s);
        if(r==s/2){
            ans=1;
        }
        return (l+r+A.val);
    }
    public int solve(TreeNode A) {
        long s=sum(A);
        if(s%2!=0){
            return 0;
        }
        long g=Possible(A,s);
        return ans;
    }
    public static void main(String[] args) {
        EqualTreePartition I = new EqualTreePartition();
        TreeNode A=new TreeNode(5);
        TreeNode A2=new TreeNode(3);
        TreeNode A3=new TreeNode(7);
        A.left=A2;
        A.right=A3;
        TreeNode A4=new TreeNode(4);
        TreeNode A5=new TreeNode(6);
        A2.left=A4;
        A2.right=A5;
        TreeNode A6=new TreeNode(5);
        TreeNode A7=new TreeNode(6);
        A3.right=A6;
        A6.left=A7;
        System.out.println( I.solve(A));
    }
}



