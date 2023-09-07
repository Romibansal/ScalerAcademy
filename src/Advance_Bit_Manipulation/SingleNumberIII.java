package Advance_Bit_Manipulation;

//Q=Problem Description
//        Given an array of positive integers A, two integers appear only once,
//        and all the other integers appear twice.
//        Find the two integers that appear only once.
//
//        Note: Return the two numbers in ascending order.
//
//
//        Problem Constraints
//        2 <= |A| <= 100000
//        1 <= A[i] <= 10^9

import java.util.ArrayList;

public class SingleNumberIII {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        int xor=0;
        for(int i=0;i<A.size();i++){
            xor=xor^A.get(i);
        }
        int index=-1;
        for(int j=0;j<31;j++){
            int x=1<<j;
            if((xor&x)>1){
                index=j;
                break;
            }
        }
        int xora=0;
        int xorb=0;
        for(int k=0;k<A.size();k++){
            if(((A.get(k)>>index)&1)==1){
                xora=xora^A.get(k);
            }
            else{
                xorb=xorb^A.get(k);
            }
        }
        ArrayList<Integer> ans=new ArrayList<>();
        if(xora<xorb){
            ans.add(xora);
            ans.add(xorb);
        }
        else{
            ans.add(xorb);
            ans.add(xora);
        }
        return ans;
    }
    public static void main(String args []){
        SingleNumberIII S1=new SingleNumberIII();
        ArrayList<Integer>A=new ArrayList<>();
        A.add(186); A.add(256); A.add(102); A.add(377); A.add(186);A.add( 377);
        System.out.println( S1.solve(A));
    }
}




