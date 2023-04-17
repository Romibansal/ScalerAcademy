package Bit_Manipulation_1;

//Q=Problem Description
//        Given an array of integers A, every element appears twice except for one. Find that integer that occurs once.
//
//        NOTE: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
//
//
//
//        Problem Constraints
//        1 <= |A| <= 2000000
//
//        0 <= A[i] <= INTMAX


public class SingleNumber {
    public int singleNumber(final int[] A) {
        int ans=0;
        for(int i=0;i<A.length;i++){
            ans=ans^A[i];
        }
        return ans;
    }
    public static void main(String args []){
        SingleNumber S1=new SingleNumber();
        int[] B=new int[5];
        B[0]=1;B[1]=2;B[2]=2;B[3]=3;B[4]=1;
        System.out.println( S1.singleNumber(B));
    }
}


