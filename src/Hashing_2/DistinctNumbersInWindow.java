package Hashing_2;

import java.util.HashMap;

//Q=Problem Description
//        You are given an array of N integers, A1, A2 ,...,
//        AN and an integer B. Return the of count of distinct numbers in all windows of size B.
//
//        Formally, return an array of size N-B+1
//        where i'th element in this array contains number of distinct elements in sequence Ai, Ai+1 ,..., Ai+B-1.
//
//        NOTE: if B > N, return an empty array.
//
//        Input Format
//        First argument is an integer array A
//        Second argument is an integer B.



public class DistinctNumbersInWindow {
    public int[] dNums(int[] A, int B) {
        int ans[]=new int[A.length-B+1];
        HashMap<Integer,Integer> hm =new HashMap<>();
        for(int i=0;i<B;i++){
            if(hm.containsKey(A[i])){
                int v=hm.get(A[i]);
                v=v+1;
                hm.put(A[i],v);
            }
            else{
                hm.put(A[i],1);
            }
        }
        ans[0]=hm.size();
        for(int j=1;j<=A.length-B;j++){
            if(hm.containsKey(A[B+j-1])){
                int w=hm.get(A[B+j-1]);
                w=w+1;
                hm.put(A[B+j-1],w);
            }
            else{
                hm.put(A[B+j-1],1);
            }
            if(hm.get(A[j-1])==1){
                hm.remove(A[j-1]);
            }
            else{
                int t=hm.get(A[j-1]);
                t=t-1;
                hm.put(A[j-1],t);
            }
            ans[j]=hm.size();
        }
        return ans;
    }
    public static void main(String args []){
        DistinctNumbersInWindow N1=new DistinctNumbersInWindow();
        int [] A=new int[6];
        A[0]=1; A[1]=2; A[2]=1; A[3]=3;A[4]=4;A[5]=3;
        System.out.println( N1.dNums(A,3));
    }
}

