package Advance_Backtracking_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

//
//Q=Problem Description
//        Given an array of integers A, the array is squareful if for every pair of adjacent elements,
//        their sum is a perfect square.
//
//        Find and return the number of permutations of A that are squareful.
//
//       Two permutations A1 and A2 differ if and only if there is some index i such that A1[i] != A2[i].
//
//
//
//        Problem Constraints
//        1 <= length of the array <= 12
//
//        1 <= A[i] <= 10^9
//
//
//
//        Input Format

//        The only argument given is the integer array A.
//
//
//
//        Output Format

//        Return the number of permutations of A that are squareful.
//
//
//
//        Example Input

//        Input 1:
//
//        A = [2, 2, 2]

//        Input 2:
//
//        A = [1, 17, 8]
//
//
//        Example Output

//        Output 1:
//
//        1

//        Output 2:
//
//        2
//
//
//        Example Explanation

//        Explanation 1:
//
//        Only permutation is [2, 2, 2], the sum of adjacent element is 4 and 4 and both are perfect square.

//        Explanation 2:
//
//        Permutation are [1, 8, 17] and [17, 8, 1].

public class NumberOfSquarefulArrays {
    boolean check_perfect_square(int sum){
        int temp=(int)Math.sqrt(sum);
        if((temp*temp)==sum){
            return true;
        }
        return  false;
    }
    boolean check(ArrayList<Integer> r){
        for(int i=0;i<r.size()-1;i++){
            int sum=r.get(i)+r.get(i+1);
            if(!check_perfect_square(sum)){
                return false;
            }
        }
        return true;
    }
    ArrayList<ArrayList<Integer>>result =new ArrayList<>();
    HashSet<ArrayList>set=new HashSet<>();
    void permutattion(ArrayList<Integer>A,int idx,HashMap<Integer,Integer> map,int n,int[] ans){
        if(idx==A.size()){
            ArrayList<Integer>temp=new ArrayList<>();
            for(int i=0;i<ans.length;i++){
                temp.add(ans[i]);
            }
            if(!set.contains(temp)) {
                result.add(temp);
                set.add(temp);
            }
            return;
        }
        for(int i=0;i<n;i++){
            if(map.containsKey(A.get(i)) && map.get(A.get(i))>0){
                int v=map.get(A.get(i));
                v--;
                map.put(A.get(i),v);
                ans[idx]=A.get(i);
                if(idx>0) {
                    if (check_perfect_square(ans[idx - 1] + ans[idx])) {
                        permutattion(A, idx + 1, map, n, ans);
                    }
                    v++;
                    map.put(A.get(i), v);
                }
                else{
                    permutattion(A, idx + 1, map, n, ans);
                    v++;
                    map.put(A.get(i), v);
                }
            }
        }
    }
    public int solve(ArrayList<Integer> A) {
        if(A.size()==1){
            if(check_perfect_square(A.get(0))){
                return 1;
            }
            return 0;

        }
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<A.size();i++){
            if(map.containsKey(A.get(i))){
                int v=map.get(A.get(i));
                v++;
                map.put(A.get(i),v);
            }
            else{
                map.put(A.get(i),1);
            }
        }
        int[] ans=new int[A.size()];
        permutattion(A,0,map,A.size(),ans);
        int total_desired_comb=0;
        for(int i=0;i<result.size();i++){
            if(check(result.get(i))){
                total_desired_comb++;
            }
        }
        return total_desired_comb;
    }
    public static void main(String[] args) {
        NumberOfSquarefulArrays I = new NumberOfSquarefulArrays();
        ArrayList<Integer>A=new ArrayList<>();
        A.add(428);A.add(56);A.add(88);A.add(12);
        System.out.println( I.solve(A));
    }
}