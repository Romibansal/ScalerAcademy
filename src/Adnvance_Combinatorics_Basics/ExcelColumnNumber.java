package Adnvance_Combinatorics_Basics;

//Q=Problem Description
//        Given a column title as appears in an Excel sheet, return its corresponding column number.
//
//
//
//        Problem Constraints
//        1 <= length of the column title <= 5



public class ExcelColumnNumber {
    public int titleToNumber(String A) {
        int ans=0;
        int j=0;
        for(int i=A.length()-1;i>-1;i--){
            int value=A.charAt(i)-64;
            int y=(int)Math.pow(26,j);
            ans=ans+(value*y);
            j++;
        }
        return ans;
    }
    public static void main(String[] args) {
        ExcelColumnNumber I = new ExcelColumnNumber();
        System.out.println(I.titleToNumber("BB"));
    }
}
