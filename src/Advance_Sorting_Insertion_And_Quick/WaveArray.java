package Advance_Sorting_Insertion_And_Quick;

import java.util.ArrayList;
import java.util.Collections;

//Q=Problem Description
//        Given an array of integers A, sort the array into a wave-like array and return it.
//        In other words, arrange the elements into a sequence such that
//
//        a1 >= a2 <= a3 >= a4 <= a5.....
//        NOTE: If multiple answers are possible, return the lexicographically smallest one.
//
//
//
//        Problem Constraints
//        1 <= len(A) <= 10^6
//        1 <= A[i] <= 10^6



public class WaveArray {
    public ArrayList<Integer> wave(ArrayList<Integer> A) {
        Collections.sort(A);
        for(int i=1;i<A.size();i=i+2){
            int temp=A.get(i);
            A.set(i,A.get(i-1));
            A.set(i-1,temp);
        }
        return A;
    }
    public static void main(String[] args) {
        WaveArray I = new WaveArray();
        ArrayList<Integer>A=new ArrayList<>();
        A.add(1);A.add( 2);A.add(3);A.add(4);
        System.out.println(I.wave(A));
    }
}
