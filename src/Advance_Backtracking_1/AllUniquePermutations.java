package Advance_Backtracking_1;

import java.util.ArrayList;


//Q=Problem Description
//        Given an array A of size N denoting collection of numbers that might contain duplicates,
//        return all possible unique permutations.
//
//        NOTE: No 2 entries in the permutation sequence should be the same.
//
//        WARNING: DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS.

//        Example : next_permutations in C++ / itertools.permutations in python.
//        If you do, we will disqualify your submission retroactively and give you penalty points.
//
//
//        Problem Constraints

//        1 <= |A| <= 9
//
//        0 <= A[i] <= 10
//
//
//
//        Input Format

//        Only argument is an integer array A of size N.
//
//
//
//        Output Format

//        Return a 2-D array denoting all possible unique permutation of the array.
//
//
//
//        Example Input

//        Input 1:
//
//        A = [1, 1, 2]

//        Input 2:
//
//        A = [1, 2]
//
//
//        Example Output

//        Output 1:
//
//        [ [1,1,2]
//        [1,2,1]
//        [2,1,1] ]

//        Output 2:
//
//        [ [1, 2]
//        [2, 1] ]
//
//
//        Example Explanation

//        Explanation 1:
//
//        All the possible unique permutation of array [1, 1, 2].

//        Explanation 2:
//
//        All the possible unique permutation of array [1, 2].


public class AllUniquePermutations {
    void permutation(ArrayList<Integer> A, int idx, int ans[],int freq[]){
        if(idx ==A.size()){
            ArrayList<Integer>temp=new ArrayList<>();
            for(int j=0;j<ans.length;j++) {
                temp.add(ans[j]);
            }
            result.add(temp);
            return;
        }
        for(int i=0;i<11;i++){
            if(freq[i]>0){
                ans[idx]=i;
                freq[i]--;
                permutation(A,idx+1,ans,freq);
                freq[i]++;
            }
        }
    }
    ArrayList<ArrayList<Integer>> result=new ArrayList<>();

    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        int[] ans =new int[A.size()];
        int[] freq=new int [11];
        for(int i=0;i<A.size();i++){
            int j=A.get(i);
            freq[j]=freq[j]+1;
        }
        permutation(A,0,ans,freq);
        return  result;
    }
    public static void main(String[] args) {
        AllUniquePermutations I = new AllUniquePermutations();
        ArrayList<Integer>A=new ArrayList<>();
        A.add(1);A.add( 1);A.add(2);


        System.out.println( I.permute(A));
    }
}








