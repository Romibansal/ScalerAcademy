package Recursion_1;


//Q=Problem Description
//        Write a program to find the factorial of the given number A using recursion.
//
//        Note: The factorial of a number N is defined as the product of the numbers from 1 to N.
//
//
//        Problem Constraints
//        0 <= A <= 12



public class FindFactorial {
    public int solve(int A) {
        if(A==1){
            return 1;
        }
        return(solve(A-1)*A);
    }
    public static void main(String args []){
        FindFactorial N1=new FindFactorial();
        System.out.println( N1.solve(3));
    }
}


