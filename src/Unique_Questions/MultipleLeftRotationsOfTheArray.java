package Unique_Questions;

import java.util.ArrayList;


//Q=Problem Description
//        Given an array of integers A and multiple values in B, which represents
//        the number of times array A needs to be left rotated.
//
//        Find the rotated array for each value and return the result in the from of a
//        matrix where ith row represents the rotated array for the ith value in B.





public class MultipleLeftRotationsOfTheArray {
    public ArrayList<ArrayList<Integer>> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        ArrayList<ArrayList<Integer>> C= new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<B.size();i++){
            ArrayList<Integer> s=new ArrayList<Integer>(A.size());
            s.addAll(A);
            for(int j=0;j<A.size();j++){
                int t=(B.get(i)%A.size());
                int u=0;
                if((j-t)<0){
                    u=(j-t+A.size());
                }
                else {
                    u = (j - t);
                }
                s.set(u,A.get(j));
            }
            C.add(s);
        }
        return C;
    }
    public static void main(String args []){
        MultipleLeftRotationsOfTheArray N1=new MultipleLeftRotationsOfTheArray();
        ArrayList<Integer>A=new ArrayList<Integer>(5);
        ArrayList<Integer>B=new ArrayList<Integer>(2);
        A.add(1);A.add(2);A.add(3);A.add(4);A.add(5);
        B.add(2);B.add(3);
        System.out.println( N1.solve(A,B));
    }
}


