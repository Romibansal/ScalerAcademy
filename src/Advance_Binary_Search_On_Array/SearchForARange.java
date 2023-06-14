package Advance_Binary_Search_On_Array;

//Q=Problem Description
//        Given a sorted array of integers A (0-indexed) of size N, find the starting
//        and the ending position of a given integer B in array A.
//
//        Return an array of size 2, such that
//        First element = Starting position of B in A
//        Second element = Ending position of B in A.
//        If B is not found in A, return [-1, -1].
//
//        Note :
//        Your algorithm's runtime complexity must be in the order of O(log n).
//
//
//        Problem Constraints
//        1 <= N <= 10^6
//        1 <= A[i], B <= 10^9

public class SearchForARange {
    public int[] searchRange(final int[] A, int B) {

        int st=0;
        int l=A.length-1;
        int result[]=new int[2];
        result[0]=-1;result[1]=-1;
        while(st<=l){
            int mid= st+(l-st)/2;
            if(A[mid]==B && (mid==0 || A[mid-1]!=B)){
                result[0]=mid;
                break;
            }
            if(A[mid]<B){
                st=mid+1;
            }
            else{
                l=mid-1;
            }
        }
        st=0;
        l=A.length-1;
        while(st<=l){
            int mid= st+(l-st)/2;
            if(A[mid]==B && (mid==A.length-1 || A[mid+1]!=B)){
                result[1]=mid;
            }
            if(A[mid]>B){
                l=mid-1;
            }
            else{
                st=mid+1;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        SearchForARange I = new SearchForARange();
        int A[]=new int[6];
        A[0]=1;A[1]=1;
        A[2]= 2;A[3]= 2;A[4]= 2;A[5]= 2;
        System.out.println(I.searchRange(A,1));
    }
}