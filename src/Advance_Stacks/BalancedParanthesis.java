package Advance_Stacks;

import java.util.Stack;

//
//Q=Problem Description
//        Given an expression string A, examine whether the pairs and the orders of
//        “{“,”}”, ”(“,”)”, ”[“,”]” are correct in A.
//
//        Refer to the examples for more clarity.
//
//
//
//        Problem Constraints
//        1 <= |A| <= 100

//Example Input
//        Input 1:
//
//        A = {([])}
//        Input 2:
//
//        A = (){
//        Input 3:
//
//        A = ()[]
//
//
//        Example Output
//        Output 1:
//
//        1
//        Output 2:
//
//        0
//        Output 3:
//
//        1

public class BalancedParanthesis {
    public int solve(String A) {
        Stack<Character> stk= new Stack<>();
        for(int i=0;i<A.length();i++){
            char c=A.charAt(i);
            if(c=='(' || c=='{' || c=='['){
                stk.push(c);
            }
            else if(c==')'){
                if(stk.empty()){
                    return 0;
                }
                if(stk.peek()!='('){
                    return 0;
                }
                else{
                    stk.pop();
                }
            }
            else if(c=='}'){
                if(stk.empty()){
                    return 0;
                }
                if(stk.peek()!='{'){
                    return 0;
                }
                else{
                    stk.pop();
                }
            }
            else if(c==']'){
                if(stk.empty()){
                    return 0;
                }
                if(stk.peek()!='['){
                    return 0;
                }
                else{
                    stk.pop();
                }
            }
        }
        if(!stk.empty()){
            return 0;
        }
        return 1;
    }
    public static void main(String[] args) {
        BalancedParanthesis I = new BalancedParanthesis();

        System.out.println(I.solve("{([])}"));
    }
}




