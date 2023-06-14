package Advance_Binary_Search_Problem3;

import java.util.Arrays;

//Q=Problem Description
//        Farmer John has built a new long barn with N stalls.
//        Given an array of integers A of size N where each element of the array represents
//        the location of the stall and an integer B which represents the number of cows.
//
//        His cows don't like this barn layout and become aggressive
//        towards each other once put into a stall. To prevent the cows from
//        hurting each other, John wants to assign the cows to the stalls, such that
//        the minimum distance between any two of them is as large as possible.
//        What is the largest minimum distance?

//        Problem Constraints
//        2 <= N <= 100000
//        0 <= A[i] <= 10^9
//        2 <= B <= N

public class AggressiveCows {
    int numberofcows(int[] A,int d){
        int count=1;
        int last=A[0];
        for(int i=1;i<A.length;i++){
            if((A[i]-last)>=d){
                count++;
                last=A[i];
            }
        }
        return count;
    }
    public int solve(int[] A, int B) {
        Arrays.sort(A);
        int l=0;
        int r=A[A.length-1]-A[0];
        int ans=0;
        while(l<=r){
            int mid=l+(r-l)/2;
            int cows=numberofcows(A,mid);

            if(cows>=B){
                ans=mid;
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        AggressiveCows I = new AggressiveCows();
        int A[]=new int [4];
        A[0] =5;A[1] = 17;A[2] =100;A[3] = 11;
        System.out.println(I.solve(A,2));
    }
}

