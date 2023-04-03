package Hashing_2;

import java.util.HashMap;

//Q=Problem Description
//
//        Given an one-dimensional unsorted array A containing N integers.
//
//        You are also given an integer B, find if there exists a pair of elements in the array whose difference is B.
//
//        Return 1 if any such pair exists else return 0.
//
//        Problem Constraints
//        1 <= N <= 10^5
//        -10^3 <= A[i] <= 10^3
//        -10^5 <= B <= 10^5


public class PairWithGivenDifference {
    public int solve(int[] A, int B) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<A.length;i++){
            int number=B+A[i];
            if(hm.containsKey(number)){
                return 1;
            }
            if(hm.containsKey(A[i])){
                int v=hm.get(A[i]);
                v=v+1;
                hm.put(A[i],v);
            }
            else{
                hm.put(A[i],1);
            }
        }
        HashMap<Integer,Integer> hm1=new HashMap<>();
        for(int j=0;j<A.length;j++){
            int num=A[j]-B;
            if(hm1.containsKey(num)){
                return 1;
            }
            if(hm1.containsKey(A[j])){
                int w=hm1.get(A[j]);
                w=w+1;
                hm1.put(A[j],w);
            }
            else{
                hm1.put(A[j],1);
            }
        }
        return 0;
    }
    public static void main(String args []){
        PairWithGivenDifference N1=new PairWithGivenDifference();
        int [] A=new int[6];
        A[0]=5;A[1]=10;A[2]=3;A[3]=2;A[4]=50;A[5]=80;
        System.out.println( N1.solve(A,78));
    }
}



