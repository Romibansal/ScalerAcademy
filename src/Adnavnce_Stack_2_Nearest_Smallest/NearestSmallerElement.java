package Adnavnce_Stack_2_Nearest_Smallest;

import java.util.ArrayList;
import java.util.Stack;

//Q=Problem Description
//        Given an array A, find the nearest smaller element G[i] for every element A[i] in the array such that the element has an index smaller than i.
//
//        More formally,
//
//        G[i] for an element A[i] = an element A[j] such that
//
//        j is maximum possible AND
//
//        j < i AND
//
//        A[j] < A[i]
//
//        Elements for which no smaller element exist, consider the next smaller element as -1.
//
//
//
//        Problem Constraints
//        1 <= |A| <= 100000
//
//        -10^9 <= A[i] <= 10^9

public class NearestSmallerElement {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        Stack<Integer> stk=new Stack<>();
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<A.size();i++){
            while(!stk.empty() && A.get(stk.peek())>=A.get(i)){
                stk.pop();
            }
            if(stk.empty()){
                ans.add(-1);
            }
            else{
                ans.add(A.get(stk.peek()));
            }
            stk.push(i);
        }
        return ans;
    }
    public static void main(String[] args) {
        NearestSmallerElement I = new NearestSmallerElement();
        ArrayList<Integer> a=new ArrayList<>();
        a.add(4);a.add(5); a.add(2); a.add(10); a.add(8);
        System.out.println(I.prevSmaller(a));
    }
}

