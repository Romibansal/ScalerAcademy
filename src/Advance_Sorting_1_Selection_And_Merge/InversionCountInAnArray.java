package Advance_Sorting_1_Selection_And_Merge;

import java.util.ArrayList;

//Q=Problem Description
//        Given an array of integers A. If i < j and A[i] > A[j], then the pair (i, j)
//        is called an inversion of A. Find the total number of inversions of A modulo (10^9 + 7).
//
//        Problem Constraints
//        1 <= length of the array <= 10^5
//
//        1 <= A[i] <= 10^9


public class InversionCountInAnArray {
    int ans;
    void merge(ArrayList<Integer> A,int st,int mid,int end){
        int n=(mid-st)+1;
        int m=end-(mid+1)+1;
        int mod=(int)Math.pow(10,9)+7;
        ArrayList<Integer> a=new ArrayList<>();
        ArrayList<Integer> b=new ArrayList<>();
        for(int i=st;i<=mid;i++){
            a.add(A.get(i));
        }
        for(int j=mid+1;j<=end;j++){
            b.add(A.get(j));
        }
        int k=st;
        int i=0;
        int j=0;
        while(i<n && j<m){
            if(a.get(i)<=b.get(j)){
                A.set(k,a.get(i));
                i++;k++;
            }
            else{
                A.set(k,b.get(j));
                long l=(ans%mod+(n-i)%mod)%mod;
                ans=(int)l;
                j++;k++;
            }
        }
        while(i<n){
            A.set(k,a.get(i));
            i++;k++;
        }
        while(j<m){
            A.set(k,b.get(j));
            j++;k++;
//            long h=(ans%mod+(n-i)%mod)%mod;
//            ans=(int)h;
        }
    }
    void sort(ArrayList<Integer> A,int st,int end){
        if(st==end){
            return ;
        }
        int mid=(end+st)/2;
        sort(A,st,mid);
        sort(A,mid+1,end);
        merge(A,st,mid,end);
    }
    public int solve(ArrayList<Integer> A) {
        ans=0;
        sort(A,0,A.size()-1);
        return ans;
    }
    public static void main(String[] args) {
        InversionCountInAnArray I = new InversionCountInAnArray();
        ArrayList<Integer>A=new ArrayList<>();
        A.add(3);A.add( 4);A.add(1);A.add(2);
        System.out.println(I.solve(A));
    }
}

