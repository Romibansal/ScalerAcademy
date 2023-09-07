package Advance_Stacks;

import java.util.Stack;

//
//Q=Problem Description
//        Given a string A denoting an expression. It contains the following operators '+', '-', '*', '/'.
//
//        Check whether A has redundant braces or not.
//
//        NOTE: A will be always a valid expression and will not contain any white spaces.
//
//
//
//        Problem Constraints
//        1 <= |A| <= 10^5

//
//Example Input

//        Input 1:
//        A = "((a+b))"

//        Input 2:
//        A = "(a+(a+b))"
//
//        Example Output

//        Output 1:
//        1

//        Output 2:
//        0

public class RedundantBraces {
    public int braces(String A) {
        Stack <Character> stk =new Stack<>();
        for(int i=0;i<A.length();i++){
            char c=A.charAt(i);
            if( c==')'){
                int cnt=0;
                while(stk.peek()!='('){
                    if(stk.peek()=='*'||stk.peek()=='-'||stk.peek()=='+'||stk.peek()=='/'){
                        cnt++;
                    }
                    stk.pop();
                }
                stk.pop();

                if(cnt==0){
                    return 1;
                }
            }
            else{
                stk.push(c);
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        RedundantBraces I = new RedundantBraces();

        System.out.println(I.braces("(a+(a+b))"));
    }
}





