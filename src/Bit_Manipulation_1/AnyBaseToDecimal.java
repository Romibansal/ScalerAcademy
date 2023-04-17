package Bit_Manipulation_1;

//Q=Problem Description
//        You are given a number A. You are also given a base B. A is a number on base B.
//        You are required to convert the number A into its corresponding value in decimal number system.
//
//
//        Problem Constraints
//        0 <= A <= 10^9
//        2 <= B <= 9

public class AnyBaseToDecimal {
    public int solve(int A, int B) {
        int ans=0;
        int i=0;
        while(A>0){
            ans=ans+((int)(Math.pow(B,i))*(A%10));
            A=A/10;
            i++;
        }
        return ans;
    }
    public static void main(String args []){
        AnyBaseToDecimal S1=new AnyBaseToDecimal();
        System.out.println( S1.solve(22,3));
    }
}



