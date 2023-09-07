package Advance_DP_Two_Dimension;

//
//Q=Problem Description

//        Find out the number of A digit positive numbers, whose digits on being added equals to a given number B.
//
//        Note that a valid number starts from digits 1-9 except the number 0 itself. i.e.
//        leading zeroes are not allowed.
//
//        Since the answer can be large, output answer modulo 1000000007
//
//
//
//        Problem Constraints

//        1 <= A <= 1000
//
//        1 <= B <= 10000
//
//
//
//        Input Format

//        First argument is the integer A
//
//        Second argument is the integer B
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
//        A = 2
//        B = 4

//        Input 2:
//
//        A = 1
//        B = 3
//
//
//        Example Output

//        Output 1:
//
//        4

//        Output 2:
//
//        1
//
//
//        Example Explanation

//        Explanation 1:
//
//        Valid numbers are {22, 31, 13, 40}
//        Hence output 4.

//        Explanation 2:
//
//        Only valid number is 3

public class NDigitNumber {
    int[][]dp;
    int mod=(int)(Math.pow(10,9)+7);
    long rec(int pend,int sum){
        if(pend==0 && sum==0){
            return 1;
        }
        if(sum<0){
            return 0;
        }
        if(pend==0){
            return 0;
        }
        if(dp[pend][sum]!=-1){
            return dp[pend][sum];
        }
        long ans=0;
        for(int i=0;i<10;i++){
            long temp=rec(pend-1,sum-i);
            ans=(ans%mod+temp%mod)%mod;
        }
        dp[pend][sum]=(int)(ans%mod);
        return ans;
    }
    public int solve(int A, int B) {
        long ans=0;
        dp=new int[A+1][B+1];
        for(int i=0;i<A+1;i++){
            for(int j=0;j<B+1;j++){
                dp[i][j]=-1;
            }
        }
        for(int i=1;i<10;i++){
            ans=(ans%mod+(rec(A-1,B-i))%mod)%mod;
        }
        return (int)(ans%mod);
    }
    public static void main(String[] args) {
        NDigitNumber I = new NDigitNumber();
        System.out.println( I.solve(3,8));
    }
}

