package Recursion_1;

//Q=Problem Description
//        Given a number A, we need to find the sum of its digits using recursion.
//
//        Problem Constraints
//        1 <= A <= 10^9

public class SumOfDigits {
    public int solve(int A) {
        if(A/10==0){
            return A;
        }
        return (solve(A/10)+A%10);
    }
    public static void main(String args []){
        SumOfDigits N1=new SumOfDigits();
        System.out.println( N1.solve(100));
    }
}


