package Bit_Manipulation_2;



//Q=Problem Description
//        You are given two integers A and B.
//        If B-th bit in A is set, make it unset
//        If B-th bit in A is unset, make it set
//        Return the updated A value

public class ToggleIthBit {
    public int solve(int A, int B) {
        B=(1<<B);
        A=(A^B);
        return A;
    }
    public static void main(String args []){
        ToggleIthBit S1=new ToggleIthBit();
        System.out.println( S1.solve(4,1));
    }
}


