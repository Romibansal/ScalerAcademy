package Advance_Two_Pointers;

//Q=Problem Description
//        Given a binary array A, find the maximum sequence of
//        continuous 1's that can be formed by replacing at-most B zeroes.
//
//        For this problem, return the indices of maximum continuous series of 1s in order.
//
//        If there are multiple possible solutions, return the sequence which has the minimum start index.
//
//        Problem Constraints
//        0 <= B <= 10^5
//        1 <= size(A) <= 10^5
//        0 <= A[i] <= 1

public class MaxContinuousSeriesof1s {
    public int[] maxone(int[] A, int B) {
        int i=0;
        int j=0;
        int count_zero=0;
        int ans1=0;
        int l=-1;
        int r=-1;
        while(j<A.length){
           if(A[j]==0){
               count_zero++;
           }
           if(count_zero>B){
               while(count_zero>B){
                   if(A[i]==0){
                       count_zero--;
                   }
                   i++;
               }
           }
           if((ans1)<(j-i+1)){
               ans1=j-i+1;
               l=i;
               r=j;
           }
           j++;
        }

        int[] ans=new int[ans1];
        int o=0;
        for(int k=l;k<=r;k++){
            ans[o]=k;
            o++;
        }
        return ans;
    }
    public static void main(String[] args) {
        MaxContinuousSeriesof1s I = new MaxContinuousSeriesof1s();
        int []A=new int[5];
        A[0]=0;A[1]=0;A[2]=0;A[3]=0;A[4]=1;
       // A[5]=0;A[6]=0;A[7]=1;A[8]=1;A[9]=1;
        System.out.println(I.maxone(A,0));
    }
}