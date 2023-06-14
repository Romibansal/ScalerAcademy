package Advance_Sorting_1_Selection_And_Merge;

import java.util.ArrayList;
import java.util.Collections;

//Q=Problem Description
//        Given an array of integers A of size N where N is even.
//
//        Divide the array into two subsets such that
//
//        1.Length of both subset is equal.
//        2.Each element of A occurs in exactly one of these subset.
//        Magic number = sum of absolute difference of corresponding elements of subset.
//
//        Note: You can reorder the position of elements within the subset to find the value of the magic number.
//
//        For Ex:-
//        subset 1 = {1, 5, 1},
//        subset 2 = {1, 7, 11}
//        Magic number = abs(1 - 1) + abs(5 - 7) + abs(1 - 11) = 12
//        Return an array B of size 2, where B[0] = maximum possible value of Magic
//        number modulo 109 + 7, B[1] = minimum possible value of a Magic number modulo 109 + 7.
//
//        Problem Constraints
//        1 <= N <= 10^5
//        -10^9 <= A[i] <= 10^9
//        N is even

public class MaximumAndMinimumMagic {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        Collections.sort(A);
        int mod=(int)Math.pow(10,9)+7;
        ArrayList<Integer> ans=new ArrayList<>();
        int max=0;
        for(int i=0;i<(A.size()/2);i++){
            int diff=(A.get(A.size()-1-i)-A.get(i));
            long l=(max%mod+diff%mod)%mod;
            max=(int)l;
        }
        int min=0;
        for(int i=0;i<A.size();i=i+2){
            int diff =(A.get(i+1)-A.get(i));
            long l=(min%mod+diff%mod)%mod;
            min=(int)l;
        }
        ans.add(max);
        ans.add(min);
        return ans;
    }
    public static void main(String[] args) {
        MaximumAndMinimumMagic I = new MaximumAndMinimumMagic();
        ArrayList<Integer>A=new ArrayList<>();
        A.add(3);A.add( 11);A.add(-1);A.add(5);
        System.out.println(I.solve(A));
    }
}
