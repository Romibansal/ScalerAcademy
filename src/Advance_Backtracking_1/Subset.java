package Advance_Backtracking_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;


//Q=Problem Description
//        Given a set of distinct integers A, return all possible subsets.
//
//        NOTE:
//
//        Elements in a subset must be in non-descending order.
//        The solution set must not contain duplicate subsets.
//        Also, the subsets should be sorted in ascending ( lexicographic ) order.
//        The list is not necessarily sorted.
//
//
//        Problem Constraints

//        1 <= |A| <= 16
//        INTMIN <= A[i] <= INTMAX
//
//
//        Input Format

//        First and only argument of input contains a single integer array A.
//
//
//
//        Output Format

//        Return a vector of vectors denoting the answer.
//
//
//
//        Example Input

//        Input 1:
//
//        A = [1]

//        Input 2:
//
//        A = [1, 2, 3]
//
//
//        Example Output

//        Output 1:
//
//        [
//        []
//        [1]
//        ]

//        Output 2:
//
//        [
//        []
//        [1]
//        [1, 2]
//        [1, 2, 3]
//        [1, 3]
//        [2]
//        [2, 3]
//        [3]
//        ]
//
//
//        Example Explanation

//        Explanation 1:
//
//        You can see that these are all possible subsets.

//        Explanation 2:
//
//        You can see that these are all possible subsets.

public class Subset {
    void method(int idx,ArrayList<Integer> ans,ArrayList<Integer>A){
        if(idx==A.size()){
            ArrayList<Integer> temp = new ArrayList<>(ans);
            result.add(temp);
            return;
        }
        method(idx+1,ans,A);
        ans.add(A.get(idx));
        method(idx+1,ans,A);
        ans.remove(ans.size()-1);
    }
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        ArrayList<Integer>ans=new ArrayList<>();
        Collections.sort(A);
        method(0,ans,A);
        Collections.sort(result, (ArrayList < Integer > first, ArrayList < Integer > second) -> {
            for (int i = 0; i < first.size() && i < second.size(); i++) {
                if (first.get(i) < second.get(i)) {
                    return -1;
                }
                if (first.get(i) > second.get(i)) {
                    return 1;
                }
            }
            if (first.size() > second.size()) {
                return 1;
            }
            return -1;
        });

        return result;
    }
    ArrayList<ArrayList<Integer>> result=new ArrayList<>();
    public static void main(String[] args) {
        Subset I = new Subset();
        ArrayList<Integer>A=new ArrayList<>();
        A.add(1);A.add(2);A.add(3);
        System.out.println( I.subsets(A));
    }
}

