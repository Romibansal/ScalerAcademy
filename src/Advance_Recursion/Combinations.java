package Advance_Recursion;

import java.util.ArrayList;

//QProblem Description
//        Given two integers A and B, return all possible combinations of B numbers out of 1 2 3 ... A.
//
//        Make sure the combinations are sorted.
//
//        To elaborate,
//
//        Within every entry, elements should be sorted. [1, 4] is a valid entry while [4, 1] is not.
//        Entries should be sorted within themselves.
//        WARNING: DO NOT USE LIBRARY FUNCTION FOR GENERATING COMBINATIONS.
//
//
//
//        Problem Constraints
//        1 <= A, B <= 10

public class Combinations {
    ArrayList<ArrayList<Integer>> ans=new ArrayList<ArrayList<Integer>>();
    void comb(int i,int A,int B,ArrayList<Integer> curr){
        if(B==0){
            ans.add(new ArrayList<Integer>(curr));
            return;
        }
        if(i>A){
            return;
        }
        curr.add(i);
        comb(i+1,A,B-1,curr);
        curr.remove(curr.size()-1);
        comb(i+1,A,B,curr);

    }
    public ArrayList<ArrayList<Integer>> combine(int A, int B) {

        ArrayList<Integer> curr=new ArrayList<>();
        comb(1,A,B,curr);
        return ans;
    }
    public static void main(String[] args) {
        Combinations I = new Combinations();
        System.out.println(I.combine(8,3));
    }
}


