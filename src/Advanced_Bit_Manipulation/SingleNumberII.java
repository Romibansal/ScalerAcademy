package Advanced_Bit_Manipulation;

import java.util.ArrayList;
import java.util.List;

//Q=Problem Description
//        Given an array of integers, every element appears thrice except for one, which occurs once.
//
//        Find that element that does not appear thrice.
//
//        NOTE: Your algorithm should have a linear runtime complexity.
//
//        Could you implement it without using extra memory?
//
//
//
//
//        Problem Constraints
//        2 <= A <= 5*10^6
//
//        0 <= A <= INTMAX

public class SingleNumberII {
    public int singleNumber(final List<Integer> A) {
        int ans=0;
        for(int i=0;i<31;i++){
            int count=0;
            for(int j=0;j<A.size();j++){
                if(((A.get(j)>>i)&1)==1){
                    count++;
                }
            }
            if(count%3!=0){
                ans= (ans | (1<<i));
            }
        }
        return ans;
    }
    public static void main(String args []){
        SingleNumberII S1=new SingleNumberII();
        ArrayList<Integer> A=new ArrayList<>();
        A.add(0); A.add(0); A.add(0);A.add(1);
        System.out.println( S1.singleNumber(A));
    }
}





