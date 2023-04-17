package Carry_Forward;

//Q=Problem Description
//        Say you have an array, A, for which the ith element is the price of a given stock on day i.
//        If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock),
//        design an algorithm to find the maximum profit.
//
//        Return the maximum possible profit.
//
//        Problem Constraints
//        0 <= len(A) <= 7e5
//        1 <= A[i] <= 1e7


public class BestTimeToBuyAndSellStocks {
    public int maxProfit(final int[] A) {
        if(A.length<2){
            return 0;
        }
        int min=A[0];
        int ans=0;
        for(int i=0;i<A.length;i++){
            if(min>A[i]){
                min=A[i];
            }
            ans=Math.max(ans,A[i]-min);
        }
        return ans;
    }
    public static void main(String[] args) {
        BestTimeToBuyAndSellStocks I = new BestTimeToBuyAndSellStocks();
        int []A=new int[5];
        A[0]=1;A[1]=4;A[2]=5;A[3]=2;A[4]=4;
        System.out.println( I.maxProfit(A));
    }
}




