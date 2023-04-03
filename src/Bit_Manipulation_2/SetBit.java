package Bit_Manipulation_2;

//Q=Problem Description
//You are given two integers A and B.
//Set the A-th bit and B-th bit in 0, and return output in decimal.



public class SetBit {
    public int solve(int A, int B) {
        if(A==B){
            return (int)(Math.pow(2,A));
        }
        return (int)(Math.pow(2,A)+Math.pow(2,B));
    }
    public static void main(String args []){
        SetBit S1=new SetBit();
        System.out.println( S1.solve(3,5));
    }
}
