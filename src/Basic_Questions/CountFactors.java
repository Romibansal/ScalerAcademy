package Basic_Questions;

//Q=Problem Description
//        Given an integer A, you need to find the count of it's factors.
//
//        Factor of a number is the number which divides it perfectly leaving no remainder.
//
//        Example : 1, 2, 3, 6 are factors of 6


public class CountFactors {
    public int solve(int A) {
        int fact=0;
        for(int i=1;i<=Math.sqrt(A);i++){
            if(A%i==0){
                if(i==A/i){
                    fact=fact+1;
                }
                else{
                    fact=fact+2;
                }
            }
        }
        return fact;
    }
    public static void main(String args []){
        CountFactors N1=new CountFactors();
        System.out.println( N1.solve(5));
    }
}

