package Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//
//Q=Problem Description
//        You are given an array A of N elements. Sort the given array in
//        increasing order of number of distinct factors of each element, i.e.,
//        element having the least number of factors should be the first to be displayed and
//        the number having highest number of factors should be the last one. If 2 elements have
//        same number of factors, then number with less value should come first.
//
//        Note: You cannot use any extra space


public class FactorSortUsingComparator {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        Collections.sort(A,new Comparator<Integer>()
        {
            public int compare(Integer a,Integer b)
            {
                int factA=countOfFactors(a);
                int factB=countOfFactors(b);
                if(factA<factB){
                    return -1;
                }
                if(factA==factB ){
                    if(a>b){
                        return 1;
                    }
                    else{
                        return -1;
                    }
                }
                else{
                    return 1;
                }
            }
            public int countOfFactors(int a){
                int count=0;
                for(int i=1;i<=Math.sqrt(a);i++){
                    if(a%i==0){
                        if(i!=(a/i)){
                            count=count+2;
                        }
                        else{
                            count=count+1;
                        }
                    }
                }
                return count;
            }
        });
        return A;
    }
    public static void main(String args []){
        FactorSortUsingComparator N1=new FactorSortUsingComparator();
        ArrayList<Integer>A=new ArrayList<>(3);
        A.add(6); A.add(8); A.add(9);

        System.out.println( N1.solve(A));
    }
}

