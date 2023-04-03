package Hashing_1;

import java.util.HashSet;


//Q=Problem Description
//        Given a number A, find if it is COLORFUL number or not.
//
//        If number A is a COLORFUL number return 1 else, return 0.
//
//        What is a COLORFUL Number:
//
//        A number can be broken into different consecutive sequence of digits.
//        The number 3245 can be broken into sequences like 3, 2, 4, 5, 32, 24, 45, 324 and 245.
//        This number is a COLORFUL number, since the product of every consecutive sequence of digits is different
//
//
//        Problem Constraints
//        1 <= A <= 2 * 10^9


public class ColorfulNumber {
    public int colorful(int A) {
        String str=Integer.toString(A);
        HashSet<Integer> h =new HashSet<Integer>();
        for(int i=0;i<str.length();i++){
            int mul=1;
            for(int j=i;j<str.length();j++){
                char c=str.charAt(j);
                int integer=Character.getNumericValue(c);
                 mul=mul*integer;
                if(h.contains(mul)){
                    return 0;
                }
                else{
                    h.add(mul);
                }
            }
        }
        return 1;
    }
    public static void main(String args []){
        ColorfulNumber N1=new ColorfulNumber();
        System.out.println( N1.colorful(236));
    }
}



