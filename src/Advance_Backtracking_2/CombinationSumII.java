package Advance_Backtracking_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

//Q=Problem Description
//        Given an array of size N of candidate numbers A and a target number B. Return all unique
//        combinations in A where the candidate numbers sums to B.
//
//        Each number in A may only be used once in the combination.
//
//        Note:
//
//        All numbers (including target) will be positive integers.
//        Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
//        The solution set must not contain duplicate combinations.
//        Warning:
//
//        DO NOT USE LIBRARY FUNCTION FOR GENERATING COMBINATIONS.
//
//        Example : itertools.combinations in python. If you do, we will disqualify your
//        submission and give you penalty points.
//
//
//
//        Problem Constraints

//        1 <= N <= 20
//
//
//
//        Input Format

//        First argument is an integer array A denoting the collection of candidate numbers.
//        Second argument is an integer which represents the target number.
//
//
//
//        Output Format

//        Return all unique combinations in A where the candidate numbers sums to B.
//
//
//
//        Example Input

//        Input 1:
//
//        A = [10, 1, 2, 7, 6, 1, 5]
//        B = 8

//        Input 2:
//
//        A = [2, 1, 3]
//        B = 3
//
//
//        Example Output

//        Output 1:
//
//        [
//        [1, 1, 6 ],
//        [1, 2, 5 ],
//        [1, 7 ],
//        [2, 6 ]
//        ]
//        Output 2:
//
//        [
//        [1, 2 ],
//        [3 ]
//        ]
//
//
//        Example Explanation
//        Explanation 1:
//
//        1 + 1 + 6 = 8
//        1 + 2 + 5 = 8
//        1 + 7 = 8
//        2 + 6 = 8

//        All the above combinations sum to 8 and are arranged in ascending order.
//        Explanation 2:
//
//        1 + 2 = 3
//        3 = 3

//        All the above combinations sum to 3 and are arranged in ascending order.


public class CombinationSumII {
    ArrayList<ArrayList<Integer>> result=new ArrayList<>();
    HashSet<ArrayList<Integer>> set=new HashSet<>();
    int valid(ArrayList<Integer> ans){
        int sum=0;
        for(int i=0;i<ans.size();i++){
            sum=sum+ans.get(i);
        }
        return sum;
    }
    void permutation(ArrayList<Integer>A, int B, HashMap<Integer,Integer>map,ArrayList<Integer> ans){
        int sum_curr=valid(ans);
        if(sum_curr==B){
            ArrayList temp = new ArrayList();
            temp= (ArrayList)ans.clone();
            Collections.sort(temp);
            if(!set.contains(temp)) {
                result.add(temp);
                set.add(temp);
            }
            return;
        }
        if(sum_curr>B){
            return;
        }
        for(int i=0;i<A.size();i++){
            if(map.get(A.get(i))>0){
                ans.add(A.get(i));
                int v=map.get(A.get(i));
                v--;
                map.put(A.get(i),v);
                permutation(A,B,map,ans);
                ans.remove(ans.size()-1);
                int t=map.get(A.get(i));
                t++;
                map.put(A.get(i),t);
            }
        }
        return;
    }
    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for (int i=0;i<A.size();i++){
            if(map.containsKey(A.get(i))){
                int v=map.get(A.get(i));
                v++;
                map.put(A.get(i),v);
            }
            else{
                map.put(A.get(i),1);
            }
        }
        ArrayList<Integer>ans=new ArrayList<>();
        permutation(A,B,map,ans);
        return  result;
    }
    public static void main(String[] args) {
        CombinationSumII I = new CombinationSumII();
        ArrayList<Integer>A=new ArrayList<>();
        A.add(10);A.add(1);A.add(2);A.add(7);A.add(6);A.add(1);A.add(5);
        System.out.println( I.combinationSum(A,8));
    }
}


