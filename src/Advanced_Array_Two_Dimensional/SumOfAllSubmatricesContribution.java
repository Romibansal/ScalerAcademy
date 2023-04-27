package Advanced_Array_Two_Dimensional;
//
//Q=Problem Description
//        Given a 2D Matrix A of dimensions N*N, we need to return the sum of all possible submatrices.
//
//
//
//        Problem Constraints
//        1 <= N <=30
//
//        0 <= A[i][j] <= 10


public class SumOfAllSubmatricesContribution {
    public int solve(int[][] A) {
        int sum=0;
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A.length;j++){
                int left_top=(i+1)*(j+1);
                int right_bottom=(A.length-i)*(A.length-j);
                sum=sum+A[i][j]*(left_top*right_bottom);
            }
        }
        return sum;
    }
    public static void main(String args []){
        SumOfAllSubmatricesContribution R1=new SumOfAllSubmatricesContribution();
        int A[][]=new int[2][2];
        A[0][0]=1;
        A[0][1]=1;
        A[1][0]=1;
        A[1][1]=1;
        System.out.println(R1.solve(A));
    }
}





