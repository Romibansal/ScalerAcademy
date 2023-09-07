package Adnavnce_Stack_2_Nearest_Smallest;

import java.util.ArrayList;
import java.util.Stack;
//
//Q=Problem Description
//        Given an array of integers A.
//
//        A represents a histogram i.e A[i] denotes the height of the ith histogram's bar. Width of each bar is 1.
//
//        Find the area of the largest rectangle formed by the histogram.
//
//
//
//        Problem Constraints
//        1 <= |A| <= 100000
//
//        1 <= A[i] <= 10000




public class LasrgestReactangleInHistogram {
    public int largestRectangleArea(ArrayList<Integer> A) {
        Stack<Integer> stk=new Stack<>();
        ArrayList<Integer> nearesrt_smallest_left=new ArrayList<>();
        for(int i=0;i<A.size();i++){
            while(!stk.empty() && A.get(stk.peek())>=A.get(i)){
                stk.pop();
            }
            if(stk.empty()){
                nearesrt_smallest_left.add(-1);
            }
            else{
                nearesrt_smallest_left.add(stk.peek());
            }
            stk.push(i);
        }
        Stack<Integer> stk1=new Stack<>();
        ArrayList<Integer> nearesrt_smallest_right=new ArrayList<>();
        for(int i=0;i<A.size();i++){
            nearesrt_smallest_right.add(A.size());
        }
        for(int i=A.size()-1;i>-1;i--){
            while(!stk1.empty() && A.get(stk1.peek())>=A.get(i)){
                stk1.pop();
            }
            if(stk1.empty()){
                nearesrt_smallest_right.set(i,A.size());
            }
            else{
                nearesrt_smallest_right.set(i,stk1.peek());
            }
            stk1.push(i);
        }
        int ans=0;
        for(int i=0;i<A.size();i++){
            int area=(A.get(i)*(nearesrt_smallest_right.get(i)-nearesrt_smallest_left.get(i)-1));
            ans=Math.max(ans,area);
        }
        return ans;
    }

    public static void main(String[] args) {
        LasrgestReactangleInHistogram I = new LasrgestReactangleInHistogram();
        ArrayList<Integer> a=new ArrayList<>();
        a.add(2);a.add(1); a.add(5); a.add(6); a.add(2); a.add(3);
        System.out.println(I.largestRectangleArea(a));
    }
}
