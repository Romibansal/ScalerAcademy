package Intro_To_Arrays;

//Q=Problem Description
//
//        Given an array A and an integer B, find the number of occurrences of B in A.
//
//        Problem Constraints
//        1 <= B, Ai <= 10^9
//        1 <= |A| <= 10^5




public class LinearSearchMultipleOccurence {
    public int solve(int[] A, int B) {
        int count=0;
        for(int i=0;i<A.length;i++){
            if(A[i]==B){
                count++;
            }
        }
        return count;
    }
    public static void main(String args []){
        LinearSearchMultipleOccurence N1=new LinearSearchMultipleOccurence();
        int[] A=new int[4];
        A[0]=1;
        A[1]=2;
        A[2]=2;
        System.out.println( N1.solve(A,2));
    }
}
