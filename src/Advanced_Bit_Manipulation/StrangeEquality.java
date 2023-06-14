package Advanced_Bit_Manipulation;

//Q=Problem Description
//        Given an integer A.
//        Two numbers, X and Y, are defined as follows:
//
//        X is the greatest number smaller than A such that the XOR sum of X and
//        A is the same as the sum of X and A.
//        Y is the smallest number greater than A, such that the XOR sum of Y
//        and A is the same as the sum of Y and A.
//        Find and return the XOR of X and Y.
//
//        NOTE 1: XOR of X and Y is defined as X ^ Y where '^' is the BITWISE XOR operator.
//
//        NOTE 2: Your code will be run against a maximum of 100000 Test Cases.
//
//
//
//        Problem Constraints
//        1 <= A <= 10^9

public class StrangeEquality {
    public int solve(int A) {
        int B=A;
        int bits=0;
        while(B>0){
            bits++;
            B=B>>1;
        }
        int y=(1<<bits);
        int x=0;
        int pos=0;
        while(A>0){
            if((A&1)==0){
                x=(x|(1<<pos));
            }
            pos++;
            A=A>>1;
        }
        return (x^y);
    }
    public static void main(String args []){
        StrangeEquality S1=new StrangeEquality();
        System.out.println( S1.solve(3));
    }
}

