package Carry_Forward;

//Q=Problem Description
//        You have given a string A having Uppercase English letters.
//        You have to find the number of pairs (i, j) such that A[i] = 'A', A[j] = 'G' and i < j.
//
//        Problem Constraints
//        1 <= length(A) <= 10^5

public class SpecialSubsequencesAG {
    public long solve(String A) {
        long a=0;
        long result=0;
        for(int i=0;i<A.length();i++){
            if(A.charAt(i)=='A'){
                a++;
            }
            else if(A.charAt(i)=='G'){
                result=result+a;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        SpecialSubsequencesAG I = new SpecialSubsequencesAG();
        System.out.println( I.solve("ABCGAG"));
    }
}

