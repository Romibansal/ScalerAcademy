package Advance_GCD;

//Q=Problem Description
//        Scooby has 3 three integers A, B, and C.
//
//        Scooby calls a positive integer special if it is divisible by B and it is divisible by C.
//        You need to tell the number of special integers less than or equal to A.

//        Problem Constraints
//        1 <= A, B, C <= 10^9

public class DivisorGame {
    int gcd(int a, int b){
        if(a==0){
            return b;
        }
        return (gcd((b%a),a));
    }
    public int solve(int A, int B, int C) {
        int hcf= gcd(B,C);
        int lcm=((B*C)/hcf);
        return (A/lcm);
    }
    public static void main(String[] args) {
        DivisorGame I = new DivisorGame();
        int[] A=new int[3];
        System.out.println(I.solve(12,3,2 ));
    }
}



