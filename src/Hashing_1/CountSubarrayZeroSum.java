package Hashing_1;

import java.util.HashMap;

//Q=Problem Description
//        Given an array A of N integers.
//
//        Find the count of the subarrays in the array which sums to zero.
//        Since the answer can be very large, return the remainder on dividing the result with 109+7
//
//
//        Problem Constraints
//        1 <= N <= 10^5
//        -109 <= A[i] <= 10^9



public class CountSubarrayZeroSum {
    public int solve(int[] A) {
        long count=0;
        int mod=1000000007;
        HashMap<Long,Integer> map=new HashMap<>();
        long []ps=new long[A.length];
        ps[0]=A[0];
        if(ps[0]==0){
            count++;
        }
        for(int i=1;i<A.length;i++){
            ps[i]=(A[i]+ps[i-1]);
            if(ps[i]==0){
                count++;
            }
        }
        for(int i=0;i<ps.length;i++){
            if(map.containsKey(ps[i])){
                count=(count%mod+(map.get(ps[i]))%mod)%mod;
                map.put(ps[i],map.get(ps[i])+1);
            }
            else{
                map.put(ps[i],1);
            }
        }
        return (int)count;
    }
    public static void main(String args []){
        CountSubarrayZeroSum N1=new CountSubarrayZeroSum();
        int [] A=new int[6];
        A[0]=30; A[1]=-30; A[2]=30; A[3]=-30;A[4]=30;A[5]=-30;
        System.out.println( N1.solve(A));
    }
}

