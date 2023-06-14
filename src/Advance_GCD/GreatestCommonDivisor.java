package Advance_GCD;

//Q=Problem Description
//        Given 2 non-negative integers A and B, find gcd(A, B)
//
//        GCD of 2 integers A and B is defined as the greatest integer 'g' such that
//        'g' is a divisor of both A and B. Both A and B fit in a 32 bit signed integer.
//
//        Note: DO NOT USE LIBRARY FUNCTIONS.
//
//
//
//        Problem Constraints
//        0 <= A, B <= 10^9


public class GreatestCommonDivisor {
    public int gcd(int A, int B) {
        while(A>0 && B>0){
            if(A<B){
                B=(B%A);
                int temp=B;
                B=A;
                A=temp;
            }
            else{
                A=(A%B);
                int temp=A;
                A=B;
                B=temp;
            }
        }
        return (A+B);
    }
    public static void main(String[] args) {
        GreatestCommonDivisor I = new GreatestCommonDivisor();
        System.out.println(I.gcd(4,6 ));
    }
}


