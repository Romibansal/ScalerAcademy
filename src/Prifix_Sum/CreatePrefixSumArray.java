package Prifix_Sum;

//Q=Problem Description
//        Given an array A of N integers. Construct prefix sum of the array in the given array itself.
//
//
//        Problem Constraints
//        1 <= N <= 10^5
//        1 <= A[i] <= 10^3


public class CreatePrefixSumArray {
    public int[] solve(int[] A) {
        for(int i=1;i<A.length;i++){
            A[i]=A[i-1]+A[i];
        }
        return A;
    }
    public static void main(String[] args) {
        CreatePrefixSumArray I = new CreatePrefixSumArray();
        int[] A=new int[5];
        A[0]=1 ;
        A[1]=2;
        A[2]=3;
        A[3]=4;
        A[4]=5;
        System.out.println( I.solve(A));
        System.out.println((A[0]));System.out.println((A[1]));System.out.println((A[2]));System.out.println((A[3]));
    }
}




