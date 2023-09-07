package Advance_Arrays_3;

import java.util.ArrayList;
import java.util.Collections;


//Q=Problem Description
//        Implement the next permutation, which rearranges numbers into
//        the numerically next greater permutation of numbers for a given array A of size N.
//
//        If such arrangement is not possible, it must be rearranged as the lowest possible order,
//        i.e., sorted in ascending order.
//
//        NOTE:
//
//        The replacement must be in-place, do not allocate extra memory.
//        DO NOT USE LIBRARY FUNCTION FOR NEXT PERMUTATION. Use of Library functions will
//        disqualify your submission retroactively and will give you penalty points.
//
//
//        Problem Constraints
//        1 <= N <= 5 * 10^5
//        1 <= A[i] <= 10^9

public class NextPermutation {
    public ArrayList<Integer> nextPermutation(ArrayList<Integer> A) {
        int n=A.size();
        int i=n-2;
        while(i>-1){
            if(A.get(i)<A.get(i+1)){
                break;
            }
            else{
                i--;
            }
        }
        if(i==-1){
            Collections.sort(A);
            return A;
        }
        int index=i+1;
        int ans=A.get(i+1);
        int j=i+1;
        while(j<A.size()){
            if(A.get(j)<ans && A.get(j)>A.get(i)){
                ans=A.get(j);
                index=j;
            }
            j++;
        }
        int temp=A.get(i);
        A.set(i,A.get(index));
        A.set(index,temp);
        ArrayList<Integer> B=new ArrayList<>();
        for(int k=i+1;k<A.size();k++){
            B.add(A.get(k));
        }
        Collections.sort(B);
        int t=0;
        for(int k=i+1;k<A.size();k++){
            A.set(k,B.get(t));
            t++;
        }
        return A;
    }
    public static void main(String args []){
        NextPermutation R1=new NextPermutation();
       ArrayList<Integer> A=new ArrayList<>();
       A.add(1);A.add(5);A.add(8);A.add(4);A.add(7);A.add(6);A.add(5);A.add(3);A.add(1);
        System.out.println(R1.nextPermutation(A));
    }
}


