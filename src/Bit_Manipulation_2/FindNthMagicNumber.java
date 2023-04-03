package Bit_Manipulation_2;

//Q=Problem Description
//        Given an integer A, find and return the Ath magic number.
//
//        A magic number is defined as a number that can be expressed as a power of 5 or a sum of unique powers of 5.
//
//        First few magic numbers are 5, 25, 30(5 + 25), 125, 130(125 + 5), ….


public class FindNthMagicNumber {
    public int solve(int A) {
        int x=1;
        int ans=0;
        while(A>0){
            if(A%2!=0){
                ans=ans+(int)Math.pow(5,x);
            }
            A=A>>1;
            x++;
        }
        return ans;
    }
    public static void main(String args []){
        FindNthMagicNumber N1=new FindNthMagicNumber();
        System.out.println( N1.solve(10));
    }
}
