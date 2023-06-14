package Advance_Radix_Sort;

//Q=Problem Description
//        Given an array A. Sort this array using Count Sort Algorithm and return the sorted array.
//
//
//        Problem Constraints
//        1 <= |A| <= 10^5
//        1 <= A[i] <= 10^5

public class CountSort {
    public int[] solve(int[] A) {
        int count[]=new int[100001];
        for(int i=0;i<A.length;i++){
            count[A[i]]=count[A[i]]+1;
        }
        int index=0;
        for(int i=0;i<100001;i++){
            for(int j=0;j<count[i];j++){
                A[index]=i;
                index++;
            }
        }
        return A;
    }
    public static void main(String[] args) {
        CountSort I = new CountSort();
        int A[]=new int[5];
        A[0]=1;A[1]=2;A[2]=3;A[3]=4;A[4]=5;

        System.out.println(I.solve(A));
    }
}




