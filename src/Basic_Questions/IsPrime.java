package Basic_Questions;

//Q=Problem Description
//        Given an Integer A. Return 1 if A is prime and return 0 if not.


public class IsPrime {
    public int solve(long A) {
        if(A==1){
            return 0;
        }
        for(int i=2;i<=Math.sqrt(A);i++){
            if(A%i==0){
                return 0;
            }
        }
        return 1;
    }
    public static void main(String args []){
        IsPrime N1=new IsPrime();
        System.out.println( N1.solve(5));
    }
}
