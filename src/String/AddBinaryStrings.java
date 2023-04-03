package String;

//Q=Problem Description
//        Given two binary strings A and B. Return their sum (also a binary string).
//
//
//        Problem Constraints
//        1 <= length of A <= 10^5
//
//        1 <= length of B <= 10^5
//
//        A and B are binary strings





public class AddBinaryStrings {
    public String addBinary(String A, String B) {
        int Alen=A.length();
        int Blen=B.length();
        int n=Math.abs(Alen-Blen);
        String str="";
        for(int i=0;i<n;i++){
            str=str+'0';
        }
        if(Alen>Blen){
            B=str+B;
        }
        if(Blen>Alen){
            A=str+A;
        }
        StringBuilder result=new StringBuilder(A);
        int remainder=0;
        for(int i=A.length()-1;i>-1;i--){
            int a=Character.getNumericValue(A.charAt(i));
            int b=Character.getNumericValue(B.charAt(i));
            int d=a+b+remainder;
            char c=(char)((d%2)+'0');
            result.setCharAt(i,c);
            remainder=d/2;
        }
        if(remainder==1){
            char r=(char)((remainder)+'0');
            return  r+result.toString();
        }
        return result.toString();
    }
    public static void main(String args[]) {
        AddBinaryStrings N1 = new AddBinaryStrings();
        System.out.println(N1.addBinary("1","1"));
    }
}


