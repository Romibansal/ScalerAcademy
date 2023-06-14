package Advance_Sorting_1_Selection_And_Merge;

import java.util.ArrayList;
import java.util.Collections;

//Q=Problem Description
//        Given an array of integers A, find and return the minimum
//        value of | A [ i ] - A [ j ] | where i != j and |x| denotes the absolute value of x.
//
//
//        Problem Constraints
//        2 <= length of the array <= 100000
//
//        -10^9 <= A[i] <= 10^9

public class MinimumAbsoluteDifference {
    public int solve(ArrayList<Integer> A) {
        Collections.sort(A);
        int ans=1000000000;
        for(int i=A.size()-1;i>0;i--){
            int diff=(A.get(i)-A.get(i-1));
            ans=Math.min(diff,ans);
        }
        return ans;
    }
    public static void main(String[] args) {
        MinimumAbsoluteDifference I = new MinimumAbsoluteDifference();
        ArrayList<Integer>A=new ArrayList<>();
        A.add(5);A.add( 16);A.add(100);A.add(11);
        System.out.println(I.solve(A));
    }
}


