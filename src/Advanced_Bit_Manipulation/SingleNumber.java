package Advanced_Bit_Manipulation;

import java.util.ArrayList;
import java.util.List;

//Q=Problem Description
//        Given an array of integers A, every element appears twice except for one.
//        Find that integer that occurs once.
//
//        NOTE: Your algorithm should have a linear runtime complexity.
//        Could you implement it without using extra memory?
//
//
//
//        Problem Constraints
//        1 <= |A| <= 2000000
//
//        0 <= A[i] <= INTMAX



public class SingleNumber {
    public int singleNumber(final List<Integer> A) {
        int ans=0;
        for(int i=0;i<A.size();i++){
            ans=ans^A.get(i);
        }
        return ans;
    }
    public static void main(String args []){
        SingleNumber S1=new SingleNumber();
        ArrayList<Integer> A=new ArrayList<>();
        A.add(1); A.add(1); A.add(2);A.add(2);A.add(3);
        System.out.println( S1.singleNumber(A));
    }
}






