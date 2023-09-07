package Advance_DP_Knapsack;

import java.util.ArrayList;
//
//Q=Problem Description
//        Given a knapsack weight A and a set of items with certain value B[i] and weight C[i],
//        we need to calculate maximum amount that could fit in this quantity.
//
//        This is different from classical Knapsack problem, here we are allowed to use
//        unlimited number of instances of an item.
//
//
//
//        Problem Constraints

//        1 <= A <= 1000
//
//        1 <= |B| <= 1000
//
//        1 <= B[i] <= 1000
//
//        1 <= C[i] <= 1000
//
//
//
//        Input Format

//        First argument is the Weight of knapsack A
//
//        Second argument is the vector of values B
//
//        Third argument is the vector of weights C
//
//
//
//        Output Format

//        Return the maximum value that fills the knapsack completely
//
//
//
//        Example Input

//        Input 1:
//
//        A = 10
//        B = [5]
//        C = [10]

//        Input 2:
//
//        A = 10
//        B = [6, 7]
//        C = [5, 5]
//
//
//        Example Output

//        Output 1:
//
//        5

//        Output 2:
//
//        14

public class UnboundedKnapsack {
    int[] dp;
    class pair{
        int profit;
        int weight;
        pair(int p,int w){
            profit=p;
            weight=w;
        }
    }
    int method(int capacity,ArrayList<pair>p){
        if(capacity==0){
            return 0;
        }
        if(dp[capacity]!=-1){
            return dp[capacity];
        }
        int ans=0;
        for(int i=0;i<p.size();i++){
            if(p.get(i).weight<=capacity) {
                ans = Math.max(ans,(p.get(i).profit + method(capacity - p.get(i).weight, p)));
            }
        }
        dp[capacity]=ans;
        return ans;
    }
    public int solve( int C,ArrayList<Integer> A, ArrayList<Integer> B) {
        dp=new int[C+1];
        for(int j=0;j<C+1;j++){
            dp[j]=-1;
        }
        ArrayList<pair>p=new ArrayList<>();
        for(int i=0;i<A.size();i++){
            p.add(new pair(A.get(i),B.get(i)));
        }
        return method(C,p);
    }
    public static void main(String[] args) {
        UnboundedKnapsack I = new UnboundedKnapsack();
        ArrayList<Integer>B=new ArrayList<>();
        B.add(60);B.add(100);B.add(120);
        ArrayList<Integer>C=new ArrayList<>();
        C.add(10); C.add(20);C.add(30);
        System.out.println( I.solve(50,B,C));
    }
}

