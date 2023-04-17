package Arrays_2D_Matrices;

//Q=Problem Description
//        You are given a n x n 2D matrix A representing an image.
//
//        Rotate the image by 90 degrees (clockwise).
//
//        You need to do this in place.
//
//        Note: If you end up using an additional array, you will only receive partial score.
//
//
//
//        Problem Constraints
//        1 <= n <= 1000

public class RotateMatrix {
    public void solve(int[][] A) {
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A.length;j++){
                if(i<j){
                    int temp=A[i][j];
                    A[i][j]=A[j][i];
                    A[j][i]=temp;
                }
            }
        }
        for(int i=0;i<A.length;i++){
            int n=(A[i].length/2);
            int l=A[i].length;
            for(int k=0;k<n;k++){
                int temp=A[i][k];
                A[i][k]=A[i][l-1-k];
                A[i][l-1-k]=temp;
            }
        }
    }
    public static void main(String args []){
        RotateMatrix R1=new RotateMatrix();
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
        R1.solve(A);
    }
}




