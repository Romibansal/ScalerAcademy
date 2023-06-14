package Advance_Hashing_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

//Q=Problem Description
//        Given a number A, find if it is COLORFUL number or not.
//
//        If number A is a COLORFUL number return 1 else, return 0.
//
//        What is a COLORFUL Number:
//
//        A number can be broken into different consecutive sequence of digits.
//        The number 3245 can be broken into sequences like 3, 2, 4, 5, 32, 24, 45, 324, 245 and 3245.
//        This number is a COLORFUL number, since the product of every consecutive
//        sequence of digits is different
//
//
//        Problem Constraints
//        1 <= A <= 2 * 10^9



public class ColorfulNumber {
    public int colorful(int A) {
        ArrayList<Integer>digits= new ArrayList<>();
        while(A>0){
            digits.add(A%10);
            A=A/10;
        }
        Collections.reverse(digits);
        HashSet<Integer> set=new HashSet();
        for(int j=0;j<digits.size();j++){
            int product=1;
            for(int i=j;i<digits.size();i++){
                product=product*digits.get(i);
                if(set.contains(product)){
                    return 0;
                }
                else{
                    set.add(product);
                }
            }
        }
        return 1;
    }
    public static void main(String[] args) {
        ColorfulNumber I = new ColorfulNumber();
        System.out.println(I.colorful(236));
    }
}
