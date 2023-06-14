package Advance_Binary_Search_On_Array;

//Q=Problem Description
//        Given a matrix of integers A of size N x M and an integer B.
//        Write an efficient algorithm that searches for integer B in matrix A.
//
//        This matrix A has the following properties:
//
//        Integers in each row are sorted from left to right.
//        The first integer of each row is greater than or equal to the last integer of the previous row.
//        Return 1 if B is present in A, else return 0.
//
//        NOTE: Rows are numbered from top to bottom, and columns are from left to right.
//
//
//
//        Problem Constraints
//        1 <= N, M <= 1000
//        1 <= A[i][j], B <= 10^6

public class MatrixSearch {
    public int searchMatrix(int[][] A, int B) {
        int st=0;
        int l=(A.length*A[0].length)-1;
        while(st<=l){
            int mid=st+(l-st)/2;
            int r=mid/A[0].length;
            int c=mid%A[0].length;
            if(A[r][c]==B){
                return 1;
            }
            if(A[r][c]<B){
                st=mid+1;
            }
            else{
                l=mid-1;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        MatrixSearch I = new MatrixSearch();
        int A[][]=new int[3][4];
        A[0][0]=1;A[0][1]=3;A[0][2]=5;A[0][3]=7;
        A[1][0]= 10;A[1][1]=11;A[1][2]= 16;A[1][3]= 20;
        A[2][0]= 23;A[2][1]=30;A[2][2]= 34;A[2][3]= 50;

        System.out.println(I.searchMatrix(A,3));
    }
}
