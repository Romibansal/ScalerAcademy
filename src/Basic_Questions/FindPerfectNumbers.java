package Basic_Questions;


//Q=Problem Description
//        You are given an integer A. You have to tell whether it is a perfect number or not.
//
//        Perfect number is a positive integer which is equal to the sum of its proper positive divisors.
//
//        A proper divisor of a natural number is the divisor that is strictly less than the number.


public class FindPerfectNumbers {
    public int solve(int A) {
        if(A==1){
            return 0;
        }
        int sum=1;
        for(int i=2;i<=Math.sqrt(A);i++){
            if(A%i==0){
                if(i==(A/i)){
                    sum=sum+i;
                }
                else{
                    sum=sum+i+(A/i);
                }
            }
        }
        if(sum==A){
            return 1;
        }
        return 0;
    }
    public static void main(String args []){
        FindPerfectNumbers N1=new FindPerfectNumbers();
        System.out.println( N1.solve(6));
    }
}

