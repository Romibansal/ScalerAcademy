package Advance_Sorting_1_Selection_And_Merge;

import java.util.ArrayList;
import java.util.List;

//Q=Problem Description
//        Given two sorted integer arrays A and B, merge B and A as one sorted array and return it as an output.
//
//
//        Problem Constraints
//        -10^10 <= A[i], B[i] <= 10^10

public class Merge_Two_Sorted_Array {
    public ArrayList<Integer> solve(final List<Integer> A, final List<Integer> B) {
        ArrayList<Integer> ans=new ArrayList<>();
        int i=0;int j=0;
        while(i<A.size() && j<B.size()){
            if(B.get(j)<A.get(i)){
                ans.add(B.get(j));
                j++;
            }
            else{
                ans.add(A.get(i));
                i++;
            }
        }
        while(i<A.size()){
            ans.add(A.get(i));
            i++;
        }
        while(j<B.size()){
            ans.add(B.get(j));
            j++;
        }
        return ans;
    }
    public static void main(String[] args) {
        Merge_Two_Sorted_Array I = new Merge_Two_Sorted_Array();
        ArrayList<Integer>A=new ArrayList<>();
        ArrayList<Integer>B=new ArrayList<>();

        A.add(4);A.add( 7);A.add(9);
        B.add(2);A.add( 11);B.add( 19);
        System.out.println(I.solve(A,B));
    }
}


