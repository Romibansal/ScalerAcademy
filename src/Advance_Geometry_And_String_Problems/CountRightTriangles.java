package Advance_Geometry_And_String_Problems;

import java.util.ArrayList;
import java.util.HashMap;

//Q=Problem Description
//        Given two arrays of integers A and B of size N each, where each pair
//        (A[i], B[i]) for 0 <= i < N represents a unique point (x, y) in 2D Cartesian plane.
//
//        Find and return the number of unordered triplets (i, j, k) such that
//        (A[i], B[i]), (A[j], B[j]) and (A[k], B[k]) form a right-angled triangle
//        with the triangle having one side parallel to the x-axis and one side parallel to the y-axis.
//
//        NOTE: The answer may be large so return the answer modulo (109 + 7).
//
//
//
//        Problem Constraints
//        1 <= N <= 10^5
//
//        0 <= A[i], B[i] <= 10^9



public class CountRightTriangles {
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        int mod=(int)Math.pow(10,9)+7;
        HashMap<Integer,Integer> x=new HashMap<>();
        HashMap<Integer,Integer> y=new HashMap<>();
        for(int i=0;i<A.size();i++){
            if(x.containsKey(A.get(i))){
                int value=x.get(A.get(i));
                value++;
                x.put(A.get(i),value);
            }
            else{
                x.put(A.get(i),1);
            }
            if(y.containsKey(B.get(i))){
                int v=y.get(B.get(i));
                v++;
                y.put(B.get(i),v);
            }
            else{
                y.put(B.get(i),1);
            }
        }
        long ans=0;
        for(int i=0;i<A.size();i++){
            int a=x.get(A.get(i));
            int b=y.get(B.get(i));
            long mul=((a-1)*(b-1))%mod;
            ans=(ans%mod+mul%mod)%mod;
        }
        return (int)ans;
    }
    public static void main(String[] args) {
        CountRightTriangles I = new CountRightTriangles();
        ArrayList<Integer>A=new ArrayList<>();
        ArrayList<Integer>B=new ArrayList<>();
        A.add(1);A.add(1);A.add(2);A.add(3);A.add(3);
        B.add(1);B.add(2);B.add(1);B.add(2);B.add(1);

        System.out.println(I.solve(A,B));
    }
}

