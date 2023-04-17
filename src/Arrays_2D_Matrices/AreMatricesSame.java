package Arrays_2D_Matrices;

//Q=Problem Description
//        You are given two matrices A & B of equal dimensions and you have to check whether two matrices are equal or not.
//
//        NOTE: Both matrices are equal if A[i][j] == B[i][j] for all i and j in the given range.
//
//        Problem Constraints
//        1 <= A.size(), B.size() <= 1000
//        1 <= A[i].size(), B[i].size() <= 1000
//        1 <= A[i][j], B[i][j] <= 1000

public class AreMatricesSame {
    public int solve(int[][] A, int[][] B) {
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A[i].length;j++){
                if(A[i][j]!=B[i][j]){
                    return 0;
                }
            }
        }
        return 1;
    }
    public static void main(String args []){
        AreMatricesSame R1=new AreMatricesSame();
        int[][] A=new int[3][3];
        A[0][0]=1;
        A[0][1]=2;
        A[0][2]=3;
        A[1][0]=5;
        A[1][1]=6;
        A[1][2]=7;
        A[2][0]=9;
        A[2][1]=2;
        A[2][2]=3;
        int[][] B=new int[3][3];
        B[0][0]=1;
        B[0][1]=2;
        B[0][2]=3;
        B[1][0]=5;
        B[1][1]=6;
        B[1][2]=7;
        B[2][0]=9;
        B[2][1]=2;
        B[2][2]=3;
        System.out.println(R1.solve(A,B));
    }
}




