package Advance_Heaps_2_Questions;

import java.util.ArrayList;
import java.util.PriorityQueue;
//
//Q=Problem Description
//        Given a sorted matrix of integers A of size N x M and an integer B.
//
//        Each of the rows and columns of matrix A is sorted in ascending order,
//        find the Bth smallest element in the matrix.
//
//        NOTE: Return The Bth smallest element in the sorted order, not the Bth distinct element.
//
//
//
//        Problem Constraints
//        1 <= N, M <= 500
//
//        1 <= A[i] <= 10^9
//
//        1 <= B <= N * M
//
//
//
//        Input Format
//        The first argument given is the integer matrix A.
//        The second argument given is an integer B.
//
//
//
//        Output Format
//        Return the B-th smallest element in the matrix.
//
//
//
//        Example Input

//        Input 1:
//
//        A = [ [9, 11, 15],
//        [10, 15, 17] ]
//        B = 6

//        Input 2:
//
//        A = [  [5, 9, 11],
//        [9, 11, 13],
//        [10, 12, 15],
//        [13, 14, 16],
//        [16, 20, 21] ]

//        B = 12
//
//
//        Example Output

//        Output 1:
//
//        17

//        Output 2:
//
//        16
//
//
//        Example Explanation

//        Explanation 1:
//
//        6th smallest element in the sorted matrix is 17.

//        Explanation 2:
//
//        12th smallest element in the sorted matrix is 16.

public class KthSmallestElementInASortedMatrix {
    public int solve(ArrayList<ArrayList<Integer>> A, int B) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<A.size();i++){
            for(int j=0;j<A.get(i).size();j++){
                pq.add(A.get(i).get(j));
            }
        }
        for(int i=0;i<B-1;i++){
            pq.poll();
        }
        return pq.peek();
    }
    public static void main(String[] args) {
        KthSmallestElementInASortedMatrix I = new KthSmallestElementInASortedMatrix();
        ArrayList<ArrayList<Integer>>A=new ArrayList<>();
        ArrayList<Integer>a1=new ArrayList<>();
        a1.add(9);a1.add(11);a1.add(15);
        ArrayList<Integer>a2=new ArrayList<>();
        a2.add(10);a2.add(15);a2.add(17);
        A.add(a1);A.add(a2);
        System.out.println( I.solve(A,6));
    }
}


