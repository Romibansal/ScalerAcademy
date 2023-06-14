package Advance_Recursion;

import java.util.ArrayList;
import java.util.Collections;

//Q=Problem Description
//        Given an integer A pairs of parentheses, write a function to
//        generate all combinations of well-formed parentheses of length 2*A.
//
//
//        Problem Constraints
//        1 <= A <= 10

public class GenerateAllParenthesesII {
    ArrayList<String> generatestring(int remO, int remC, String s,ArrayList<String> ans){
        if(remC==0 && remO==0){
            ans.add(s);
            return ans;
        }
        if(remC>remO){
            generatestring(remO,remC-1,s+")", ans);
        }
        if(remO>0){
            generatestring(remO-1,remC,s+"(",ans);
        }
        return ans;
    }
    public ArrayList<String> generateParenthesis(int A) {
        ArrayList<String> ans =new ArrayList<>();
        ArrayList<String> a= ( generatestring(A,A,"", ans));
        Collections.reverse(a);
        return a;
    }
    public static void main(String[] args) {
        GenerateAllParenthesesII I = new GenerateAllParenthesesII();
        System.out.println(I.generateParenthesis(2));
    }
}

