package Advance_Radix_Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//Q=Problem Description
//        We have a list A of points (x, y) on the plane. Find the B closest points to the origin (0, 0).
//
//        Here, the distance between two points on a plane is the Euclidean distance.
//
//        You may return the answer in any order. The answer is guaranteed to be unique
//        (except for the order that it is in.)
//
//        NOTE: Euclidean distance between two points P1(x1, y1) and P2(x2, y2) is sqrt( (x1-x2)2 + (y1-y2)2 ).
//
//        Problem Constraints
//        1 <= B <= length of the list A <= 105
//        -10^5 <= A[i][0] <= 10^5
//        -10^5 <= A[i][1] <= 10^5




public class BClosestPointsToOrigin {
    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A, int B) {
        Collections.sort(A, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                int s=o1.get(0);
                int e=o1.get(1);
                long S= s*s;
                long E=e*e;
                long sum=S+E;

                int s1=o2.get(0);
                int e1=o2.get(1);
                long S1=s1*s1;
                long E1=e1*e1;
                long sum1=S1+E1;

                if(sum>sum1){
                    return 1;
                }
                return -1;
            }
        });
        ArrayList<ArrayList<Integer>> result=new  ArrayList<ArrayList<Integer>>();
        for(int i=0;i<B;i++){
            result.add(A.get(i));
        }
        return result;
    }
    public static void main(String[] args) {
        BClosestPointsToOrigin I = new BClosestPointsToOrigin();
        ArrayList<ArrayList<Integer>>A=new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> a1=new ArrayList<>();
        ArrayList<Integer>a2=new ArrayList<>();
        ArrayList<Integer> a3=new ArrayList<>();
        ArrayList<Integer>a4=new ArrayList<>();


        a1.add(-266);a1.add(119);
        a2.add(-261);a2.add(430);

        a3.add(-188);a3.add(84);
        a4.add(-164);a4.add(387);


        A.add(a1);A.add(a2);A.add(a3);A.add(a4);
        System.out.println(I.solve(A,1));
    }
}