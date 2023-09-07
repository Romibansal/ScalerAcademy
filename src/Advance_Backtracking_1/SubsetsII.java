package Advance_Backtracking_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;


//Q=Problem Description
//        Given a collection of integers denoted by array A of size N that might contain duplicates,
//        return all possible subsets.
//
//        NOTE:
//
//        Elements in a subset must be in non-descending order.
//        The solution set must not contain duplicate subsets.
//        The subsets must be sorted lexicographically.
//
//
//        Problem Constraints

//        0 <= N <= 16
//
//
//
//        Input Format

//        Only argument is an integer array A of size N.
//
//
//
//        Output Format

//        Return a 2-D vector denoting all the possible subsets.
//
//
//
//        Example Input

//        Input 1:
//
//        A = [1, 2, 2]

//        Input 2:
//
//        A = [1, 1]
//
//
//        Example Output

//        Output 1:
//
//        [
//        [],
//        [1],
//        [1, 2],
//        [1, 2, 2],
//        [2],
//        [2, 2]
//        ]

//        Output 2:
//
//        [
//        [],
//        [1],
//        [1, 1]
//        ]
//
//
//        Example Explanation

//        Explanation 1:
//
//        All the subsets of the array [1, 2, 2] in lexicographically sorted order.


public class SubsetsII {
    void method(int idx, ArrayList<Integer> ans, ArrayList<Integer>A){
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
        HashSet<ArrayList<Integer>> set=new HashSet<>();
        for(int i=0;i<result.size();i++){
            set.add(result.get(i));
        }
        ArrayList<ArrayList<Integer>> temp=new ArrayList<>();
        for(int i=0;i<result.size();i++){
            if(set.contains(result.get(i))){
                temp.add(result.get(i));
                set.remove(result.get(i));
            }
        }
        Collections.sort(temp, (ArrayList < Integer > first, ArrayList < Integer > second) -> {
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

        return temp;
    }
    ArrayList<ArrayList<Integer>> result=new ArrayList<>();
    public static void main(String[] args) {
        SubsetsII I = new SubsetsII();
        ArrayList<Integer>A=new ArrayList<>();
        A.add(1);A.add(2);A.add(2);
        System.out.println( I.subsets(A));
    }
}


