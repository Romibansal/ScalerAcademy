package Advance_Sorting_1_Selection_And_Merge;

import java.util.ArrayList;


public class SortingWithMergeSort {
    ArrayList<Integer> merge(ArrayList<Integer> A ,ArrayList<Integer> B){
        ArrayList<Integer> ans=new ArrayList<>();
        int i=0;int j=0;
        while(i<A.size() && j<B.size()){
            if(B.get(j)<A.get(i)){
                ans.add(B.get(j));
                j++;
            }
            else{
                ans.add(A.get(i));
                i++;
            }
        }
        while(i<A.size()){
            ans.add(A.get(i));
            i++;
        }
        while(j<B.size()){
            ans.add(B.get(j));
            j++;
        }
        return ans;
    }
    ArrayList<Integer> sort(ArrayList<Integer> A,int st,int end){
        if(st==end){
            ArrayList<Integer> B=new ArrayList<>();
            B.add(A.get(st));
            return B;
        }
        int mid=(end+st)/2;
        ArrayList<Integer> left=sort(A,st,mid);
        ArrayList<Integer> right=sort(A,mid+1,end);
        ArrayList<Integer> x=merge(left,right);
        return x;
    }
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
       ArrayList<Integer>  s=sort(A,0,A.size()-1);
        return s;
    }
    public static void main(String[] args) {
        SortingWithMergeSort I = new SortingWithMergeSort();
        ArrayList<Integer>A=new ArrayList<>();
        A.add(3);A.add( 4);A.add(2);A.add(1);A.add(12);A.add(10);A.add(2);A.add(0);
        System.out.println(I.solve(A));
    }
}
