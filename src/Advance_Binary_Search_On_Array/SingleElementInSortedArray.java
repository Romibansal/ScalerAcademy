package Advance_Binary_Search_On_Array;

//Q=Problem Description
//        Given a sorted array of integers A where every element appears twice except for
//        one element which appears once, find and return this single element that appears only once.
//
//        Elements which are appearing twice are adjacent to each other.
//
//        NOTE: Users are expected to solve this in O(log(N)) time.
//
//
//
//        Problem Constraints
//        1 <= |A| <= 100000
//
//        1 <= A[i] <= 10^9

public class SingleElementInSortedArray {
    public int solve(int[] A) {
        int n = A.length;

        // return A[0] if array length is 1
        if (n == 1) {
            return A[0];
        }

        // return A[0] when A[0] is single element
        if (A[0] != A[1]) {
            return A[0];
        }

        // return A[n-1] when A[n-1] is not equal to A[n-2]
        if (A[n - 1] != A[n - 2]) {
            return A[n - 1]; // array last element
        }

        int lo = 0, mid = 0, hi = n - 1;

        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;

            // return A[mid] when it is single element
            if (A[mid] != A[mid + 1] && A[mid] != A[mid - 1]) {
                return A[mid];
            } else if (mid != n - 1 && A[mid] == A[mid + 1] && mid % 2 == 0) {
                // A[mid] is first value in the pair, and the array index is mid and mid is even number. so go on right.
                lo = mid + 1;
            } else if (mid != 0 && A[mid - 1] == A[mid] && ((mid - 1) % 2 == 0)) {
                // A[mid-1] is first value in the pair, and the array index is mid-1 and mid-1 is even number. so go on right.
                lo = mid + 1;
            } else {
                // the array index of the first value in the pair is odd number. so go on left.
                hi = mid - 1;
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        SingleElementInSortedArray I = new SingleElementInSortedArray();
        int A[]=new int[3];
        A[0]=1;A[1]=1;A[2]=7;
        System.out.println(I.solve(A));
    }
}
