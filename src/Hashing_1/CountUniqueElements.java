package Hashing_1;

import java.util.HashMap;

//Q=Problem Description
//        You are given an array A of N integers. Return the count of elements with frequncy 1 in the given array.
//
//        Problem Constraints
//        1 <= N <= 10^5
//        1 <= A[i] <= 10^9



public class CountUniqueElements {
    public int solve(int[] A) {
        HashMap<Integer,Integer> hm =new HashMap<>();
        for(int i=0;i<A.length;i++){
            if(hm.containsKey(A[i])){
                int v=hm.get(A[i]);
                v=v+1;
                hm.put(A[i],v);
            }
            else{
                hm.put(A[i],1);
            }
        }
        int count=0;
        for(int j=0;j<A.length;j++){
            if(hm.get(A[j])==1){
                count++;
            }
        }
        return count;
    }
    public static void main(String args []){
        CountUniqueElements N1=new CountUniqueElements();
        int A[]=new int[5];
        A[0]=3;
        A[1]=4;A[2]=3;A[3]=6;A[4]=6;
        System.out.println( N1.solve(A));
    }
}

