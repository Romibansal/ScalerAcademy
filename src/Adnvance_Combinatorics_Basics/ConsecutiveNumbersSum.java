package Adnvance_Combinatorics_Basics;

//Q=Problem Description
//        Given a positive integer A.
//
//        Return the number of ways it can be written as a sum of consecutive positive integers.
//
//
//
//        Problem Constraints
//        1 <= A <= 10^9

public class ConsecutiveNumbersSum {
    public int solve(int A) {
        int count=0;
        for(int k=1;k<=Math.sqrt(2*A);k++){
            int r=(k*(k-1));
            int x=r/2;
            int y=A-x;
            if(y%k==0){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        ConsecutiveNumbersSum I = new ConsecutiveNumbersSum();
        System.out.println(I.solve(2));
    }
}

