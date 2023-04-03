package String;

//Q=Problem Description
//        You are given a character string A having length N, consisting of only lowercase and uppercase latin letters.
//
//        You have to toggle case of each character of string A. For e.g 'A' is changed to 'a', 'e'
//        is changed to 'E', etc.
//
//        Problem Constraints
//        1 <= N <= 10^5
//
//        A[i] ∈ ['a'-'z', 'A'-'Z']




public class ToggleCase {
    public String solve(String A) {
        char[] ch = A.toCharArray();
        for(int i=0; i<ch.length; i++){
            if(ch[i]>=65 && ch[i]<=90){
                ch[i] = (char)((int)ch[i]+32);
            }else{
                if(ch[i]>=97 && ch[i]<=122){
                    ch[i] = (char)((int)ch[i]-32);
                }
            }
        }
        String str = String.copyValueOf(ch);
        return str;
    }

    public static void main(String args []){
        ToggleCase N1=new ToggleCase();
        System.out.println( N1.solve("tHiSiSaStRiNg"));
    }
}
