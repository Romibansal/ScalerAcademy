package Advance_Radix_Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//Q=Problem Description
//        Given an array A of non-negative integers, arrange them such that they form the largest number.
//
//        Note: The result may be very large, so you need to return a string instead of an integer.
//
//
//
//        Problem Constraints
//        1 <= len(A) <= 100000
//        0 <= A[i] <= 2*10^9

public class LargestNumber {
    public String largestNumber(final List<Integer> a) {
        ArrayList<Integer> A=new ArrayList<Integer>();
        for(int i=0;i<a.size();i++){
            A.add(a.get(i));
        }
        Collections.sort(A, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1=String.valueOf(o1)+String.valueOf(o2);
                String s2=String.valueOf(o2)+String.valueOf(o1);
                return s2.compareTo(s1);
            }
        });
        if(A.get(0)==0){
            return "0";
        }
        StringBuilder result=new StringBuilder();
        for(int i=0;i<A.size();i++){
            result.append(A.get(i));
        }
        return result.toString();
        // we use string builder rather than adding string to string because
        // it causes time limit exceed
    }
    public static void main(String[] args) {
        LargestNumber I = new LargestNumber();
        ArrayList<Integer> A=new ArrayList<>();
        A.add(3);A.add(30); A.add(34);A.add(5);A.add(9);

        System.out.println(I.largestNumber(A));
    }
}

