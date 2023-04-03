package Bit_Manipulation_2;

//Q=Problem Description
//        Given an integer A. Unset B bits from the right of A in binary.
//        For eg:-
//        A = 93, B = 4
//        A in binary = 1011101
//        A should become = 1010000 = 80. Therefore return 80.




public class UnsetXBitsFromRight {
    public long solve(long A, int B) {
        long a=0;
        long q=A;
        for(int i=0;i<B;i++){
            if(q%2!=0){
                a=a+(long)Math.pow(2,i);
            }
            q=q>>1;
        }
        return (A-a);
    }
    public static void main(String args []){
        UnsetXBitsFromRight S1=new UnsetXBitsFromRight();
        System.out.println( S1.solve(25,3));
    }
}
