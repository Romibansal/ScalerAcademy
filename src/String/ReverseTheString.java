package String;

//Q=Problem Description
//        You are given a string A of size N.
//        Return the string A after reversing the string word by word.
//
//        NOTE:
//        A sequence of non-space characters constitutes a word.
//        Your reversed string should not contain leading or trailing spaces, even if it is present in the input string.
//        If there are multiple spaces between words, reduce them to a single space in the reversed string.
//
//        Problem Constraints
//        1 <= N <= 3 * 10^5


public class ReverseTheString {
    public String solve(String A) {
        String parts[] = A.split(" ");
        StringBuilder str = new StringBuilder();
        for(int i=parts.length-1;i>-1;i--){
            str.append(parts[i]);
            if(i!=0){
                str.append(' ');
            }
        }
        return str.toString();
    }
    public static void main(String args []){
        ReverseTheString N1=new ReverseTheString();
        System.out.println( N1.solve("the sky is blue"));
    }
}
