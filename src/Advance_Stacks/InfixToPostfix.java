package Advance_Stacks;

import java.util.HashMap;
import java.util.Stack;
//
//Q=Problem Description
//        Given string A denoting an infix expression. Convert the infix expression into a postfix expression.
//
//        String A consists of ^, /, *, +, -, (, ) and lowercase English alphabets where lowercase
//        English alphabets are operands and ^, /, *, +, - are operators.
//
//        Find and return the postfix expression of A.
//
//        NOTE:
//
//        ^ has the highest precedence.
//        / and * have equal precedence but greater than + and -.
//        + and - have equal precedence and lowest precedence among given operators.
//
//
//        Problem Constraints
//        1 <= length of the string <= 500000

//
//Example Input
//        Input 1:
//
//        A = "x^y/(a*z)+b"
//        Input 2:
//
//        A = "a+b*(c^d-e)^(f+g*h)-i"
//
//
//        Example Output
//        Output 1:
//
//        "xy^az*/b+"
//        Output 2:
//
//        "abcd^e-fgh*+^*+i-"

public class InfixToPostfix {
    public String solve(String A) {
        Stack <Character> stk=new Stack<>();
        StringBuilder str=new StringBuilder();
        HashMap<Character,Integer> map=new HashMap<>();
        map.put('+',1);
        map.put('-',1);
        map.put('*',2);
        map.put('/',2);
        map.put('^',3);
        for(int i=0;i<A.length();i++){

            Character c=A.charAt(i);

            if(c!='(' && c!=')' && c!='*' && c!='/' && c!='-' && c!='+' && c!='^'){
                str.append(c);
            }
            else if(c=='('){
                stk.push(c);
            }
            else if(stk.empty() || stk.peek()=='('){
                stk.push(c);
            }
            else if(c==')'){
                while(stk.peek()!='('){
                    str.append(stk.peek());
                    stk.pop();
                }
                stk.pop();
            }
            else if(map.get(c)<=(map.get(stk.peek()))){
                while(!stk.empty() && stk.peek()!='(' && map.get(c)<=(map.get(stk.peek()))){
                    str.append(stk.peek());
                    stk.pop();
                }
                stk.push(c);
            }
            else{
                stk.push(c);
            }
        }
        while(!stk.empty()){
            str.append(stk.peek());
            stk.pop();
        }
        return str.toString();
    }
    public static void main(String[] args) {
        InfixToPostfix I = new InfixToPostfix();
        System.out.println(I.solve("xy^az*/b+"));
    }
}






