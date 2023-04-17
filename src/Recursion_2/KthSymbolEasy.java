package Recursion_2;


//Q=Problem Description
//        On the first row, we write a 0. Now in every subsequent row,
//        we look at the previous row and replace each occurrence of 0 with 01, and each occurrence of 1 with 10.
//
//        Given row number A and index B, return the Bth indexed symbol in row A. (The values of B are 0-indexed.).
//
//
//
//        Problem Constraints
//        1 <= A <= 20
//
//        0 <= B < 2^(A - 1)

public class KthSymbolEasy {
    String fun(String s){
        StringBuilder stb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0'){
                stb.append("01");
            }
            if(s.charAt(i)=='1'){
                stb.append("10");
            }
        }
        return stb.toString();
    }
    public int solve(int A, int B) {
        String S="0";
        for(int j=0;j<A-1;j++){
            S=fun(S);
        }
        return S.charAt(B)-'0';
    }
    public static void main(String[] args) {
        KthSymbolEasy I = new KthSymbolEasy();
        System.out.println(I.solve(4,4));
    }
}

