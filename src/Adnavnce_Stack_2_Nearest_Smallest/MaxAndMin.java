package Adnavnce_Stack_2_Nearest_Smallest;

import java.util.ArrayList;
import java.util.Stack;

//
//Q=Problem Description
//        Given an array of integers A.
//
//        The value of an array is computed as the difference between the maximum element
//        in the array and the minimum element in the array A.
//
//        Calculate and return the sum of values of all possible subarrays of A modulo 109+7.
//
//
//
//        Problem Constraints
//        1 <= |A| <= 100000
//
//        1 <= A[i] <= 1000000


public class MaxAndMin {
    public int solve(int[] A) {
        int n=A.length;
        int[] nearest_left_max=new int [n];
        Stack <Integer> stk1=new Stack<>();
        for(int i=0;i<n;i++){
            while(!stk1.empty() && A[stk1.peek()]<A[i]){
                stk1.pop();
            }
            if(stk1.empty()){
                nearest_left_max[i]=-1;
            }
            else{
                nearest_left_max[i]=stk1.peek();
            }
            stk1.push(i);
        }
        int[] nearest_right_max=new int [n];
        Stack <Integer> stk2=new Stack<>();
        for(int i=n-1;i>-1;i--){
            while(!stk2.empty() && A[stk2.peek()]<A[i]){
                stk2.pop();
            }
            if(stk2.empty()){
                nearest_right_max[i]=n;
            }
            else{
                nearest_right_max[i]=stk2.peek();
            }
            stk2.push(i);
        }
        int[] nearest_left_min=new int [n];
        Stack <Integer> stk3=new Stack<>();
        for(int i=0;i<n;i++){
            while(!stk3.empty() && A[stk3.peek()]>A[i]){
                stk3.pop();
            }
            if(stk3.empty()){
                nearest_left_min[i]=-1;
            }
            else{
                nearest_left_min[i]=stk3.peek();
            }
            stk3.push(i);
        }
        int[] nearest_right_min=new int [n];
        Stack <Integer> stk4=new Stack<>();
        for(int i=n-1;i>-1;i--){
            while(!stk4.empty() && A[stk4.peek()]>A[i]){
                stk4.pop();
            }
            if(stk4.empty()){
                nearest_right_min[i]=n;
            }
            else{
                nearest_right_min[i]=stk4.peek();
            }
            stk4.push(i);
        }
        long ans=0;
        int mod=(int)Math.pow(10,9)+7;
        for(int i=0;i<n;i++){
            long max=((long)(i-nearest_left_max[i])*(nearest_right_max[i]-i));
            long min=((long)(i-nearest_left_min[i])*(nearest_right_min[i]-i));
            long sub=(((max)%mod-(min)%mod) +mod)%mod;
            ans=(ans%mod+(A[i]*(sub))%mod)%mod;
        }
        return (int)ans%mod;
    }
    public static void main(String[] args) {
        MaxAndMin I = new MaxAndMin();
        int[] A=new int[4];
        A[0]=4;A[1]=7;A[2]=3;A[3]=8;

        System.out.println(I.solve(A));
    }
}
