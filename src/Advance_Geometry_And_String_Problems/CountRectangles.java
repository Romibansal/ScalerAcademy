package Advance_Geometry_And_String_Problems;

import java.util.HashSet;

//Q=Problem Description
//        Given two arrays of integers A and B of size N each, where each pair (A[i], B[i])
//        for 0 <= i < N represents a unique point (x, y) in a 2-D Cartesian plane.
//
//        Find and return the number of unordered quadruplet (i, j, k, l) such that
//        (A[i], B[i]), (A[j], B[j]), (A[k], B[k]) and (A[l], B[l]) form a rectangle with
//        the rectangle having all the sides parallel to either x-axis or y-axis.
//
//
//
//        Problem Constraints
//        1 <= N <= 2000
//        0 <= A[i], B[i] <= 10^9

public class CountRectangles {
    public int solve(int[] A, int[] B) {
        HashSet<String> set =new HashSet<>();
        for(int i=0;i<A.length;i++){
            String s=A[i]+"-"+B[i];
            set.add(s);
        }
        int ans=0;
        for(int i=0;i<A.length;i++){
            int x1=A[i];
            int y1=B[i];
            for(int j=i+1;j<B.length;j++){
                int x2=A[j];
                int y2=B[j];
                if((y1!=y2) && (x1!=x2)){
                    String s1=x1+"-"+y2;
                    String s2=x2+"-"+y1;
                    if(set.contains(s1) && set.contains(s2)){
                        ans++;
                    }
                }
            }
        }
        return ans/2;
    }
    public static void main(String[] args) {
        CountRectangles I = new CountRectangles();
        int[] A=new int[6];
        int[] B=new int[6];
        A[0]=1;A[1]=1;A[2]=2;
        A[3]=2;A[4]=3;A[5]=3;
        B[0]=1;B[1]=2;B[2]=1;
        B[3]=2;B[4]=1;B[5]=2;
        System.out.println(I.solve(A,B));
    }
}






