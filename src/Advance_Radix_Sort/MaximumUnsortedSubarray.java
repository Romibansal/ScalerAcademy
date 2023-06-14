package Advance_Radix_Sort;


import java.util.Arrays;

//Q=Problem Description
//        Given an array A of non-negative integers of size N. Find the minimum sub-array Al, Al+1 ,..., Ar
//        such that if we sort(in ascending order) that sub-array, then the whole array should get sorted.
//        If A is already sorted, output -1.
//
//        Note :
//        Follow 0-based indexing, while returning the sub-array's starting and ending indexes.
//
//        Problem Constraints
//        1 <= N <= 1000000
//        1 <= A[i] <= 1000000
//
//        Input Format
//        First and only argument is an array of non-negative integers of size N.
//
//        Output Format
//        Return an array of length two where,
//        the first element denotes the starting index(0-based) and
//        the second element denotes the ending index(0-based) of the sub-array.
//        If the array is already sorted, return an array containing only one element i.e. -1.


public class MaximumUnsortedSubarray {
    public int[] subUnsort(int[] A) {
        int B[]=new int[A.length];
        for(int i=0;i<A.length;i++){
            B[i]=A[i];
        }
        Arrays.sort(B);
        int s=-1;
        int l=-1;
        for(int i=0;i<A.length;i++){
            if(A[i]==B[i]){
                continue;
            }
            else{
                if(s==-1){
                    s=i;
                    l=i;
                }
                else{
                    l=i;
                }
            }
        }
        if(s==-1){
            int C[]=new int[1];
            C[0]=-1;
            return C;
        }
        int C[]=new int[2];
        C[0]=s;
        C[1]=l;
        return C;
    }
    public static void main(String[] args) {
        MaximumUnsortedSubarray I = new MaximumUnsortedSubarray();
        int A[]= {1,1,10,10,15,10,15,10,10,15,10,15};

        System.out.println(I.subUnsort(A));
    }
}


