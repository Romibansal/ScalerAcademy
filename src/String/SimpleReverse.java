package String;

//Q=Problem Description
//        Given a string A, you are asked to reverse the string and return the reversed string.
//
//
//
//        Problem Constraints
//        1 <= |A| <= 10^5
//
//        String A consist only of lowercase characters.


public class SimpleReverse {
    public String solve(String A) {
        StringBuilder str = new StringBuilder();
        for(int i=A.length()-1;i>-1;i--){
            str.append(A.charAt(i));
        }
        return str.toString();
    }
    public static void main(String args []){
        SimpleReverse N1=new SimpleReverse();
        System.out.println( N1.solve("scaler"));
    }
}

