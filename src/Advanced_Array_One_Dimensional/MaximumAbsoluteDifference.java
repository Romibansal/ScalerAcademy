package Advanced_Array_One_Dimensional;

//Q=Problem Description
//        You are given an array of N integers, A1, A2, .... AN.
//
//        Return the maximum value of f(i, j) for all 1 ≤ i, j ≤ N. f(i, j) is defined as |A[i] - A[j]| + |i - j|,
//        where |x| denotes absolute value of x.
//
//
//
//        Problem Constraints
//        1 <= N <= 100000
//
//        -10^9 <= A[i] <= 10^9



public class MaximumAbsoluteDifference {
    public int maxArr(int[] A) {
        int X_max=-2147483648;
        int X_min=2147483647;
        int Y_max=-2147483648;
        int Y_min=2147483647;
        int ans=-2147483648;
        for(int i=0;i<A.length;i++){
            if((A[i]+i)>X_max){
                X_max=A[i]+i;
            }
            if((A[i]+i)<X_min){
                X_min=A[i]+i;
            }
            if((A[i]-i)>Y_max){
                Y_max=A[i]-i;
            }
            if((A[i]-i)<Y_min){
                Y_min=A[i]-i;
            }
            ans=Math.max((X_max-X_min),(Y_max-Y_min));
        }
        return ans;
    }
    public static void main(String args []){
        MaximumAbsoluteDifference R1=new MaximumAbsoluteDifference();
        int A[] = new int[3];
        A[0]=1;A[1]= 3;A[2]= -1;
        System.out.println(R1.maxArr(A));
    }
}






