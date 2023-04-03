package Hashing_2;

import java.util.HashMap;

//Q=Problem Description
//        Given an array A of N integers.
//
//        Find the length of the longest subarray in the array which sums to zero.
//
//
//        Problem Constraints
//        1 <= N <= 10^5
//        -10^9 <= A[i] <= 10^9


public class LongestSubarrayZeroSum {
    public int solve(int[] A) {
        Long [] ps=new Long [A.length];
        ps[0]=(long)A[0];
        int ans=0;
        for(int i=1;i<A.length;i++){
            ps[i]=A[i]+ps[i-1];
            if(ps[i]==0){
                ans=Math.max(ans,i+1);
            }
        }
        HashMap<Long,Integer> hm=new HashMap<>();
        for(int j=0;j<A.length;j++){
            if(hm.containsKey(ps[j])){
                int start=hm.get(ps[j]);
                int temp=j-start;
                ans=Math.max(temp,ans);
            }
            else{
                hm.put(ps[j],j);
            }
        }
        return ans;
    }
    public static void main(String args []){
        LongestSubarrayZeroSum N1=new LongestSubarrayZeroSum();
        int [] A=new int[4];
        A[0]=1;A[1]=-2;A[2]=1;A[3]=2;
        System.out.println( N1.solve(A));
    }
}



