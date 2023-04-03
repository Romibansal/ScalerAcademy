package Hashing_1;

import java.util.HashSet;

//Q=Problem Description
//        You are given an array A of N integers. You will have to return number of distinct elements of the array.
//
//        Problem Constraints
//        1 <= N <= 10^5
//        1 <= A[i] <= 10^9

public class CountDistinctElements {
    public int solve(int[] A) {
        HashSet<Integer> h=new HashSet<Integer>();
        for(int i=0;i<A.length;i++){
            h.add(A[i]);
        }
        return h.size();
    }
    public static void main(String args []){
        CountDistinctElements N1=new CountDistinctElements();
        int A[]=new int[5];
        A[0]=3;
        A[1]=4;A[2]=3;A[3]=6;A[4]=6;
        System.out.println( N1.solve(A));
    }
}
