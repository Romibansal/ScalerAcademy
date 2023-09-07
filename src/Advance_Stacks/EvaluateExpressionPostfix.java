package Advance_Stacks;

import java.util.Stack;

//Q=Problem Description
//        An arithmetic expression is given by a string array A of size N.
//        Evaluate the value of an arithmetic expression in Reverse Polish Notation.
//
//        Valid operators are +, -, *, /. Each string may be an integer or an operator.
//
//        Note: Reverse Polish Notation is equivalent to Postfix Expression, where operators
//        are written after their operands.
//
//
//
//        Problem Constraints
//        1 <= N <= 10^5


//Example Input
//        Input 1:
//        A =   ["2", "1", "+", "3", "*"]
//        Input 2:
//        A = ["4", "13", "5", "/", "+"]
//
//
//        Example Output
//        Output 1:
//        9
//        Output 2:
//        6

public class EvaluateExpressionPostfix {
    public int evalRPN(String[] A) {
        Stack<Integer> stk=new Stack<>();
        for(int i=0;i<A.length;i++){
            if(A[i].equals("+") ){
                int x=stk.peek();
                stk.pop();
                int y=stk.peek();
                stk.pop();
                stk.push(y+x);
            }
            else if(A[i].equals("-") ){
                int x=stk.peek();
                stk.pop();
                int y=stk.peek();
                stk.pop();
                stk.push(y-x);
            }
            else if(A[i].equals("/") ){
                int x=stk.peek();
                stk.pop();
                int y=stk.peek();
                stk.pop();
                stk.push(y/x);
            }
            else if(A[i].equals("*") ){
                int x=stk.peek();
                stk.pop();
                int y=stk.peek();
                stk.pop();
                stk.push(y*x);
            }
            else{
                stk.push(Integer.valueOf(A[i]));
            }
        }
        return stk.peek();
    }
    public static void main(String[] args) {
        EvaluateExpressionPostfix I = new EvaluateExpressionPostfix();
        String A[]=new String[5];
        A[0]="2";A[1] ="1";A[2]= "+";A[3]= "3";A[4] ="*";
        System.out.println(I.evalRPN(A));
    }
}





