package Carry_Forward;

//Q=You are given an integer array A of size N.
//
//        You have to perform B operations. In one operation, you can remove either
//        the leftmost or the rightmost element of the array A.
//
//        Find and return the maximum possible sum of the elements that were removed after B operations.
//
//        NOTE: Suppose B = 4, and array A contains 10 elements, then
//
//        You can remove the first four elements or can remove the last four elements,
//        or can remove 1 from front and 3 from the back, etc. You need to return the maximum possible sum
//        of elements you can remove.
//
//
//        Problem Constraints
//        1 <= N <= 10^5
//        1 <= B <= N
//        -10^3 <= A[i] <= 10^3

public class PickFromBothSides {
    public int solve(int[] A, int B) {
        int sol_ans=0;
        for(int q=0;q<B;q++){
            sol_ans=sol_ans+A[q];
        }
        int j=1;
        int ans=sol_ans;
        for(int i=B-1;i>-1;i--){
            ans=ans-A[i];
            ans=ans+A[A.length-j];
            sol_ans=Math.max(sol_ans,ans);
            j++;
        }
        return sol_ans;
    }
    public static void main(String[] args) {
        PickFromBothSides I = new PickFromBothSides();

        int []A=new int[6];
        A[0]=2;A[1]=3;A[2]=-1;A[3]=4;A[4]= 2; A[5]=1;
        System.out.println( I.solve(A,4));
    }
}