package Hashing_2;

import java.util.HashMap;


//Q=Problem Description
//        You are given an array A of N integers and an integer B.
//        Count the number of pairs (i,j) such that A[i] + A[j] = B and i ≠ j. Since the answer
//        can be very large, return the remainder after dividing the count with 10^9+7.
//
//        Note - The pair (i,j) is same as the pair (j,i) and we need to count it only once.
//
//
//        Problem Constraints
//        1 <= N <= 10^5
//        1 <= A[i] <= 10^9
//        1 <= B <= 10^9

public class CountPairSum {
    public int solve(int[] A, int B) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        long count=0;
        int mod=(int)Math.pow(10,9)+7;
        for(int i=0;i<A.length;i++){
            int number=B-A[i];
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
        return (int)count;
    }
    public static void main(String args []){
        CountPairSum N1=new CountPairSum();
        int [] A=new int[9];
        A[0]=1;A[1]=1;A[2]=16;A[3]=16;A[4]=7;A[5]=7;A[6]=16;A[7]=4;A[8]=19;
        System.out.println( N1.solve(A,5));
    }
}



