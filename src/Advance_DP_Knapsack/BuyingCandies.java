package Advance_DP_Knapsack;

import java.util.ArrayList;

public class BuyingCandies {
    int dp[];
    class pair{
        int sweet;
        int price;
        pair(int s,int p){
            sweet=s;
            price=p;
        }
    }
    int unboundedKnapsack(ArrayList<pair> p,int cost){
        if(dp[cost]!=-1){
            return dp[cost];
        }
        int ans=0;
        for(int i=0;i<p.size();i++){
            if(p.get(i).price<=cost){
                ans=Math.max(ans,p.get(i).sweet+unboundedKnapsack(p,cost-p.get(i).price));
            }
        }
        dp[cost]=ans;
        return ans;

    }
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C, int D) {
        ArrayList<Integer>sweetness=new ArrayList<>();
        for(int i=0;i<A.size();i++){
            sweetness.add((A.get(i)*B.get(i)));
        }
        ArrayList<pair>p=new ArrayList<>();
        for(int i=0;i<A.size();i++){
            p.add(new pair(sweetness.get(i),C.get(i)));
        }
        dp=new int[D+1];
        for(int i=0;i<dp.length;i++){
            dp[i]=-1;
        }
        return unboundedKnapsack(p,D);
    }

    public static void main(String[] args) {
        BuyingCandies I = new BuyingCandies();
        ArrayList<Integer>A=new ArrayList<>();
        A.add(1);A.add (2);A.add( 3);
        ArrayList<Integer>B=new ArrayList<>();
        B.add(2);B.add( 2);B.add( 10);
        ArrayList<Integer>C=new ArrayList<>();
        C.add(2);C.add( 3);C.add( 9);
        System.out.println( I.solve(A,B,C,8));
    }
}


