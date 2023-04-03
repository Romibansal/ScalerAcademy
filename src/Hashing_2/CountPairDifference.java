package Hashing_2;

import java.util.HashMap;

//Q=Count Pair Difference
//        character backgroundcharacter
//        Stuck somewhere?
//        Use any given hint and get it resolved
//        Use Hint.
//        Problem Description
//        You are given an array A of N integers and an integer B.
//        Count the number of pairs (i,j) such that A[i] - A[j] = B and i ≠ j.
//        Since the answer can be very large, return the remainder after dividing the count with 109+7.
//
//
//        Problem Constraints
//        1 <= N <= 10^5
//        1 <= A[i] <= 10^9
//        1 <= B <= 10^9

public class CountPairDifference {
    public int solve(int[] A, int B) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        long count=0;
        int mod=(int)Math.pow(10,9)+7;
        for(int i=0;i<A.length;i++){
            int number=B+A[i];
            if(hm.containsKey(number)){
                count=(count+hm.get(number))%mod;
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
                count=(count+(hm1.get(num))%mod)%mod;
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
        return (int)count;
    }
    public static void main(String args []){
        CountPairDifference N1=new CountPairDifference();
        int [] A=new int[4];
        A[0]=1;A[1]=2;A[2]=1;A[3]=2;
        System.out.println( N1.solve(A,1));
    }
}


