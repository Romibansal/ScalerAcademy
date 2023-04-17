package Subarrays;

import java.util.ArrayList;

//Q=Problem Description
//        You are given an array A of N integers.
//        Return a 2D array consisting of all the subarrays of the array
//
//
//        Problem Constraints
//        1 <= N <= 100
//        1 <= A[i] <= 10^5



public class GenerateAllSubarrays {
    public ArrayList<ArrayList<Integer>> solve(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer> > a= new ArrayList<ArrayList<Integer> >();

        for(int i=0;i<A.size();i++){
            ArrayList<Integer> temp=new ArrayList<Integer>();
            for(int j=i;j<A.size();j++){
                temp.add(A.get(j));
                a.add((ArrayList)temp.clone());
            }
        }
        return a;
    }
    public static void main(String args[]) {
        GenerateAllSubarrays N1 = new GenerateAllSubarrays();
        ArrayList<Integer>A=new ArrayList<>();
        A.add(5);A.add(2);A.add(1);A.add(1);
        System.out.println(N1.solve(A));
    }
}

