package Advance_Modular_Arithmetic;

//Q=Problem Description
//        Given two integers A and B, find the greatest possible positive integer M, such that A % M = B % M.
//
//
//
//        Problem Constraints
//        1 <= A, B <= 10^9
//        A != B



public class ABandModulo {
    public int solve(int A, int B) {
        if(A>B){
            return (A-B);
        }
        else{
            return (B-A);
        }
    }
    public static void main(String[] args) {
        ABandModulo I = new ABandModulo();
        System.out.println(I.solve(5,10));
    }
}
