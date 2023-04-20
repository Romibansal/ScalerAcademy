package Unique_Questions;

import java.util.HashSet;

//Q= Alice is a data analyst working for a company that collects data from different sources. One of the data sets that she has
//received is an array of integers A of size N from one of the company's.
//
//Alice is tasked with analysing this array checking whether the number of occurences of each value in the array is exaactly
//one. If the number of occurences of each value is one, then the data set is considered reliable and can be used for further analysis
//Alice needs to write a program to perform this analysis efficiently.

// Problem Constraints
// 1<=N<=10^5
// 1<=A[i]<=10^9

public class SimilarElementsC3 {
    public int solve(int[] A) {
        HashSet<Integer> hs=new HashSet();
        for(int i=0;i<A.length;i++){
            if(hs.contains(A[i])){
                return 0;
            }
            else{
                hs.add(A[i]);
            }
        }
        return 1;
    }
    public static void main(String args []){
        SimilarElementsC3 S1=new SimilarElementsC3();
        int A[]=new int[4];
        A[0]=2;A[2]=3;
        A[1]=1;A[3]=2;
        System.out.println( S1.solve(A));
    }
}



