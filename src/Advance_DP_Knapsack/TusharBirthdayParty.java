package Advance_DP_Knapsack;

import java.util.ArrayList;
import java.util.List;
//
//Q=Problem Description
//        As it is Tushar's Birthday on March 1st, he decided to throw a party to all his friends at
//        TGI Fridays in Pune. Given are the eating capacity of each friend, filling capacity of each
//        dish and cost of each dish. A friend is satisfied if the sum of the filling capacity of dishes
//        he ate is equal to his capacity. Find the minimum cost such that all of Tushar's friends are
//        satisfied (reached their eating capacity).
//
//        NOTE:
//
//        Each dish is supposed to be eaten by only one person. Sharing is not allowed.
//
//        Each friend can take any dish unlimited number of times.
//
//        There always exists a dish with filling capacity 1 so that a solution always exists.
//
//
//
//        Problem Constraints

//        |A| <= 1000
//
//        |B| <= 1000
//
//        |C| <= 1000
//
//
//
//        Input Format

//        First Argument is vector A, denoting eating capacities
//
//        Second Argument is vector B, denoting filling capacities
//
//        Third Argument is vector C, denoting cost
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
//        A = [2, 4, 6]
//        B = [2, 1, 3]
//        C = [2, 5, 3]

//        Input 2:
//
//        A = [2]
//        B = [1]
//        C = [2]
//
//
//        Example Output

//        Output 1:
//
//        12

//        Output 2:
//
//        4


//
//Example Explanation

//        Explanation 1:
//
//        First friend takes dish 1, Second friend takes dish 1 twice and third friend takes dish 3 twice.
//        So 2 + 2*2 + 3*2 = 12.

//        Explanation 2:
//
//        Only way is to take 2 dishes of cost 2, hence 4.

public class TusharBirthdayParty {
    int dp[];
    class pair{
        int cap;
        int price;
        pair(int c,int p){
            cap=c;
            price=p;
        }
    }
    int method(int capacity,ArrayList<pair>pairs){
        if(capacity==0){
            return 0;
        }
        if(dp[capacity]!=-1){
            return dp[capacity];
        }

        int ans=Integer.MAX_VALUE;
        for(int i=0;i<pairs.size();i++){
            if(pairs.get(i).cap<=capacity) {
                ans = Math.min(ans,(pairs.get(i).price + method(capacity - pairs.get(i).cap, pairs)));
            }
        }
        dp[capacity]=ans;
        return ans;
    }
    void unboundedKnapsack(int capacity, List<Integer> capacities, List<Integer> cost){
        ArrayList<pair> pairs=new ArrayList<>();
        for(int i=0;i<capacities.size();i++){
            pairs.add(new pair(capacities.get(i),cost.get(i)));
        }
        method(capacity,pairs);
    }
    public int solve(final List<Integer> A, final List<Integer> B, final List<Integer> C) {
        int max=A.get(0);
        for(int i=0;i<A.size();i++){
            max=Math.max(A.get(i),max);
        }
        dp=new int[max+1];
        for(int i=0;i<max+1;i++){
            dp[i]=-1;
        }
        unboundedKnapsack(max,B,C);
        int ans=0;
        for(int i=0;i<A.size();i++){
            ans=ans+dp[A.get(i)];
        }
        return ans;
    }

    public static void main(String[] args) {
        TusharBirthdayParty I = new TusharBirthdayParty();
        ArrayList<Integer>A=new ArrayList<>();
        A.add(2);A.add( 4);A.add( 6);
        ArrayList<Integer>B=new ArrayList<>();
        B.add(2);B.add( 1);B.add( 3);
        ArrayList<Integer>C=new ArrayList<>();
        C.add(2);C.add( 5);C.add( 3);
        System.out.println( I.solve(A,B,C));
    }
}


