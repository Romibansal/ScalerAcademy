package Hashing_2;

import java.util.ArrayList;
import java.util.HashMap;

//Q=Problem Description
//        Given an array of positive integers A and an integer B, find and
//        return first continuous subarray which adds to B.
//
//        If the answer does not exist return an array with a single element "-1".
//        First sub-array means the sub-array for which starting index in minimum.
//
//
//
//        Problem Constraints
//        1 <= length of the array <= 100000
//        1 <= A[i] <= 10^9
//        1 <= B <= 10^9




public class SubarrayWithGivenSum {
    public int[] solve(int[] A, int B) {
        int n = A.length;
        long[] p = new long[n];
        p[0] = A[0];
        int start = 0;
        int end = 0;
        for (int i = 1; i < n; i++) {
            p[i] = p[i - 1] + A[i];
            if (p[i] == B) {
                start = 0;
                end = i;
                int[] ans = new  int[i + 1];
                for (int j = start; j <= end; j++) {
                    ans[j - start] = A[j];
                }
                return ans;
            }
        }
        HashMap<Long, Integer> hm1 = new HashMap<>();
        for (int j = 0; j < n; j++) {
            if (hm1.containsKey(p[j] + B)) {
                start = hm1.get(p[j] + B) + 1;
                end = j;
                break;
            }
            else {
                hm1.put(p[j], j);
            }
        }
        if (start != 0 && end != 0) {
            int len = end - start + 1;
            int[] ans = new int[len];
            for (int i = start; i <= end; i++) {
                ans[i - start] = A[i];
            }
            return ans;
        }
        HashMap<Long, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (hm.containsKey(p[i] - B)) {
                start = hm.get(p[i] - B) + 1;
                end = i;
                break;
            }
            else {
                hm.put(p[i], i);
            }
        }
        if (start == 0 && end == 0) {
            int[] ans = new int[1];
            ans[0] = -1;
            return ans;
        }
        int len = end - start + 1;
        int[] ans = new  int[len];
        for (int i = start; i <= end; i++) {
            ans[i - start] = A[i];
        }
        return ans;
    }
    public static void main(String args []){
        SubarrayWithGivenSum N1=new SubarrayWithGivenSum();
        int [] A=new int[5];
        A[0]=1; A[1]=2; A[2]=3; A[3]=4;A[4]=5;

        System.out.println( N1.solve(A,5));
    }
}



