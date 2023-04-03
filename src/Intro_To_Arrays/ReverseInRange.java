package Intro_To_Arrays;

//Q=Problem Description
//        Given an array A of N integers. Also given are two integers B and C.
//        Reverse the array A in the given range [B, C]
//
//        Problem Constraints
//        1 <= N <= 10^5
//        1 <= A[i] <= 10^9
//        0 <= B <= C <= N - 1



public class ReverseInRange {
    public int[] solve(int[] A, int B, int C) {
        while(B<C){
            int temp=A[B];
            A[B]=A[C];
            A[C]=temp;
            B++;
            C--;
        }
        return A;
    }
    public static void main(String args []){
        ReverseInRange N1=new ReverseInRange();
        int[] A=new int[4];
        A[0]=1;A[3]=4;
        A[1]=2;
        A[2]=3;
        System.out.println( N1.solve(A,2,3));
    }
}
