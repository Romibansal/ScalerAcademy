package Bit_Manipulation_2;


// Q=Write a function that takes an integer and returns the number of 1 bits it has?

public class NumberOf1Bits {
    public int NumberOf1Bits(int A) {
        int ans=0;
        while(A>0){
            if((A&1)==1){
                ans++;
            }
            A=(A>>1);
        }
        return ans;
    }
    public static void main(String args []){
        NumberOf1Bits N1=new NumberOf1Bits();
        System.out.println( N1.NumberOf1Bits(11));
    }
}
