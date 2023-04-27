package Bit_Manipulation_1;

//Q=Problem Description
//        Given an array B of length A with elements 1 or 0. Find the number of subarrays such that the bitwise OR of all the elements present in the subarray is 1.
//        Note : The answer can be large. So, return type must be long.
//
//
//
//        Problem Constraints
//        1 <= A <= 10^5

public class SubarraysWithBitwiseOR1 {
    public long solve(int A, int[] B) {
        long zero=0;
        int start=-1;
        int end=-1;
        long n=0;
        for(int i=0;i<B.length;i++){
            if(B[i]==0 && start==-1){
                start=i;
            }
            if(B[i]==1 && start!=-1){
                end=i;
                n=end-start;
                long h=n*(n+1);
                zero=zero+(h/2);
                start=-1;
            }
        }
        if(start!=-1){
            n=A-start;
            long f=n*(n+1);
            zero=zero+(f/2);
        }
        long q=0;
        if(A%2==0){
            q=A/2;
            return (((A+1)*q)-zero);
        }
        else{
            q=(A+1)/2;
            return ((A*q)-zero);
        }
    }
    public static void main(String args []){
        SubarraysWithBitwiseOR1 S1=new SubarraysWithBitwiseOR1();
        int[] B=new int[5];
        B[0]=0;B[1]=1;B[2]=0;B[3]=0;B[4]=0;
        int A =5;


       System.out.println( S1.solve(A,B));
    }
}


