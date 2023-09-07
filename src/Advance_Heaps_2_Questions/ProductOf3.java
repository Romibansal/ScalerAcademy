package Advance_Heaps_2_Questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

//Q=Problem Description
//        Given an integer array A of size N.
//
//        You have to find the product of the three largest integers in array A from range 1 to i,
//        where i goes from 1 to N.
//
//        Return an array B where B[i] is the product of the largest 3 integers in range 1 to i
//        in array A. If i < 3, then the integer at index i in B should be -1.
//
//
//
//        Problem Constraints
//        1 <= N <= 10^5
//        0 <= A[i] <= 10^3
//
//
//
//        Input Format
//        First and only argument is an integer array A.
//
//
//
//        Output Format
//        Return an integer array B. B[i] denotes the product of the largest 3 integers in range 1 to i in array A.
//
//
//
//        Example Input

//        Input 1:
//
//        A = [1, 2, 3, 4, 5]

//        Input 2:
//
//        A = [10, 2, 13, 4]
//
//
//        Example Output

//        Output 1:
//
//        [-1, -1, 6, 24, 60]

//        Output 2:
//
//        [-1, -1, 260, 520]
//
//
//        Example Explanation

//        Explanation 1:
//
//        For i = 1, ans = -1
//        For i = 2, ans = -1
//        For i = 3, ans = 1 * 2 * 3 = 6
//        For i = 4, ans = 2 * 3 * 4 = 24
//        For i = 5, ans = 3 * 4 * 5 = 60
//
//        So, the output is [-1, -1, 6, 24, 60].
//
//        Explanation 2:
//
//        For i = 1, ans = -1
//        For i = 2, ans = -1
//        For i = 3, ans = 10 * 2 * 13 = 260
//        For i = 4, ans = 10 * 13 * 4 = 520
//
//        So, the output is [-1, -1, 260, 520].



public class ProductOf3 {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        int n = A.size();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add( -1);ans.add( -1);
        int mul=1;

        for(int i=0;i<3;i++){
            pq.add(A.get(i));
            mul=mul*A.get(i);
        }
        ans.add(mul);
        for(int i = 3; i<n; i++){
            pq.add(A.get(i));
            int p1 = pq.remove();
            int p2 = pq.remove();
            int p3 = pq.remove();
            ans.add(p1*p2*p3);
            pq.add(p1);
            pq.add(p2);
            pq.add(p3);
        }
        return ans;
    }
    public static void main(String[] args) {
        ProductOf3 I = new ProductOf3();
        ArrayList<Integer>A=new ArrayList<>();
        A.add(10);A.add( 4);A.add( 3);A.add( 0);

        System.out.println( I.solve(A));
    }
}


