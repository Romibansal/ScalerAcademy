package Advance_Graph_4_Floyd_Warshall_And_Graph_Colouring;

import java.util.LinkedList;
import java.util.Queue;

//Q=Problem Description

//        Given a matrix of integers A of size N x M consisting of 0 or 1.
//
//        For each cell of the matrix find the distance of nearest 1 in the matrix.
//
//        Distance between two cells (x1, y1) and (x2, y2) is defined as |x1 - x2| + |y1 - y2|.
//
//        Find and return a matrix B of size N x M which defines for each cell in A distance of nearest 1
//        in the matrix A.
//
//        NOTE: There is atleast one 1 is present in the matrix.
//
//
//
//        Problem Constraints

//        1 <= N, M <= 1000
//
//        0 <= A[i][j] <= 1
//
//
//
//        Input Format

//        The first argument given is the integer matrix A.
//
//
//
//        Output Format

//        Return the matrix B.
//
//
//
//        Example Input

//        Input 1:
//
//        A = [
//        [0, 0, 0, 1]
//        [0, 0, 1, 1]
//        [0, 1, 1, 0]
//        ]

//        Input 2:
//
//        A = [
//        [1, 0, 0]
//        [0, 0, 0]
//        [0, 0, 0]
//        ]
//
//
//        Example Output

//        Output 1:
//
//        [
//        [3, 2, 1, 0]
//        [2, 1, 0, 0]
//        [1, 0, 0, 1]
//        ]

//        Output 2:
//
//        [
//        [0, 1, 2]
//        [1, 2, 3]
//        [2, 3, 4]
//        ]
//
//
//        Example Explanation

//        Explanation 1:
//
//        A[0][0], A[0][1], A[0][2] will be nearest to A[0][3].
//        A[1][0], A[1][1] will be nearest to A[1][2].
//        A[2][0] will be nearest to A[2][1] and A[2][3] will be nearest to A[2][2].

//        Explanation 2:
//
//        There is only a single 1. Fill the distance from that 1.


public class DistanceOfNearestCell {
    class Triplet {
        int row, column, distance;
        Triplet(int r, int c, int d) {
            row = r;
            column = c;
            distance = d;
        }
    }
     boolean checkValidity(int row, int col, int n, int m, int[][] A) {
        if (row < 0 || col < 0 || row >= n || col >= m || A[row][col] == 1) {
            return false;
        }
        return true;
    }
    public int[][] solve(int[][] A) {
        int x[]=new int[]{-1,1,0,0};
        int y[]=new int[]{0,0,-1,1};
        int n = A.length, m = A[0].length;
        int ans[][] = new int[n][m];
        Queue < Triplet > queue = new LinkedList < > ();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j] == 1) queue.add(new Triplet(i, j, 0));
            }
        }
        while (!queue.isEmpty()) {
            Triplet poll = queue.poll();
            int col = poll.column, row = poll.row, d = poll.distance;
            ans[row][col] = d;
            for (int i = 0; i < 4; i++) {
                if (checkValidity(row + y[i], col + x[i], n, m, A)) {
                    A[row + y[i]][col + x[i]] = 1;
                    queue.add(new Triplet(row + y[i], col + x[i], d + 1));
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        DistanceOfNearestCell I = new DistanceOfNearestCell();

        int[][]B=new int[3][4];
        B[0][0]=0;B[0][1]=0;B[0][2]=0;B[0][3]=1;
        B[1][0]=0;B[1][1]=0;B[1][2]=1;B[1][3]=1;
        B[2][0]=0;B[2][1]=1;B[2][2]=1;B[2][3]=0;
        System.out.println( I.solve(B));
    }
}



