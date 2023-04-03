package Bit_Manipulation_2;

// Q=Problem Description
//        You are given two integers A and B.
//        Return 1 if B-th bit in A is set
//        Return 0 if B-th bit in A is unset


public class CheckBit {
    public int solve(int A, int B) {
        B=1<<B;
        if((A&B)!=0){
            return 1;
        }
        else{
            return 0;
        }
    }
    public static void main(String args []){
        CheckBit s1=new CheckBit();
        System.out.println( s1.solve(4,1));
    }
}
