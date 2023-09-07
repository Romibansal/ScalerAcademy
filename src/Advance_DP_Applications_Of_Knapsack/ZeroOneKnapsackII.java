package Advance_DP_Applications_Of_Knapsack;


import java.util.ArrayList;
//
//Q=Problem Description
//        Given two integer arrays A and B of size N each which represent values and weights
//        associated with N items respectively.
//
//        Also given an integer C which represents knapsack capacity.
//
//        Find out the maximum value subset of A such that sum of the weights of this subset is smaller than
//        or equal to C.
//
//        NOTE: You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).
//
//
//
//        Problem Constraints

//        1 <= N <= 500
//
//        1 <= C, B[i] <= 10^6
//
//        1 <= A[i] <= 50
//
//
//
//        Input Format
//        First argument is an integer array A of size N denoting the values on N items.
//
//        Second argument is an integer array B of size N denoting the weights on N items.
//
//        Third argument is an integer C denoting the knapsack capacity.
//
//
//
//        Output Format
//        Return a single integer denoting the maximum value subset of A such that sum of the weights of this subset is smaller than or equal to C.
//
//
//
//        Example Input
//        Input 1:
//
//        A = [6, 10, 12]
//        B = [10, 20, 30]
//        C = 50
//        Input 2:
//
//        A = [1, 3, 2, 4]
//        B = [12, 13, 15, 19]
//        C = 10
//
//
//        Example Output
//        Output 1:
//
//        22
//        Output 2:
//
//        0

public class ZeroOneKnapsackII {
    int dp[][];
    class pair{
        int value;
        int weight;
        pair(int v,int w){
            value=v;
            weight=w;
        }
    }
    int method(int index,int max,ArrayList<pair>p){
        if(index==p.size()){
            if(max==0){
                return 0;
            }
            return 1000000000;
        }

        if(dp[index][max]!=-1){
            return dp[index][max];
        }

        int ans=method(index+1,max,p);
        if(p.get(index).value<=max){
            int temp_value=p.get(index).value;
            int temp_weight=p.get(index).weight;
            ans=Math.min(ans,temp_weight+method(index+1,max-temp_value,p));
        }
        dp[index][max]=ans;
        return ans;
    }
    public int solve(int[] A, int[] B, int C) {
        int max=0;
        for(int i=0;i<A.length;i++){
            max=max+A[i];
        }
        ArrayList<pair>p=new ArrayList<>();
        for(int i=0;i<A.length;i++){
            p.add(new pair(A[i],B[i]));
        }
        dp=new int[A.length][max+1];
        for(int i=0;i<A.length;i++){
            for(int j=0;j<=max;j++){
                dp[i][j]=-1;
            }
        }

        for(int i=max;i>-1;i--){
            if(method(0,i,p)<=C){
                return i;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        ZeroOneKnapsackII I = new ZeroOneKnapsackII();
        int[]A=new int[3];
        A[0]=6;A[1]=10;A[2]= 12;
        int[]B=new int[3];
        B[0]=10;B[1] =20;B[2]= 30;
        System.out.println( I.solve(A,B,50));
    }
}



