package Unique_Questions;

import java.util.ArrayList;

//Q= You and Your Friend are playing a number game in which you have an array A of integers and ypur friend's
// task is to find the product of numbers which are greater than their adjacent left number.
// Now this number can be very large which might not fit in the integer rang. So return the modolo of this number with
// 10^9+7.
// Note:- Adjacent Left number is the number that is before the current number.

// 1<=A<=10^5
// 1<A[i]<=10^9


public class NumberGame {
    public int solve(ArrayList<Integer> A) {
        if(A.size()==1  || A.size()==0){
            return 0;
        }
        int mod=(int)Math.pow(10,9)+7;
        long result=1;
        for(int i=1;i<A.size();i++){
            if(A.get(i-1)<A.get(i)){
                result=(result*(A.get(i)%mod))%mod;
            }
        }
        return (int)result;
    }
    public static void main(String args []){
        NumberGame N1=new NumberGame();
        ArrayList<Integer>A=new ArrayList<Integer>(5);
        A.add(3);A.add(5);A.add(4);A.add(7);A.add(7);
        System.out.println( N1.solve(A));
    }
}

