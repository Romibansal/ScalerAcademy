package Arrays_2D_Matrices;

//Q=Problem Description
//        You are given a 2D integer matrix A, make all the elements in a row or column zero if the A[i][j] = 0.
//        Specifically, make entire ith row and jth column zero.
//
//        Problem Constraints
//        1 <= A.size() <= 10^3
//
//        1 <= A[i].size() <= 10^3
//
//        0 <= A[i][j] <= 10^3



public class RowToColumnZero {
    public int[][] solve(int[][] A)  {
        int n=A.length;
        int[][] a=new int[n][n];
        for(int i=0;i<n;i++){
            int flag=0;
            for(int j=0;j<n;j++){
                if(A[i][j]==0){
                    for(int k=0;k<n;k++){
                        a[i][k]=0;
                        flag=1;
                    }
                }
                if(flag==1){
                    break;
                }
                else if(A[i][j]!=0){
                    a[i][j]=A[i][j];
                }
            }
        }
        for(int j=0;j<n;j++){
            for(int i=0;i<n;i++){
                if(A[i][j]==0){
                    for(int k=0;k<n;k++){
                        a[k][j]=0;
                    }
                }
                else  if(A[i][j]!=0){
                    if(a[i][j]!=0) {
                        a[i][j] = A[i][j];
                    }
                }
            }
        }
        return a;
    }
    public static void main(String args []){
        RowToColumnZero R1=new RowToColumnZero();
        int[][] A=new int[10][10];
        A[0][0]=97;A[0][1]=18;A[0][2]=55;A[0][3]=1;A[0][4]=50;A[0][5]=17;A[0][6]=16;A[0][7]=0;A[0][8]=22;A[0][9]=14;
        A[1][0]=58;A[1][1]=14;A[1][2]=75;A[1][3]=54;A[1][4]=11;A[1][5]=23;A[1][6]=54;A[1][7]=95;A[1][8]=33;A[1][9]=23;
        A[2][0]=73;A[2][1]=11;A[2][2]=2;A[2][3]=80;A[2][4]=6;A[2][5]=43;A[2][6]=67;A[2][7]=82;A[2][8]=73;A[2][9]=4;
        A[3][0]=61;A[3][1]=22;A[3][2]=23;A[3][3]=68;A[3][4]=23;A[3][5]=73;A[3][6]=85;A[3][7]=91;A[3][8]=25;A[3][9]=7;
        A[4][0]=6;A[4][1]=83;A[4][2]=22;A[4][3]=81;A[4][4]=89;A[4][5]=85;A[4][6]=56;A[4][7]=43;A[4][8]=32;A[4][9]=89;
        A[5][0]=0;A[5][1]=6;A[5][2]=1;A[5][3]=69;A[5][4]=86;A[5][5]=7;A[5][6]=64;A[5][7]=5;A[5][8]=90;A[5][9]=37;
        A[6][0]=10;A[6][1]=3;A[6][2]=11;A[6][3]=33;A[6][4]=71;A[6][5]=86;A[6][6]=6;A[6][7]=56;A[6][8]=78;A[6][9]=31;
        A[7][0]=16;A[7][1]=36;A[7][2]=66;A[7][3]=90;A[7][4]=17;A[7][5]=55;A[7][6]=27;A[7][7]=26;A[7][8]=99;A[7][9]=59;
        A[8][0]=67;A[8][1]=18;A[8][2]=65;A[8][3]=68;A[8][4]=87;A[8][5]=3;A[8][6]=28;A[8][7]=52;A[8][8]=9;A[8][9]=70;
        A[9][0]=41;A[9][1]=19;A[9][2]=73;A[9][3]=5;A[9][4]=52;A[9][5]=96;A[9][6]=91;A[9][7]=10;A[9][8]=52;A[9][9]=21;


        R1.solve(A);
    }
}



