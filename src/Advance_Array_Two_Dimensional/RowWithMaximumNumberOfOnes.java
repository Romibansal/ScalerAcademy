package Advance_Array_Two_Dimensional;

//Q=Problem Description
//        Given a binary sorted matrix A of size N x N. Find the row with the maximum number of 1.
//
//        NOTE:
//
//        If two rows have the maximum number of 1 then return the row which has a lower index.
//        Rows are numbered from top to bottom and columns are numbered from left to right.
//        Assume 0-based indexing.
//        Assume each row to be sorted by values.
//        Expected time complexity is O(rows + columns).
//
//
//        Problem Constraints
//        1 <= N <= 1000
//
//        0 <= A[i] <= 1



public class RowWithMaximumNumberOfOnes {
    public int solve(int[][] A) {
        int i=0;
        int j=A.length-1;
        int row=0;
        int ans=0;
        while(row<A.length && j>-1){
            if(A[i+row][j]==1){
                j--;
                ans=row;
            }
            else{
                row++;
            }
        }
        return ans;
    }
    public static void main(String args []){
        RowWithMaximumNumberOfOnes R1=new RowWithMaximumNumberOfOnes();
        int A[][]=new int[3][3];
        A[0][0]=0;
        A[0][1]=1;
        A[0][2]=1;
        A[1][0]=0;
        A[1][1]=0;
        A[1][2]=1;
        A[2][0]=0;
        A[2][1]=1;
        A[2][2]=1;
        System.out.println(R1.solve(A));
    }
}


