package Advance_Binary_Search_On_Array;

import java.util.ArrayList;

//Q=Problem Description
//
//        You are given a sorted array A of size N and a target value B.
//        Your task is to find the index (0-based indexing) of the target value in the array.
//
//        If the target value is present, return its index.
//        If the target value is not found, return the index where it
//        would be inserted to maintain the sorted order.
//        Your solution should have a time complexity of O(log(N)).
//
//        Problem Constraints
//
//        1 <= N <= 10^6

public class SortedInsertPosition {
    public int searchInsert(ArrayList<Integer> A, int B) {
        int st=0;
        int l=A.size()-1;
        while(st<=l){
            int mid=st+((l-st)/2);
            if(A.get(mid)==B){
                return mid;
            }
            if(A.get(mid)<B){
                st=mid+1;
            }
            else{
                l=mid-1;
            }
        }
        return st;
    }
    public static void main(String[] args) {
        SortedInsertPosition I = new SortedInsertPosition();
        ArrayList<Integer>A=new ArrayList<>();
        A.add(1);A.add(4);A.add(9);
        System.out.println(I.searchInsert(A,5));
    }
}

