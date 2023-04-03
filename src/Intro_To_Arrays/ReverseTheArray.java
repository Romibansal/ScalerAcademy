package Intro_To_Arrays;

//Q=Problem Description
//        You are given a constant array A.
//        You are required to return another array which is the reversed form of the input array.
//
//        Problem Constraints
//        1 <= A.size() <= 10000
//        1 <= A[i] <= 10000




public class ReverseTheArray {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int[] solve(final int[] A) {
        int[] B = new int[A.length];
        for(int i=0;i<A.length;i++){
            B[A.length-1-i]=A[i];
        }
        return B;
    }
    public static void main(String args []){
        ReverseTheArray N1=new ReverseTheArray();
        int[] A=new int[4];
        A[0]=1;A[3]=4;
        A[1]=2;
        A[2]=3;
        System.out.println( N1.solve(A));
    }
}