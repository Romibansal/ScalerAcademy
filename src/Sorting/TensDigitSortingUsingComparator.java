package Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


//Q=Problem Description
//        Given an array A of N integers. Sort the array in increasing order of the value at
//        the tens place digit of every number.
//
//        If a number has no tens digit, we can assume value to be 0.
//        If 2 numbers have same tens digit, in that case number with max value will come first
//        Solution should be based on comparator.

class SortByTensdigitComparator implements Comparator<Integer>{
    public int compare(Integer a,Integer b){
        int A=a%100;
        int B=b%100;
        if((A/10)<(B/10)){
            return -1;
        }
        else if((A/10)==(B/10)){
            if(a>b){
                return -1;
            }
            else{
                return 1;
            }
        }
        else{
            return 1;
        }
    }
}


public class TensDigitSortingUsingComparator {

    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        Collections.sort(A,new SortByTensdigitComparator());
        return  A;
    }
    public static void main(String args []){
        TensDigitSortingUsingComparator N1=new TensDigitSortingUsingComparator();
        ArrayList<Integer>A=new ArrayList<>(4);
        A.add(15); A.add(11); A.add(7); A.add(19);

        System.out.println( N1.solve(A));
    }



}
