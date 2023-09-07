package Advance_DP_One_Dimension;

//Q=Problem Description
//        You are climbing a staircase and it takes A steps to reach the top.
//
//        Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
//
//        Return the number of distinct ways modulo 1000000007
//
//
//
//        Problem Constraints
//        1 <= A <= 10^5
//
//
//
//        Input Format

//        The first and the only argument contains an integer A, the number of steps.
//
//
//
//        Output Format

//        Return an integer, representing the number of ways to reach the top.
//
//
//
//        Example Input

//        Input 1:
//
//        A = 2

//        Input 2:
//
//        A = 3
//
//
//        Example Output

//        Output 1:
//
//        2

//        Output 2:
//
//        3
//
//
//        Example Explanation

//        Explanation 1:
//
//        Distinct ways to reach top: [1, 1], [2].

//        Explanation 2:
//
//        Distinct ways to reach top: [1 1 1], [1 2], [2 1].

public class Stairs {
    int[] temp;
    int mod=1000000007;
    int ways(int A){
        if(temp[A]!=-1){
            return temp[A];
        }
        if(A==2){
            return 2;
        }
        if(A==1){
            return 1;
        }
        int ans=(ways(A-1)%mod+ways(A-2)%mod)%mod;
        temp[A]=ans;
        return ans;
    }
    public int climbStairs(int A) {
         temp=new int[A+1];
        for(int i=0;i<temp.length;i++){
            temp[i]=-1;
        }
        return ways(A);
    }
    public static void main(String[] args) {
        Stairs I = new Stairs();
        System.out.println( I.climbStairs(4));
    }
}


