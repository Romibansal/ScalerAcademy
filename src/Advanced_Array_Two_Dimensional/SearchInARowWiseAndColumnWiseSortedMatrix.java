package Advanced_Array_Two_Dimensional;

//Q=Problem Description
//        Given a matrix of integers A of size N x M and an integer B.
//        In the given matrix every row and column is sorted in non-decreasing order.
//        Find and return the position of B in the matrix in the given form:
//        If A[i][j] = B then return (i * 1009 + j)
//        If B is not present return -1.
//
//        Note 1: Rows are numbered from top to bottom and columns are numbered from left to right.
//        Note 2: If there are multiple B in A then return the smallest value of i*1009 +j such that A[i][j]=B.
//        Note 3: Expected time complexity is linear
//        Note 4: Use 1-based indexing
//
//
//        Problem Constraints
//        1 <= N, M <= 1000
//        -100000 <= A[i] <= 100000
//        -100000 <= B <= 100000


public class SearchInARowWiseAndColumnWiseSortedMatrix {
    public int solve(int[][] A, int B) {
        int N=A.length;
        int M=A[0].length;
        int i=0;
        int j=M-1;
        int ans=2147483647;
        while(i<N && j>-1){
            int start= A[i][j];
            if(start>B){
                j--;
            }
            else if(start<B){
                i++;
            }
            else if(start==B){
                int temp=((i+1)*1009)+j+1;
                ans=Math.min(ans,temp);
                j--;
            }
        }
        if(ans==2147483647){
            return -1;
        }
        return ans;
    }
    public static void main(String args []){
        SearchInARowWiseAndColumnWiseSortedMatrix R1=new SearchInARowWiseAndColumnWiseSortedMatrix();
        int A[][]=new int[3][3];
        A[0][0]=1;
        A[0][1]=2;
        A[0][2]=3;
        A[1][0]=4;
        A[1][1]=5;
        A[1][2]=6;
        A[2][0]=7;
        A[2][1]=8;
        A[2][2]=9;
        System.out.println(R1.solve(A,2));
    }
}




