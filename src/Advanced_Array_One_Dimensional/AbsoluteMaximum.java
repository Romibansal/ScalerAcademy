package Advanced_Array_One_Dimensional;

//Q=Problem Description
//        Given 4 array of integers A, B, C and D of same size, find and
//        return the maximum value of | A [ i ] - A [ j ] | +
//        | B [ i ] - B [ j ] | + | C [ i ] - C [ j ] | + | D [ i ] - D [ j ] | + | i - j|
//        where i != j and |x| denotes the absolute value of x.
//
//
//
//        Problem Constraints
//        2 <= length of the array A, B, C, D <= 100000
//        -10^6 <= A[i] <= 10^6

public class AbsoluteMaximum {
    public int solve(int[] A, int[] B, int[] C, int[] D) {
        int ans=-2147483648;
        int number=15;
        for(int j=0;j<16;j++){
            int max=-2147483648;
            int min=2147483647;
            int d=number;
            int sign_d=1;
            int sign_c=1;
            int sign_b=1;
            int sign_a=1;
            if(d%2==0){
                sign_d=-1;
            }
            d=d>>1;
            if(d%2==0){
                sign_c=-1;
            }
            d=d>>1;
            if(d%2==0){
                sign_b=-1;
            }
            d=d>>1;
            if(d%2==0){
                sign_a=-1;
            }
            for(int i=0;i<A.length;i++){
                int temp= ((sign_a*A[i])+(sign_b*B[i])+(sign_c*C[i])+(sign_d*D[i])-i);
                if(max<temp){
                    max=temp;
                }
                if(temp<min){
                    min=temp;
                }
                if((max-min)>ans){
                    ans=(max-min);
                }
            }
            number=number-1;
        }
        return ans;
    }

    public static void main(String args []){
        AbsoluteMaximum R1=new AbsoluteMaximum();
        int A[] = new int[4];
        A[0]=1;A[1]= 2;A[2]= 3;A[3]= 4;
        int B[] = new int[4];
        B[0]=-1;B[1]= 4;B[2]= 5;B[3]= 6;
        int C[] = new int[4];
        C[0]=-10;C[1]= 5;C[2]= 3;C[3]= -8;
        int D[] = new int[4];
        D[0]=-1;D[1]= -9;D[2]= -6;D[3]= -10;
        System.out.println(R1.solve(A,B,C,D));
    }
}
