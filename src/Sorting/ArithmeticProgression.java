package Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;



//QProblem Description
//        Given an integer array A of size N. Return 1 if the array can
//        be arranged to form an arithmetic progression, otherwise return 0.
//
//        A sequence of numbers is called an arithmetic progression
//        if the difference between any two consecutive elements is the same.



public class ArithmeticProgression {
    public int solve(ArrayList<Integer> A) {
        Collections.sort(A);
        int diff=A.get(1)-A.get(0);
        for(int i=1;i<A.size();i++){
            if((A.get(i)-A.get(i-1))!=diff){
                return 0;
            }
        }
        return 1;
    }
    public static void main(String args []){
        ArithmeticProgression N1=new ArithmeticProgression();
        ArrayList<Integer>A=new ArrayList<>(3);
        A.add(3);
        A.add(5);
        A.add(1);
        System.out.println( N1.solve(A));
    }
}
