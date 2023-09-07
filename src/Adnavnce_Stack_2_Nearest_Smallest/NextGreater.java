package Adnavnce_Stack_2_Nearest_Smallest;

import java.util.ArrayList;
import java.util.Stack;

//Q=Problem Description
//        Given an array A, find the next greater element G[i] for every element A[i] in the array.
//        The next greater element for an element A[i] is the first greater element on the
//        right side of A[i] in the array, A.
//
//        More formally:
//
//        G[i] for an element A[i] = an element A[j] such that
//        j is minimum possible AND
//        j > i AND
//        A[j] > A[i]
//        Elements for which no greater element exists, consider the next greater element as -1.
//
//
//
//        Problem Constraints
//        1 <= |A| <= 10^5
//
//        1 <= A[i] <= 10^7

public class NextGreater {
    public int[] nextGreater(int[] A) {
        int[] ans=new int[A.length];
        Stack<Integer> stk=new Stack<>();
        for(int i=A.length-1;i>-1;i--){
            while(!stk.empty() && A[stk.peek()]<=A[i]){
                stk.pop();
            }
            if(stk.empty()){
                ans[i]=-1;
            }
            else{
                ans[i]=A[stk.peek()];
            }
            stk.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        NextGreater I = new NextGreater();
        int[] A=new int[4];
        A[0]=4;A[1]= 5;A[2]= 2;A[3]= 10;
        System.out.println(I.nextGreater(A));
    }
}

