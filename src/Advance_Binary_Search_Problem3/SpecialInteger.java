package Advance_Binary_Search_Problem3;

//Q=Problem Description
//        Given an array of integers A and an integer B,
//        find and return the maximum value K such that there is no subarray in A of size K
//        with the sum of elements greater than B.
//
//        Problem Constraints
//        1 <= |A| <= 100000
//        1 <= A[i] <= 10^9
//
//        1 <= B <= 10^9

public class SpecialInteger {
    boolean check(int[] A,int B,int k){
        long sum=0;
        for(int i=0;i<k;i++){
            sum=sum+A[i];
        }
        if(sum>B){
            return false;
        }
        int j=0;
        for(int i=k;i<A.length;i++){
            sum=sum-A[j];
            sum=sum+A[i];
            if(sum>B){
                return false;
            }
            j++;
        }
        return true;
    }
    public int solve(int[] A, int B) {
        int l=0;
        int r=A.length;
        int ans=1;
        while(l<=r){
            int mid=l+(r-l)/2;
            boolean exist=check(A,B,mid);
            if(exist){
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
        SpecialInteger I = new SpecialInteger();
        int A[]=new int [6];
        A[0] =1;A[1] =2;A[2] =3;
        A[3] =4;A[4] =5;A[5] =100;

        System.out.println(I.solve(A,10));
    }
}



