package Advance_Binary_Search_Problem2;


//Q=Problem Description
//        Given a sorted array of integers A of size N and an integer B,
//        where array A is rotated at some pivot unknown beforehand.
//
//        For example, the array [0, 1, 2, 4, 5, 6, 7] might become [4, 5, 6, 7, 0, 1, 2].
//
//        Your task is to search for the target value B in the array. If found, return its index; otherwise, return -1.
//
//        You can assume that no duplicates exist in the array.
//
//        NOTE: You are expected to solve this problem with a time complexity of O(log(N)).
//
//
//        Problem Constraints
//        1 <= N <= 1000000
//        1 <= A[i] <= 10^9
//        All elements in A are Distinct.


public class RotatedSortedArraySearch {
    int binarysearch(int A[], int target, int st, int end){
        while(st<=end){
            int mid=st+(end-st)/2;
            if(A[mid]==target){
                return mid;
            }
            if(A[mid]<target){
                st=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return -1;
    }
    public int search(final int[] A, int B) {

        int l=0;
        int r=A.length-1;
        int breakpoint=-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if((mid==0 || A[mid]<A[mid-1]) && (mid==A.length-1 || A[mid]<A[mid+1])){
                breakpoint=mid;
                break;
            }
            if(A[0]<A[mid]){
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        if(breakpoint==-1){
            return binarysearch(A,B,0,A.length-1);
        }
        if(A[0]<=B){
            return binarysearch(A,B,0,breakpoint-1);
        }
        else{
            return binarysearch(A,B,breakpoint,A.length-1);
        }
    }
    public static void main(String[] args) {
        RotatedSortedArraySearch I = new RotatedSortedArraySearch();
        int A[]=new int[5];
        A[0]=1;
        A[1]=7;A[2]=67;A[3]=133;A[4]=178;
        System.out.println(I.search(A,1));
    }
}