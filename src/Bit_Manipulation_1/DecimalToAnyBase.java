package Bit_Manipulation_1;

//Problem Description
//        Given a decimal number A and a base B, convert it into its equivalent number in base B.
//
//        Problem Constraints
//        0 <= A <= 512
//        2 <= B <= 10

public class DecimalToAnyBase {
    public int decimalToAnyBase(int A, int B) {
        int ans=0;
        int p=1;
        while(A>0){
            int r=A%B;
            ans=ans+(p*r);
            p=p*10;
            A=A/B;
        }
        return ans;
    }
    public static void main(String args []){
        DecimalToAnyBase S1=new DecimalToAnyBase();
        System.out.println( S1.decimalToAnyBase(4,3));
    }
}



