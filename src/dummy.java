
import java.util.*;

public class dummy {
    public int solve(final String A) {
        int ans=0;
        Stack<Integer> stack=new Stack<>();
        stack.add(-1);
        for(int i=0;i<A.length();i++){
            if(A.charAt(i)=='('){
                stack.push(i);
            }
            else{
                if(!stack.isEmpty()){
                    stack.pop();
                    if(!stack.isEmpty()){
                        ans=Math.max(i-stack.peek(),ans);
                    }
                    else{
                        stack.push(i);
                    }
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        dummy I = new dummy();

        System.out.println( I.solve("()())"));
    }
}



