package Advance_Backtracking_2;

import java.util.ArrayList;

//Q=Problem Description

//        Given a string A, partition A such that every string of the partition is a palindrome.
//
//        Return all possible palindrome partitioning of A.
//
//        Ordering the results in the answer : Entry i will come before Entry j if :

//        len(Entryi[0]) < len(Entryj[0]) OR

//        (len(Entryi[0]) == len(Entryj[0]) AND len(Entryi[1]) < len(Entryj[1])) OR * * *

//        (len(Entryi[0]) == len(Entryj[0]) AND ... len(Entryi[k] < len(Entryj[k]))
//
//
//        Problem Constraints

//        1 <= len(A) <= 15
//
//
//
//        Input Format

//        First argument is a string A of lowercase characters.
//
//
//
//        Output Format

//        Return a list of all possible palindrome partitioning of s.
//
//
//
//        Example Input

//        Input 1:
//
//        A = "aab"

//        Input 2:
//
//        A = "a"
//
//
//        Example Output

//        Output 1:
//
//        [
//        ["a","a","b"]
//        ["aa","b"],
//        ]

//        Output 2:
//
//        [
//        ["a"]
//        ]
//
//
//        Example Explanation

//        Explanation 1:
//
//        In the given example, ["a", "a", "b"] comes before ["aa", "b"] because len("a") < len("aa").
//        Explanation 2:
//
//        In the given example, only partition possible is "a" .

public class PalindromePartitioning {

    ArrayList<ArrayList<String>> ans=new ArrayList<>();

    public boolean isPalindrome(String A, int l , int h){
        while(l < h){
            if(A.charAt(l) != A.charAt(h)) {
                return false;
            }
            l++;
            h--;
        }
        return true;
    }

    public void generate(String A, ArrayList<String> curr, int index, int N){
        if(index == N){
            ans.add(new ArrayList<String> (curr));
            return;
        }
        for(int i = index; i < N; i++){
            if(isPalindrome(A, index, i)){
                curr.add(A.substring(index, i+1));
                generate(A, curr, i+1, N);
                curr.remove(curr.size() - 1);
            }
        }
    }

    public ArrayList<ArrayList<String>> partition(String a) {
        int N = a.length();
        ArrayList<String> curr = new ArrayList<> ();
        generate(a, curr, 0, N);
        return ans;
    }
    public static void main(String[] args) {
        PalindromePartitioning I = new PalindromePartitioning();
        System.out.println( I.partition("abbcc"));
    }
}


















