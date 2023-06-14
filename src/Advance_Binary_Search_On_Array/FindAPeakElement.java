package Advance_Binary_Search_On_Array;

//Q=Problem Description
//        Given an array of integers A, find and return the peak element in it.
//        An array element is considered a peak if it is not smaller than its neighbors.
//        For corner elements, we need to consider only one neighbor.
//
//        NOTE:
//
//        It is guaranteed that the array contains only a single peak element.
//        Users are expected to solve this in O(log(N)) time. The array may contain duplicate elements.
//
//
//        Problem Constraints
//        1 <= |A| <= 100000
//
//        1 <= A[i] <= 10^9

public class FindAPeakElement {
    public int solve(int[] A) {
        int st=0;
        int n= A.length-1;
        int l=n;
        if(n==0){
            return A[0];
        }

        while(st<=l){
            int mid= st+(l-st)/2;
            if(((mid==0)||(A[mid]>=A[mid-1])) && ((mid==n)||(A[mid]>=A[mid+1]))){
                return A[mid];
            }
            if(mid==0 || A[mid]>A[mid-1]){
                st=mid+1;
            }
            else{
                l=mid-1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        FindAPeakElement I = new FindAPeakElement();
        int A[]=new int[2];
        A[0]=2;A[1]=3;
        System.out.println(I.solve(A));
    }
}