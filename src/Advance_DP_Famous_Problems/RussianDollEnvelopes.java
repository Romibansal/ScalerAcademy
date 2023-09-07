package Advance_DP_Famous_Problems;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//Q=Problem Description
//        Given a matrix of integers A of size N x 2 describing dimensions of N envelopes,
//        where A[i][0] denotes the height of the ith envelope and A[i][1] denotes the width of the ith envelope.
//
//        One envelope can fit into another if and only if both the width and height of one envelope is
//        greater than the width and height of the other envelope.
//
//        Find the maximum number of envelopes you can put one inside other.
//
//
//
//        Problem Constraints
//        1 <= N <= 1000
//        1 <= A[i][0], A[i][1] <= 10^9
//
//
//
//        Input Format
//        The only argument given is the integer matrix A.
//
//
//
//        Output Format
//        Return an integer denoting the maximum number of envelopes you can put one inside other.
//
//
//
//        Example Input
//        Input 1:
//
//        A = [
//        [5, 4]
//        [6, 4]
//        [6, 7]
//        [2, 3]
//        ]
//        Input 2:
//
//        A = [     '
//        [8, 9]
//        [8, 18]
//        ]
//
//
//        Example Output
//        Output 1:
//
//        3
//        Output 2:
//
//        1
//
//
//        Example Explanation

//        Explanation 1:
//
//        Step 1: put [2, 3] inside [5, 4]
//        Step 2: put [5, 4] inside [6, 7]
//        3 envelopes can be put one inside other.

//        Explanation 2:
//
//        No envelopes can be put inside any other so answer is 1.


public class RussianDollEnvelopes {
    class pair{
        int height;
        int width;
        pair(int h,int w){
            height=h;
            width=w;
        }
    }
    public int solve(ArrayList<ArrayList<Integer>> A) {
        ArrayList<pair>p=new ArrayList<>();
        for(int i=0;i<A.size();i++){
            p.add(new pair(A.get(i).get(0),A.get(i).get(1)));
        }
        Collections.sort(p, new Comparator<pair>() {
            @Override
            public int compare(pair o1, pair o2) {
                return o1.height-o2.height;
            }
        });
        int[]len=new int[A.size()];
        for(int i=0;i<p.size();i++){
            len[i]=1;
            for(int j=0;j<i;j++){
                if(p.get(j).height!=p.get(i).height &&  p.get(j).width<p.get(i).width && len[j]+1>len[i]){
                    len[i]=len[j]+1;
                }
            }
        }
        int max=len[0];
        for(int i=0;i<len.length;i++){
            max=Math.max(max,len[i]);
        }
        return max;
    }
    public static void main(String[] args) {
        RussianDollEnvelopes I = new RussianDollEnvelopes();
        ArrayList<ArrayList<Integer>>A=new ArrayList<>();
        ArrayList<Integer>a1=new ArrayList<>();
        a1.add(2);a1.add(3);
        ArrayList<Integer>a2=new ArrayList<>();
        a2.add(5);a2.add( 4);
        ArrayList<Integer>a3=new ArrayList<>();
        a3.add(6);a3.add( 4);
        ArrayList<Integer>a4=new ArrayList<>();
        a4.add(6);a4.add( 7);


        A.add(a1);A.add(a2);
        A.add(a3);A.add(a4);


        System.out.println( I.solve(A));
    }
}


