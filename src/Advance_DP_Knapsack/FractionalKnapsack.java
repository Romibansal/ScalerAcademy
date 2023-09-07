package Advance_DP_Knapsack;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//
//Q=Problem Description
//        Given two integer arrays A and B of size N each which represent values and weights associated
//        with N items respectively.
//
//        Also given an integer C which represents knapsack capacity.
//
//        Find out the maximum total value that we can fit in the knapsack. If the maximum total value is ans,
//        then return ⌊ans × 100⌋ , i.e., floor of (ans × 100).
//
//        NOTE:
//
//        You can break an item for maximizing the total value of the knapsack
//
//
//        Problem Constraints

//        1 <= N <= 10^5
//
//        1 <= A[i], B[i] <= 10^3
//
//        1 <= C <= 10^3
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

//        Return a single integer denoting the maximum total value of A such that sum
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
//        24000

//        Output 2:
//
//        2105

public class FractionalKnapsack {
    class pair{
        int profit;
        int weight;
        double fraction;
        pair(int p,int w){
            profit=p;
            weight=w;
            fraction=((1.0)*p/w);
        }
    }
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        ArrayList<pair>p=new ArrayList<>();
        for(int i=0;i<A.size();i++){
            p.add(new pair(A.get(i),B.get(i)));
        }
        Collections.sort(p, new Comparator<pair>() {
            @Override
            public int compare(pair o1, pair o2) {
                if(o1.fraction>o2.fraction){
                    return -1;
                }
                return 1;
            }
        });
        double ans=0;
        for(int i=0;i<A.size();i++){
            if(p.get(i).weight<=C){
                ans=ans+p.get(i).profit;
                C=C-p.get(i).weight;
            }
            else{
                ans=ans+(C*p.get(i).fraction);
                break;
            }
        }
        ans=ans*1000;
        return (int)(ans/10);
    }
    public static void main(String[] args) {
        FractionalKnapsack I = new FractionalKnapsack();
        ArrayList<Integer>A=new ArrayList<>();
        A.add(3);
        ArrayList<Integer>B=new ArrayList<>();
        B.add(20);
        System.out.println( I.solve(A,B,17));
    }
}

