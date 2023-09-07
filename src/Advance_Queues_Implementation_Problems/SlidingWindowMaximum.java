package Advance_Queues_Implementation_Problems;


import java.util.ArrayDeque;
import java.util.Deque;


//Q=Problem Description
//        Given an array of integers A. There is a sliding window of size B,
//        moving from the very left of the array to the very right. You can only see the B numbers in the window.
//        Each time the sliding window moves rightwards by one position. You have to find the maximum
//        for each window.
//
//        Return an array C, where C[i] is the maximum value in the array from A[i] to A[i+B-1].
//
//        Refer to the given example for clarity.
//
//        NOTE: If B > length of the array, return 1 element with the max of the array.
//
//
//
//        Problem Constraints
//        1 <= |A|, B <= 10^6


public class SlidingWindowMaximum {
    public int[] slidingMaximum(final int[] A, int B) {
        int size = (A.length - B) + 1;
        int[] array = new int[size];
        Deque<Integer> q = new ArrayDeque<>();
        int j = 0;
        for (int i = 0; i < B; i++) {
            while (!q.isEmpty() && A[i] >q.peekLast()) {
                q.removeLast();
            }
            q.addLast(A[i]);
        }
        array[j] = q.getFirst();
        j++;
        int k=0;
        for (int i = B; i < A.length; i++) {
            int eletoDel = A[k];
            if (q.peekFirst() == eletoDel) {
                q.removeFirst();
            }
            while (!q.isEmpty() && q.peekLast()<A[i]) {
                q.removeLast();
            }
            q.addLast(A[i]);
            array[j] = q.getFirst();
            j++;
            k++;
        }
        return array;
    }
    public static void main(String[] args) {
        SlidingWindowMaximum I = new SlidingWindowMaximum();
        int[] A=new int[9];
        A[0]=1;A[1]= 8;A[2]= 5;A[3]= 6;
        A[4]=7;A[5]=4;A[6]=2;A[7]=0;A[8]=3;
        System.out.println(I.slidingMaximum(A,4));
    }
}


