package Recursion_1;

//Q=Problem Description
//        You are given an integer A, print 1 to A using using recursion.
//
//
//
//        Problem Constraints
//        1 <= A <= 10^4




public class Print1ToAFunction {
    void print(int A){
        if(A==1){
            System.out.print(A+" ");
            return;

        }
        print(A-1);
        System.out.print(A+" ");
    }
    public void solve(int A) {
        print(A);
    }
    public static void main(String args []){
        Print1ToAFunction N1=new Print1ToAFunction();
        N1.solve(9);
    }
}
