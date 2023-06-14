package Advance_Sorting_1_Selection_And_Merge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Q=Problem Description
//        Find the Bth smallest element in given array A .
//
//        NOTE: Users should try to solve it in less than equal to B swaps.
//
//        Problem Constraints
//        1 <= |A| <= 100000
//        1 <= B <= min(|A|, 500)
//        1 <= A[i] <= 10^9

public class KthSmallestElement {
    public int kthsmallest(final List<Integer> A, int B) {
        ArrayList<Integer> a=new ArrayList<Integer>();
        for(int i=0;i<A.size();i++){
            a.add(A.get(i));
        }
        Collections.sort(a);
        return a.get(B-1);
    }
    public static void main(String[] args) {
        KthSmallestElement I = new KthSmallestElement();
        ArrayList<Integer>A=new ArrayList<>();
        A.add(2);A.add( 1);A.add(4);A.add( 3);A.add(2);
        System.out.println(I.kthsmallest(A,3));
    }
}

