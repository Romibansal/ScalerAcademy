package Bit_Manipulation_2;

//
//Q=Problem Description
//        Reverse the bits of an 32 bit unsigned integer A.


public class ReverseBits {
    public long reverse(long A) {
        long ans=0;
        if(A==0){
            return ans;
        }
        int i=0;
        while(A>0){
            if(A%2!=0){
                ans=ans+(long)Math.pow(2,(31-i));
            }
            i++;
            A=A>>1;
        }
        return ans;
    }

    public static void main(String args []){
        ReverseBits N1=new ReverseBits();
        System.out.println( N1.reverse(3));
    }
}
