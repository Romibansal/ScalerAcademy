package Advance_Binary_Search_Problem3;

//Q=Problem Description
//        Given an array of integers A of size N and an integer B.
//
//        The College library has N books. The ith book has A[i] number of pages.
//
//        You have to allocate books to B number of students so that the maximum number
//        of pages allocated to a student is minimum.
//
//        A book will be allocated to exactly one student.
//        Each student has to be allocated at least one book.
//        Allotment should be in contiguous order, for example:
//        A student cannot be allocated book 1 and book 3, skipping book 2.
//        Calculate and return that minimum possible number.
//
//        NOTE: Return -1 if a valid assignment is not possible.
//
//        Problem Constraints
//        1 <= N <= 10^5
//        1 <= A[i], B <= 10^5


public class AllocateBooks {
    int numberofstudents(int[] A,int pages){
        int count=1;
        int x=pages;
        for(int i=0;i<A.length;i++){
            if((A[i])<=x){
                x=x-A[i];
            }
            else{
                count++;
                x=pages-A[i];
            }
        }
        return count;
    }
    public int books(int[] A, int B) {
        if(B>A.length){
            return -1;
        }
        int sum=0;
        int max=A[0];
        for(int i=0;i<A.length;i++){
            sum=sum+A[i];
            max=Math.max(A[i],max);
        }
        int r=sum;
        int l=max;
        int ans=r;
        while(l<=r){
            int mid=l+(r-l)/2;
            int students=numberofstudents(A,mid);
            if(students<=B){
                ans=mid;
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        AllocateBooks I = new AllocateBooks();
        int A[]=new int [3];
        A[0] =12;A[1] = 15;A[2] =78;
        System.out.println(I.books(A,4));
    }
}


