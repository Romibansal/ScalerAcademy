package Advance_Backtracking_1;

import java.util.ArrayList;
//
//Q=Problem Description
//        Given an integer array A of size N denoting collection of numbers , return all possible permutations.
//
//        NOTE:
//
//        No two entries in the permutation sequence should be the same.
//        For the purpose of this problem, assume that all the numbers in the collection are unique.
//        Return the answer in any order
//        WARNING: DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS.
//        Example : next_permutations in C++ / itertools.permutations in python.
//        If you do, we will disqualify your submission retroactively and give you penalty points.
//
//
//        Problem Constraints
//        1 <= N <= 9
//
//
//
//        Input Format

//        Only argument is an integer array A of size N.
//
//
//
//        Output Format

//        Return a 2-D array denoting all possible permutation of the array.
//
//
//
//        Example Input
//        A = [1, 2, 3]
//
//
//        Example Output
//        [ [1, 2, 3]
//        [1, 3, 2]
//        [2, 1, 3]
//        [2, 3, 1]
//        [3, 1, 2]
//        [3, 2, 1] ]
//
//
//        Example Explanation

//        All the possible permutation of array [1, 2, 3].


public class Permutations {
    void pemutation(ArrayList<Integer> A, int idx, int ans[], ArrayList<Integer>visited){
        if(idx ==A.size()){
            ArrayList<Integer> temp=new ArrayList<>();
            for(int j=0;j<ans.length;j++) {
                temp.add(ans[j]);
            }
            result.add(temp);
            return;
        }
        for(int i=0;i<A.size();i++){
            if(visited.get(i)==0){
                visited.set(i,1);
                int c=A.get(i);
                ans[idx]=c;
                pemutation(A,idx+1,ans,visited);
                visited.set(i,0);
            }
        }
    }
    ArrayList<ArrayList<Integer>>result=new ArrayList<>();

    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        int[] ans =new int[A.size()];
        ArrayList<Integer>visited=new ArrayList<>();
        for(int i=0;i<A.size();i++){
            visited.add(0);
        }
        pemutation(A,0,ans,visited);
        return  result;
    }
    public static void main(String[] args) {
        Permutations I = new Permutations();
        ArrayList<Integer>A=new ArrayList<>();
        A.add(1);A.add( 2);A.add(3);


        System.out.println( I.permute(A));
    }
}







