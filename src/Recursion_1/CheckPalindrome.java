package Recursion_1;

//Q=Problem Description
//        Write a recursive function that checks whether string A is a palindrome or Not.
//        Return 1 if the string A is a palindrome, else return 0.
//
//        Note: A palindrome is a string that's the same when read forward and backward.
//
//
//
//        Problem Constraints
//        1 <= |A| <= 50000
//
//        String A consists only of lowercase letters.

public class CheckPalindrome {
    int IsPalidrome(String A,int s,int l){
        if(s>=l){
            return 1;
        }
        if(A.charAt(s)!=A.charAt(l)){
            return 0;
        }
        else{
           return IsPalidrome(A,s+1,l-1);
        }

    }
    public int solve(String A) {
        return (IsPalidrome(A,0,A.length()-1));
    }
    public static void main(String args []){
        CheckPalindrome N1=new CheckPalindrome();
        System.out.println( N1.solve("strings"));
    }
}
