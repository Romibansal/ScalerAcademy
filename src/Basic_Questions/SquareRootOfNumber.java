package Basic_Questions;



//Q=Problem Description
//
//        Given a number A. Return square root of
//        the number if it is perfect square otherwise
//        return -1

public class SquareRootOfNumber {
    public int solve(int A) {
        for(int i=0;i<= Math.sqrt(A);i++){
            if(i*i==A){
                return i;
            }
        }
        return -1;
    }
    public static void main(String args []){
        SquareRootOfNumber N1=new SquareRootOfNumber();
        System.out.println( N1.solve(5));
    }
}
