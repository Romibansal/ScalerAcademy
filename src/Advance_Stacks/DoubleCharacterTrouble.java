package Advance_Stacks;

import java.util.Stack;

//Q=Problem Description
//        You have a string, denoted as A.
//
//        To transform the string, you should perform the following operation repeatedly:
//       1. Identify the first occurrence of consecutive identical pairs of characters within the string.
//       2. Remove this pair of identical characters from the string.
//       3. Repeat steps 1 and 2 until there are no more consecutive identical pairs of characters.
//        The final result will be the transformed string.
//
//
//        Problem Constraints
//        1 <= |A| <= 100000
//

//Example Input
//        Input 1:
//
//        A = "abccbc"
//        Input 2:
//
//        A = "ab"
//
//
//        Example Output
//        Output 1:
//
//        "ac"
//        Output 2:
//
//        "ab"


public class DoubleCharacterTrouble {
    public String solve(String A) {
        Stack <Character> stk=new Stack<>();
        for(int i=0;i<A.length();i++){
            if(!stk.empty() && A.charAt(i)==stk.peek()){
                stk.pop();
            }
            else{
                stk.push(A.charAt(i));
            }
        }
        StringBuilder str=new StringBuilder();
        while(!stk.empty()){
            str.insert(0,stk.peek());
            stk.pop();
        }
        return str.toString();
    }
    public static void main(String[] args) {
        DoubleCharacterTrouble I = new DoubleCharacterTrouble();

        System.out.println(I.solve("abccbc"));
    }
}





