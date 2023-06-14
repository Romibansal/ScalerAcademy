package Advance_Two_Pointers;

import java.util.Arrays;

//Q=Problem Description
//        Given an array A of N integers, find three integers in
//        A such that the sum is closest to a given number B. Return the sum of those three integers.
//
//        Assume that there will only be one solution.
//
//
//
//        Problem Constraints
//        -10^8 <= B <= 10^8
//        1 <= N <= 104
//        -10^8 <= A[i] <= 10^8

public class ThreeSum {
    public int threeSumClosest(int[] A, int B) {
        Arrays.sort(A);
        int current_dis=1000000000;
        int ans=1000000000;
        for(int k=0;k<A.length-2;k++){

            int i=k+1;
            int j=A.length-1;
            while(i<j){
                int sum= A[k]+A[i]+A[j];
                if(Math.abs(B-sum)<current_dis){
                    current_dis=Math.abs(B-sum);
                    ans=sum;
                }
                if(sum>B){
                    j--;
                }
                else{
                    i++;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        ThreeSum I = new ThreeSum();
        int []A=new int[4];
        A[0]=-1;A[1]=2;A[2]=1;A[3]=-4;
        System.out.println(I.threeSumClosest(A,1));
    }
}