package Advance_DP_Knapsack;

//Q=Problem Description
//
//        You are trying to send signals to aliens using a linear array of A laser lights.
//        You don't know much about how the aliens are going to percieve the signals,
//        but what you know is that if two consecutive lights are on then the aliens might
//        take it as a sign of danger and destroy the earth.
//
//        Find and return the total number of ways in which you can send a signal without compromising

//        the safty of the earth. Return the ans % 10^9 + 7.
//
//
//
//        Problem Constraints
//
//        1 <= A <= 10^5
//
//
//
//        Input Format
//
//        The only argument given is integer A.
//
//
//
//        Output Format
//
//        Return the ans%(109+7).
//
//
//
//        Example Input
//
//        Input 1:
//
//        A = 2

//        Input 2:
//
//        A = 3
//
//
//        Example Output
//
//        Output 1:
//
//        3
//        Output 2:
//
//        5
//
//
//        Example Explanation
//
//        Explanation 1:
//
//        OFF OFF
//        OFF ON
//        ON OFF

//        All lights off is also a valid signal which probably means 'bye'
//
//        Explanation 2:
//
//        OFF OFF OFF
//        OFF OFF ON
//        OFF ON OFF
//        ON OFF OFF
//        ON OFF ON
//


public class WaysToSendTheSignal {
    int[][]dp;
    int mod=(int)(Math.pow(10,9)+7);
    int method(int index, String str,int A){
        if(str=="off"){
            if(dp[index][0]!=-1){
                return dp[index][0];
            }
        }
        if(str=="on"){
            if(dp[index][1]!=-1){
                return dp[index][1];
            }
        }
        if(index==A){
            return 1;
        }
        long t=0,t1=0;
        if(str=="on"){
            t=method(index+1,"off",A);
        }
        else{
            t1=((method(index+1,"off",A))%mod+(method(index+1,"on",A))%mod)%mod;
        }
        if(str=="off") {
            dp[index][0]=(int)((t%mod + t1%mod)%mod);
        }
        if(str=="on"){
            dp[index][1]=(int)((t%mod + t1%mod)%mod);
        }
        return (int)((t%mod + t1%mod)%mod);
    }
    public int solve(int A) {
        dp=new int[A+1][2];
        for(int i=0;i<A+1;i++){
            for(int j=0;j<2;j++){
                dp[i][j]=-1;
            }
        }
        return ((method(1,"on",A)%mod+method(1,"off",A)%mod))%mod;
    }
    public static void main(String[] args) {
        WaysToSendTheSignal I = new WaysToSendTheSignal();

        System.out.println( I.solve(3));
    }
}

