package Advance_Sorting_Insertion_And_Quick;

import java.util.ArrayList;

//Q=Problem Description
//        Given an array of integers A of size N that is a permutation of [0, 1, 2, ..., (N-1)],
//        if we split the array into some number of "chunks" (partitions), and individually sort each chunk. After concatenating them in order of splitting, the result equals the sorted array.
//
//        What is the most number of chunks we could have made?
//
//
//
//        Problem Constraints
//        1 <= N <= 100000
//        0 <= A[i] < N



public class MaxChunksToMakeSorted {
    public int solve(ArrayList<Integer> A) {
        int max=-1;
        int count=0;
        for(int i=0;i<A.size();i++){
            max=Math.max(max,A.get(i));
            if(max==i){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        MaxChunksToMakeSorted I = new MaxChunksToMakeSorted();
        ArrayList<Integer>A=new ArrayList<>();
        A.add(2);A.add( 0);A.add(1);A.add(3);
        System.out.println(I.solve(A));
    }
}
