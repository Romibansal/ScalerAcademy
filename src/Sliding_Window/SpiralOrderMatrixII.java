package Sliding_Window;

//Q=Problem Description
//        Given an integer A, generate a square matrix filled with elements from 1 to A2 in spiral order and
//        return the generated square matrix.
//
//        Problem Constraints
//        1 <= A <= 1000

public class SpiralOrderMatrixII {
    public int[][] generateMatrix(int A) {
        int [][] a=new int [A][A];
        int i=0;
        int j=0;
        int N=A;
        if (N == 1){
            a[0][0]=1;
            return a;
        }

        int element=1;
        while(N>0){
            if (N == 1){
                a[i][j]=element;
            }
            for(int k=0;k<N-1;k++){
                a[i][j]=element;
                element++;
                j++;
            }
            for(int k=0;k<N-1;k++){
                a[i][j]=element;
                element++;
                i++;
            }
            for(int k=0;k<N-1;k++){
                a[i][j]=element;
                element++;
                j--;
            }
            for(int k=0;k<N-1;k++){
                a[i][j]=element;
                element++;
                i--;
            }
            i++;
            j++;
            N=N-2;
        }
        return a;
    }
    public static void main(String args []){
        SpiralOrderMatrixII R1=new SpiralOrderMatrixII();

        System.out.println(R1.generateMatrix(5));
    }
}




