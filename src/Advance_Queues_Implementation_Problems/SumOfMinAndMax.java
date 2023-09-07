package Advance_Queues_Implementation_Problems;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

//Q=Problem Description
//        Given an array A of both positive and negative integers.
//
//        Your task is to compute the sum of minimum and maximum elements of all sub-array of size B.
//
//        NOTE: Since the answer can be very large, you are required to return the sum modulo 109 + 7.
//
//
//
//        Problem Constraints
//        1 <= size of array A <= 10^5
//
//        -10^9 <= A[i] <= 10^9
//
//        1 <= B <= size of array



public class SumOfMinAndMax {
    public int solve(int[] A, int B) {
        Deque<Integer> q1=new ArrayDeque<>();
        ArrayList<Integer> max=new ArrayList<>();
        for(int i=0;i<B;i++){
            while(!q1.isEmpty() && q1.peekLast()<A[i]){
                q1.removeLast();
            }
            q1.addLast(A[i]);
        }
        max.add(q1.getFirst());
        int s=0;
        int l=B;
        while(l<A.length){
            if(A[s]==q1.getFirst()){
                q1.removeFirst();
            }
            while(!q1.isEmpty() && q1.peekLast()<A[l]){
                q1.removeLast();
            }
            q1.addLast(A[l]);
            max.add(q1.getFirst());
            l++;s++;
        }

        Deque<Integer> q2=new ArrayDeque<>();
        ArrayList<Integer> min=new ArrayList<>();
        for(int i=0;i<B;i++){
            while(!q2.isEmpty() && q2.peekLast()>A[i]){
                q2.removeLast();
            }
            q2.addLast(A[i]);
        }
        min.add(q2.getFirst());
        int s1=0;
        int l1=B;
        while(l1<A.length){
            if(A[s1]==q2.getFirst()){
                q2.removeFirst();
            }
            while(!q2.isEmpty() && q2.peekLast()>A[l1]){
                q2.removeLast();
            }
            q2.addLast(A[l1]);
            min.add(q2.getFirst());
            l1++;s1++;
        }
        long ans=0;
        int mod=(int)Math.pow(10,9)+7;
        for(int i=0;i< min.size();i++){
            ans=(ans%mod+max.get(i)%mod)%mod;
        }
        for(int i=0;i<min.size();i++){
            ans=(ans%mod+min.get(i)%mod)%mod;
            if(ans<0){
                ans=(ans+mod)%mod;
            }
        }
        return (int)ans%mod;
    }
    public static void main(String[] args) {
        SumOfMinAndMax I = new SumOfMinAndMax();
        int[] A=new int[7];
        A[0]=2;A[1]= 5;A[2]= -1;A[3]= 7;
        A[4]=-3;A[5]=-1;A[6]=-2;
        System.out.println(I.solve(A,4));
    }
}


