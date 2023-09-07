package Advance_Graph_4_Floyd_Warshall_And_Graph_Colouring;

//Q=Problem Description
//        Given a matrix of integers A of size N x N, where A[i][j] represents the weight of
//        directed edge from i to j (i ---> j).
//
//        If i == j, A[i][j] = 0, and if there is no directed edge from vertex i to vertex j, A[i][j] = -1.
//
//        Return a matrix B of size N x N where B[i][j] = shortest path from vertex i to vertex j.
//
//        If there is no possible path from vertex i to vertex j , B[i][j] = -1
//
//        Note: Rows are numbered from top to bottom and columns are numbered from left to right.
//
//
//
//        Problem Constraints

//        1 <= N <= 200
//        -1 <= A[i][j] <= 1000000
//
//
//        Input Format

//        The first and only argument given is the integer matrix A.
//
//
//        Output Format

//        Return a matrix B of size N x N where B[i][j] = shortest path from vertex i to vertex j
//        If there is no possible path from vertex i to vertex j, B[i][j] = -1.
//
//
//        Example Input

//        A = [ [0 , 50 , 39]
//        [-1 , 0 , 1]
//        [-1 , 10 , 0] ]
//
//
//        Example Output

//        [ [0 , 49 , 39 ]
//        [-1 , 0 , -1 ]
//        [-1 , 10 , 0 ] ]

public class FloydWarshallAlgorithm {
    public int[][] solve(int[][] A) {
        int n =A.length;
        for(int k=0;k<n;k++)
        {
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    if(A[i][k]==-1 || A[k][j]==-1){
                        continue;
                    }
                    if(A[i][j]==-1 || A[i][j]>A[i][k]+A[k][j]){
                        A[i][j]=A[i][k]+A[k][j];
                    }
                }
            }
        }
        return A;
    }
    public static void main(String[] args) {
        FloydWarshallAlgorithm I = new FloydWarshallAlgorithm();

        int[][]B=new int[3][3];
        B[0][0]=0;B[0][1]=50;B[0][2]=39;
        B[1][0]=-1;B[1][1]=0;B[1][2]=1;
        B[2][0]=-1;B[2][1]=10;B[2][2]=0;
        System.out.println( I.solve(B));
    }
}

