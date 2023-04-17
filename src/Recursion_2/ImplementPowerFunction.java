package Recursion_2;

import java.util.Scanner;

//Q=Problem Description
//        Implement pow(A, B) % C.
//        In other words, given A, B and C, Find (AB % C).
//
//        Note: The remainders on division cannot be negative.
//        In other words, make sure the answer you return is non-negative.
//
//        Problem Constraints
//        -10^9 <= A <= 10^9
//        0 <= B <= 10^9
//        1 <= C <= 10^9


public class ImplementPowerFunction {
    public int pow(int A, int B, int C) {
        if (A == 0) {
            return 0;
        }
        if (B == 0) {
            return 1;
        }
        long p = pow(A, B / 2, C);
        long l=p*p;
        if (B % 2 == 0) {
            if(l<0){
                return C+(int)(l%C);
            }
            return (int)(l%C);
        }  else {
            int ans=(int)((l%C)*A%C)%C;
            if(ans<0){
                return C+ans;
            }
            return (int)((l%C)*A%C)%C;
        }
    }

    public static void main(String[] args) {
        ImplementPowerFunction I = new ImplementPowerFunction();
        System.out.println(I.pow(71045970, 41535484, 64735492));
    }
}
