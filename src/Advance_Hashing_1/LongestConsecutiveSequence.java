package Advance_Hashing_1;


import java.util.HashSet;

//Q=Problem Description
//        Given an unsorted integer array A of size N.
//
//        Find the length of the longest set of consecutive elements from array A.
//
//        Problem Constraints
//        1 <= N <= 10^6
//
//        -10^6 <= A[i] <= 10^6

public class LongestConsecutiveSequence {
    public int longestConsecutive(final int[] A) {
        HashSet<Integer> set=new HashSet();
        for(int i=0;i<A.length;i++){
            set.add(A[i]);
        }
        int count=1;
        int ans=1;
        for (Integer ele : set) {
            if(set.contains(ele-1)){
                continue;
            }
            if(set.contains(ele+1)) {
                while (set.contains(ele + 1)) {
                    count++;
                    ele = ele + 1;
                }
                ans=Math.max(ans,count);
                count=1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        LongestConsecutiveSequence I = new LongestConsecutiveSequence();
        int []A=new int[6];
        A[0]=100;A[1]=4;A[2]=200;A[3]=1;A[4]=3;
        A[5]=2;
        System.out.println(I.longestConsecutive(A));
    }
}
