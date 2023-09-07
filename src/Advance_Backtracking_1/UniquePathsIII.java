package Advance_Backtracking_1;

import java.util.ArrayList;
import java.util.PriorityQueue;
//
//Q=Problem Description
//        Given a matrix of integers A of size N x M . There are 4 types of squares in it:
//
//        1. 1 represents the starting square.  There is exactly one starting square.
//        2. 2 represents the ending square.  There is exactly one ending square.
//        3. 0 represents empty squares we can walk over.
//        4. -1 represents obstacles that we cannot walk over.
//        Find and return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.
//
//        Note: Rows are numbered from top to bottom and columns are numbered from left to right.
//
//
//
//        Problem Constraints
//        2 <= N * M <= 20
//        -1 <= A[i] <= 2
//
//
//
//        Input Format
//        The first argument given is the integer matrix A.
//
//
//
//        Output Format
//        Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.
//
//
//
//        Example Input
//        Input 1:
//
//        A = [   [1, 0, 0, 0]
//        [0, 0, 0, 0]
//        [0, 0, 2, -1]   ]
//        Input 2:
//
//        A = [   [0, 1]
//        [2, 0]    ]
//
//
//        Example Output
//        Output 1:
//
//        2
//        Output 2:
//
//        0
//
//
//        Example Explanation
//        Explanation 1:
//
//        We have the following two paths:
//        1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
//        2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
//        Explanation 1:
//
//        Answer is evident here.

public class UniquePathsIII {
    int ans=0;
    void backtracking(int i,int j,ArrayList<ArrayList<Integer>> A,int count){
        if( i>=A.size() || j>=A.get(0).size() || i<0|| j<0 ||
                A.get(i).get(j)==-1 || A.get(i).get(j)==3 ){
            return;
        }
        if(A.get(i).get(j)==2 ){
            if(count==-1){
                ans++;
            }
            return;
        }
        ArrayList<Integer> temp=A.get(i);
        temp.set(j,3);

        backtracking(i-1,j,A,count-1);
        backtracking(i+1,j,A,count-1);
        backtracking(i,j-1,A,count-1);
        backtracking(i,j+1,A,count-1);
        temp.set(j,0);

    }
    public int solve(ArrayList<ArrayList<Integer>> A) {
        int start_i=0;
        int start_j=0;
        int count=0;
        for(int i=0;i<A.size();i++){
            for(int j=0;j<A.get(i).size();j++){
                if(A.get(i).get(j)==1){
                    start_i=i;
                    start_j=j;
                }
                if(A.get(i).get(j)==0){
                    count++;
                }
            }
        }
        backtracking(start_i,start_j,A,count);
        return ans;
    }
    public static void main(String[] args) {
        UniquePathsIII I = new UniquePathsIII();
        ArrayList<ArrayList<Integer>>A=new ArrayList<>();
        ArrayList<Integer>a1=new ArrayList<>();
        a1.add(0);a1.add(1);
        ArrayList<Integer>a2=new ArrayList<>();
        a2.add(2);a2.add(0);

        A.add(a1);A.add(a2);
        System.out.println( I.solve(A));
    }
}








