package Bit_Manipulation_1;

//Q=Problem Description
//        Given two integers A and B. Find the minimum value (A ⊕ X) + (B ⊕ X) that can be achieved for any X.
//
//        where P ⊕ Q is the bitwise XOR operation of the two numbers P and Q.
//
//
//        Problem Constraints
//        1 <= A, B <= 10^9

public class XORSum {
    public int solve(int A, int B) {
        return ((A^(A&B))+(B^(A&B)));
    }
    public static void main(String args []){
        XORSum S1=new XORSum();
        System.out.println( S1.solve(6,12));
    }
}
