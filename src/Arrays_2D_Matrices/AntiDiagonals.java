package Arrays_2D_Matrices;

public class AntiDiagonals {
    public int[][] diagonal(int[][] A) {
        int n=A.length;
        int r=(2*n)-1;
        int col=n;
        int a[][]=new int[r][col];
        for(int c=0;c<(A[0].length);c++){
            int i=0;
            int j=c;
            while(i<A.length && j>-1){
                a[c][i]=A[i][j];
                i++;j--;
            }
        }
        for(int t=1;t<(A.length);t++){
            int s=t;
            int y=0;
            int q=A[0].length-1;
            while(s<A.length && q>-1){
                a[A.length-1+t][y]=A[s][q];
                s++;q--;y++;
            }
        }
        return a;
    }
    public static void main(String args []){
        AntiDiagonals R1=new AntiDiagonals();
        int[][] A=new int[3][3];
        A[0][0]=1;
        A[0][1]=2;
        A[0][2]=3;
        A[1][0]=4;
        A[1][1]=5;
        A[1][2]=6;
        A[2][0]=7;
        A[2][1]=8;
        A[2][2]=9;


        R1.diagonal(A);
    }
}
