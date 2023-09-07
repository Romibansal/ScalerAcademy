package Advance_Binary_Search_Problem2;

//Q=Problem Description
//        Given a matrix of integers A of size N x M in which each row is sorted.
//
//        Find and return the overall median of matrix A.
//
//        NOTE: No extra memory is allowed.
//
//        NOTE: Rows are numbered from top to bottom and columns are numbered from left to right.

//        Problem Constraints
//        1 <= N, M <= 10^5
//
//        1 <= N*M <= 10^6
//
//        1 <= A[i] <= 10^9
//
//        N*M is odd

public class MatrixMedian {

    public int lowerBound(int A[], int val){
        int l = 0, h = A.length-1, ans = -1;
        while(l <= h){
            int mid = (h - l) / 2 + l;
            if(A[mid] < val){
                ans = mid;
                l = mid + 1;
            }
            else
                h = mid - 1;
        }
        return ans + 1;
    }
    public int findMedian(int[][] A) {
        int low = 0, high = 1000000000, n = A.length, m = A[0].length;
        int medPos = n * m / 2, ans = -1; // number of elements less than median element
        while(low <= high){
            int mid = (high - low)/2 + low;
            int cnt = 0;
            for(int i = 0; i < n; i++){
                cnt += lowerBound(A[i], mid);
            }
            if(cnt > medPos)
                high = mid - 1;
            else{
                 ans = mid;
                low = mid + 1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        MatrixMedian I = new MatrixMedian();
        int A[][]=new int [3][3];
        A[0][0]=1;A[0][1]=3;A[0][2]=5;
        A[1][0]=2;A[1][1]=6;A[1][2]=9;
        A[2][0]=3;A[2][1]=6;A[2][2]=9;

        System.out.println(I.findMedian(A));
    }
}

