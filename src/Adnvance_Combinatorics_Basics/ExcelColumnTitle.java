package Adnvance_Combinatorics_Basics;

//Q=Problem Description
//        Given a positive integer A, return its corresponding column title as it appears in an Excel sheet.
//
//        For example:
//
//        1 -> A
//        2 -> B
//        3 -> C
//        ...
//        26 -> Z
//        27 -> AA
//        28 -> AB
//
//
//        Problem Constraints
//        1 <= A <= 10^9

public class ExcelColumnTitle {
    public String convertToTitle(int A) {
        char[] UpperCaseAlphabet = {'A','B','C','D','E','F','G','H','I','J','K',
                'L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        StringBuilder str = new StringBuilder();
        A=A-1;
        while(A>0){
            int a=A%26;
            char c=UpperCaseAlphabet[a];
            String s=""+c;
            str.append(s);
            A=A/26;
            A=A-1;
        }
        if(A==0){
            str.append("A");
        }
        str.reverse();
        return str.toString();
    }
    public static void main(String[] args) {
        ExcelColumnTitle I = new ExcelColumnTitle();
        System.out.println(I.convertToTitle(980089));
    }
}

