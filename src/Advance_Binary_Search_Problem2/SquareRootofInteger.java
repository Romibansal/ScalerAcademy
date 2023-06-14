package Advance_Binary_Search_Problem2;

//Q=Problem Description
//        Given an integer A. Compute and return the square root of A.
//        If A is not a perfect square, return floor(sqrt(A)).
//
//        The value of A can cross the range of Integer.
//
//        NOTE:
//        Do not use the sqrt function from the standard library.
//        Users are expected to solve this in O(log(A)) time.
//
//
//        Problem Constraints
//        0 <= A <= 10^10

public class SquareRootofInteger {
    public int sqrt(int A) {
        if(A==1){
            return 1;
        }
        long l=1;
        long r=A/2;
        while(l<=r){
            long mid= l+(r-l)/2;
            if( (mid*mid)<=A && (mid+1)*(mid+1)>A){
                return (int)mid;
            }

            if((mid*mid)<A){
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        SquareRootofInteger I = new SquareRootofInteger();
        System.out.println(I.sqrt(2147483647));
    }
}
