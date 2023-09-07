package Advance_DP_Two_Dimension;
//
//Q=Problem Description
//        Given an integer A, how many structurally unique BST's (binary search trees)
//        exist that can store values 1...A?
//
//
//
//        Problem Constraints

//        1 <= A <=18
//
//
//
//        Input Format
//        First and only argument is the integer A
//
//
//

//        Output Format

//        Return a single integer, the answer to the problem
//
//
//
//        Example Input

//        Input 1:
//
//        1

//        Input 2:
//
//        2
//
//
//        Example Output

//        Output 1:
//
//        1

//        Output 2:
//
//        2
//
//
//        Example Explanation

//        Explanation 1:
//
//        Only single node tree is possible.

//        Explanation 2:
//
//        2 trees are possible, one rooted at 1 and other rooted at 2.

public class UniqueBinarySearchTreesII {
    int[] dp;
    int catlon_Numbers(int A){
        if(dp[A]!=0){
            return dp[A];
        }
        int ans=0;
        for(int i=0;i<A;i++){
            ans=ans+(catlon_Numbers(i)*catlon_Numbers(A-i-1));
        }
        dp[A]=ans;
        return ans;
    }
    public int numTrees(int A) {
        dp=new int[A+1];
        dp[0]=1;
        dp[1]=1;
        return catlon_Numbers(A);
    }

    public static void main(String[] args) {
        UniqueBinarySearchTreesII I = new UniqueBinarySearchTreesII();
        System.out.println( I.numTrees(4));
    }
}

