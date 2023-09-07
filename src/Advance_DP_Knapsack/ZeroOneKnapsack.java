package Advance_DP_Knapsack;

import java.util.ArrayList;

//Q=Problem Description
//        Given two integer arrays A and B of size N each which represent values and weights associated
//        with N items respectively.
//
//        Also given an integer C which represents knapsack capacity.
//
//        Find out the maximum value subset of A such that sum of the weights of this subset is
//        smaller than or equal to C.
//
//        NOTE:
//
//        You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).
//
//
//        Problem Constraints

//        1 <= N <= 10^3
//
//        1 <= C <= 10^3
//
//        1 <= A[i], B[i] <= 10^3
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

//        Return a single integer denoting the maximum value subset of A such that sum
//        of the weights of this subset is smaller than or equal to C.
//
//
//
//        Example Input

//        Input 1:
//
//        A = [60, 100, 120]
//        B = [10, 20, 30]
//        C = 50

//        Input 2:
//
//        A = [10, 20, 30, 40]
//        B = [12, 13, 15, 19]
//        C = 10
//
//
//        Example Output

//        Output 1:
//
//        220

//        Output 2:
//
//        0

public class ZeroOneKnapsack {
    int[][] dp;
    class pair{
        int profit;
        int weight;
        pair(int p,int w){
            profit=p;
            weight=w;
        }
    }
    int method(int index,int capacity,ArrayList<pair>p){

        if(index==p.size()){
            return 0;
        }
        if(dp[index][capacity]!=-1){
            return dp[index][capacity];
        }
        int ans=method(index+1,capacity,p);
        if(p.get(index).weight<=capacity){
            int temp_profit=p.get(index).profit;
            int temp_weight=p.get(index).weight;
            ans=Math.max(ans,temp_profit+method(index+1,capacity-temp_weight,p));
        }
        dp[index][capacity]=ans;
        return ans;
    }
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        dp=new int[A.size()][C+1];
        for(int i=0;i<A.size();i++){
            for(int j=0;j<C+1;j++){
                dp[i][j]=-1;
            }
        }
        ArrayList<pair>p=new ArrayList<>();
        for(int i=0;i<A.size();i++){
            p.add(new pair(A.get(i),B.get(i)));
        }
        return method(0,C,p);
    }
    public static void main(String[] args) {
        ZeroOneKnapsack I = new ZeroOneKnapsack();
        ArrayList<Integer>A=new ArrayList<>();
        A.add(60);A.add(100);A.add(120);
        ArrayList<Integer>B=new ArrayList<>();
        B.add(10);B.add(20);B.add(30);
        System.out.println( I.solve(A,B,50));
    }
}
