package Recursion_2;

//Q=Problem Description
//        Given a number A, check if it is a magic number or not.
//
//        A number is said to be a magic number if the
//        sum of its digits is calculated till a single digit recursively by adding the sum of the
//        digits after every addition. If the single digit comes out to be 1, then the number is a magic number.
//
//        Problem Constraints
//        1 <= A <= 10^9

public class Ismagic {
    int sum(int A){
        if(A/10==0){
            return A;
        }
        return (sum(A/10)+A%10);
    }
    public int solve(int A) {
        int ans=A;
        while(ans/10!=0){
             ans=sum(ans);
        }
        if(ans==1){
            return 1;
        }
        return 0;
    }
    public static void main(String[] args) {
        Ismagic I = new Ismagic();
        System.out.println(I.solve(83557));
    }
}

