package Advance_DP_Two_Dimension;

import java.util.ArrayList;

//Q=Problem Description
//        Given a triangle, find the minimum path sum from top to bottom.
//        Each step you may move to adjacent numbers on the row below.
//
//        Adjacent numbers for jth column of ith row is jth and (j+1)th column of (i + 1)th row
//
//
//
//        Problem Constraints

//        |A| <= 1000
//
//        A[i] <= 1000
//
//
//
//        Input Format

//        First and only argument is the vector of vector A defining the given triangle
//
//
//
//        Output Format

//        Return the minimum sum
//
//
//
//        Example Input

//        Input 1:
//
//
//        A = [
//        [2],
//        [3, 4],
//        [6, 5, 7],
//        [4, 1, 8, 3]
//        ]

//        Input 2:
//
//        A = [ [1] ]
//
//
//        Example Output

//        Output 1:
//
//        11

//        Output 2:
//
//        1
//
//
//        Example Explanation

//        Explanation 1:
//
//        The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

//        Explanation 2:
//
//        Only 2 can be collected.

public class MinSumPathInTriangle {

    public int minimumTotal(ArrayList<ArrayList<Integer>> a) {
        ArrayList<ArrayList<Integer>> dp=new ArrayList<>();
        for(int i=0;i<a.size();i++){
            ArrayList<Integer>temp=new ArrayList<>();
            for(int j=0;j<a.get(i).size();j++){
                temp.add(a.get(i).get(j));
            }
            dp.add(temp);
        }
        int n=a.size();
        for(int i=n-2;i>-1;i--){
            ArrayList<Integer>temp1=a.get(i);
            for(int j=0;j<temp1.size();j++){
                int x= a.get(i).get(j)+(Math.min(dp.get(i+1).get(j),dp.get(i+1).get(j+1)));
                ArrayList<Integer>t=dp.get(i);
                t.set(j,x);
            }
        }
        return dp.get(0).get(0);
    }
    public static void main(String[] args) {
        MinSumPathInTriangle I = new MinSumPathInTriangle();
        ArrayList<ArrayList<Integer>> A=new ArrayList<>();
        ArrayList<Integer>a1=new ArrayList<>();
        a1.add(2);
        ArrayList<Integer>a2=new ArrayList<>();
        a2.add(3);a2.add(4);

        ArrayList<Integer>a3=new ArrayList<>();
        a3.add(6);a3.add(5);a3.add(7);

        ArrayList<Integer>a4=new ArrayList<>();
        a4.add(4);a4.add(1);a4.add(8);a4.add(3);

        A.add(a1);A.add(a2);A.add(a3);A.add(a4);


        System.out.println( I.minimumTotal(A));
    }
}

