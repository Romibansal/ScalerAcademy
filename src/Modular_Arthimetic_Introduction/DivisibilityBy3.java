package Modular_Arthimetic_Introduction;


//Q=Problem Description
//        Given a number in the form of an array A of size N. Each of the digits of the number is represented by A[i].
//        Check if the number is divisible by 3.

public class DivisibilityBy3 {
    public int solve(int[] A) {
        int sum=0;
        for(int i=0;i<A.length;i++){
            sum=sum+A[i];
        }
        if(sum%3==0){
            return 1;
        }
        return 0;
    }
    public static void main(String args []){
        DivisibilityBy3 N1=new DivisibilityBy3();
        int A[] = new int[3];
        A[0]=1;
        A[1]=2;
        A[3]=3;

        System.out.println( N1.solve(A));
    }
}


