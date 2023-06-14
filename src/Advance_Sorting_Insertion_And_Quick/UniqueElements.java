package Advance_Sorting_Insertion_And_Quick;
import java.util.ArrayList;
import java.util.Collections;

//Q=Problem Description
//        You are given an array A of N elements. You have to make all elements unique.
//        To do so, in one step you can increase any number by one.
//
//        Find the minimum number of steps.
//
//
//
//        Problem Constraints
//        1 <= N <= 10^5
//        1 <= A[i] <= 10^9

public class UniqueElements {
    public int solve(ArrayList<Integer> A) {
        Collections.sort(A);
        int steps=0;
        for(int i=0;i<A.size()-1;i++){
            if(A.get(i)<A.get(i+1)){
                continue;
            }
            else{
                steps=steps+(A.get(i)-A.get(i+1))+1;
                A.set(i+1,A.get(i)+1);
            }
        }
        return steps;
    }
    public static void main(String[] args) {
        UniqueElements I = new UniqueElements();
        ArrayList<Integer>A=new ArrayList<>();
        A.add(1);A.add( 1);A.add(3);
        System.out.println(I.solve(A));
    }
}

