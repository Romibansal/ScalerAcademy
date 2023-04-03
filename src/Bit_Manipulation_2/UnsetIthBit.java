package Bit_Manipulation_2;

//Q=Problem Description
//        You are given two integers A and B.
//        If B-th bit in A is set, make it unset
//        If B-th bit in A is unset, leave it as it is
//        Return the updated A value

public class UnsetIthBit {
    public int solve(int A, int B) {
        int C=A>>B;
        if((C&1)==1){
            A=A^(1<<B);
        }
        return A;
    }
    public static void main(String args []){
        UnsetIthBit S1=new UnsetIthBit();
        System.out.println( S1.solve(5,2));
    }
}

