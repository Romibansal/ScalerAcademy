package Advance_Backtracking_1;

import java.util.ArrayList;


//Q=Problem Description

//        Given a digit string A, return all possible letter combinations that the number could represent.
//
//        A mapping of digit to letters (just like on the telephone buttons) is given below.
//
//
//
//        The digit 0 maps to 0 itself. The digit 1 maps to 1 itself.
//
//        NOTE: Make sure the returned strings are lexicographically sorted.
//
//
//
//        Problem Constraints
//        1 <= |A| <= 10
//
//
//
//        Input Format

//        The only argument is a digit string A.
//
//
//
//        Output Format

//        Return a string array denoting the possible letter combinations.
//
//
//
//        Example Input

//        Input 1:
//
//        A = "23"

//        Input 2:
//
//        A = "012"
//
//
//        Example Output

//        Output 1:
//
//        ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]

//        Output 2:
//
//        ["01a", "01b", "01c"]
//
//
//        Example Explanation

//        Explanation 1:
//
//        There are 9 possible letter combinations.

//        Explanation 2:
//
//        Only 3 possible letter combinations.


public class LetterPhone {

    void permutation(ArrayList<String> s,int idx,String A,StringBuilder str){
        if(idx==A.length()){
            ans.add(str.toString());
            return;
        }
        int temp=A.charAt(idx)-'0';
        for(int i=0;i<s.get(temp).length();i++){
            str.append(s.get(temp).charAt(i));
            permutation(s,idx+1,A,str);
            str.deleteCharAt(str.length()-1);
        }
    }

    ArrayList<String>ans=new ArrayList<>();

    public ArrayList<String> letterCombinations(String A) {
        ArrayList<String> s=new ArrayList<>();
        s.add("0");s.add("1");s.add("abc");s.add("def");s.add("ghi");s.add("jkl");
        s.add("mno");s.add("pqrs");s.add("tuv");s.add("wxyz");
        StringBuilder str =new StringBuilder();
        permutation(s,0,A,str);
        return ans;
    }
    public static void main(String[] args) {
        LetterPhone I = new LetterPhone();
        System.out.println( I.letterCombinations("012"));
    }
}
