package Recursion_2;


//Q=Problem Description
//        On the first row, we write a 0. Now in every subsequent row,
//        we look at the previous row and replace each occurrence of 0 with 01, and each occurrence of 1 with 10.
//
//        Given row number A and index B, return the Bth indexed symbol in row A. (The values of B are 0-indexed.).
//
//        Problem Constraints
//        1 <= A <= 10^5
//
//        0 <= B <= min(2^(A - 1) - 1 , 10^18)



public class KthSymbolHard {
    public int solve(int A, long B) {
        if(A==1){
            return 0;
        }
        long mid=((long)Math.pow(2,A-1))/2;
        if(B<mid){
            return solve(A-1,B);
        }
        else{
            return (solve(A-1,B-mid))^1;
        }
    }
    public static void main(String[] args) {
        KthSymbolEasy I = new KthSymbolEasy();
        System.out.println(I.solve(4,4));
    }
}


