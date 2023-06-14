package Advance_Two_Pointers;

import java.util.Arrays;

//Q=Problem Description
//        Given an one-dimensional integer array A of size N and an integer B.
//
//        Count all distinct pairs with difference equal to B.
//
//        Here a pair is defined as an integer pair (x, y),
//        where x and y are both numbers in the array and their absolute difference is B.
//
//
//
//        Problem Constraints
//        1 <= N <= 10^4
//
//        0 <= A[i], B <= 10^5


public class PairsWithGivenDifference {
    public int solve(int[] A, int B) {
        int n = A.length;
        Arrays.sort(A);
        int i = 0;
        int j = 1;
        int count = 0;
        while (j < n) {
            int diff = A[j] - A[i];
            if (diff == B) {
                count++;
                int x = A[i];
                int y = A[j];
                while (i < n && A[i] == x) {
                    i++;
                }
                while (j < n && A[j] == y) {
                    j++;
                }
            }
            else if (diff > B) {
                i++;
                if(i==j){
                    j++;
                }

            }
            else {
                j++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        PairsWithGivenDifference I = new PairsWithGivenDifference();
        int []A=new int[2];
        A[0]=1;A[1]=2;
        System.out.println(I.solve(A,0));
    }
}
