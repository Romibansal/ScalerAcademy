package Advance_GCD;

//Q=Problem Description
//        You are given a number A and a number B. Greatest Common Divisor (GCD)
//        of all numbers between A and B inclusive is taken (GCD(A, A+1, A+2 ... B)).
//        As this problem looks a bit easy, it is given that numbers A and B can be in the range of 10100.
//
//        You have to return the value of GCD found.
//
//        The greatest common divisor of 2 numbers, A and B, is the largest number,
//        D that divides both A and B perfectly.
//
//        Problem Constraints
//        1 <= A <= B <= 10^100

public class EnumeratingGCD {
    public String solve(String A, String B) {
        if(A.equals(B)){
            return A;
        }
        return "1";
    }
    public static void main(String[] args) {
        EnumeratingGCD I = new EnumeratingGCD();
        System.out.println(I.solve("4","6" ));
    }
}

