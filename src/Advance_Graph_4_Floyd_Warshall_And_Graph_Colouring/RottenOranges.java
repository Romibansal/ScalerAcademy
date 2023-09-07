package Advance_Graph_4_Floyd_Warshall_And_Graph_Colouring;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//Q=Problem Description
//        Given a matrix of integers A of size N x M consisting of 0, 1 or 2.
//
//        Each cell can have three values:
//
//        The value 0 representing an empty cell.
//
//        The value 1 representing a fresh orange.
//
//        The value 2 representing a rotten orange.
//
//        Every minute, any fresh orange that is adjacent (Left, Right, Top, or Bottom) to
//        a rotten orange becomes rotten. Return the minimum number of minutes that must
//        elapse until no cell has a fresh orange. If this is impossible, return -1 instead.
//
//        Note: Your solution will run on multiple test cases. If you are using global variables,
//        make sure to clear them.
//
//
//
//        Problem Constraints

//        1 <= N, M <= 1000
//
//        0 <= A[i][j] <= 2
//
//
//
//        Input Format

//        The first argument given is the integer matrix A.
//
//
//
//        Output Format

//        Return the minimum number of minutes that must elapse until no cell has a fresh orange.
//
//        If this is impossible, return -1 instead.
//
//
//
//        Example Input

//        Input 1:
//
//        A = [   [2, 1, 1]
//        [1, 1, 0]
//        [0, 1, 1]   ]

//        Input 2:
//
//
//        A = [   [2, 1, 1]
//        [0, 1, 1]
//        [1, 0, 1]   ]
//
//
//        Example Output

//        Output 1:
//
//        4

//        Output 2:
//
//        -1
//
//
//        Example Explanation

//        Explanation 1:
//
//        Minute 0: [ [2, 1, 1]
//        [1, 1, 0]
//        [0, 1, 1] ]

//        Minute 1: [ [2, 2, 1]
//        [2, 1, 0]
//        [0, 1, 1] ]

//        Minute 2: [ [2, 2, 2]
//        [2, 2, 0]
//        [0, 1, 1] ]

//        Minute 3: [ [2, 2, 2]
//        [2, 2, 0]
//        [0, 2, 1] ]

//        Minute 4: [ [2, 2, 2]
//        [2, 2, 0]
//        [0, 2, 2] ]

//        At Minute 4, all the oranges are rotten.

//        Explanation 2:
//
//        The fresh orange at 2nd row and 0th column cannot be rotten, So return -1.

public class RottenOranges {
    class pair{
        int x;
        int y;
        pair(int i,int j){
            x=i;
            y=j;
        }
    }
    public int solve(ArrayList<ArrayList<Integer>> A) {
        Queue<pair> q=new LinkedList<>();
        for(int i=0;i<A.size();i++){
            for(int j=0;j<A.get(0).size();j++){
                if(A.get(i).get(j)==2){
                    q.add(new pair(i,j));
                }
            }
        }
        int time=0;
        while(!q.isEmpty()){
            int temp=q.size();
            while(temp>0){
                pair p=q.poll();
                int x=p.x;
                int y=p.y;
                if(x-1>=0 && y>=0 && x-1<A.size() && y<A.get(0).size() && A.get(x-1).get(y)==1){
                    A.get(x-1).set(y,2);
                    q.add(new pair(x-1,y));
                }
                if(x+1>=0 && y>=0 && x+1<A.size() && y<A.get(0).size() && A.get(x+1).get(y)==1){
                    A.get(x+1).set(y,2);
                    q.add(new pair(x+1,y));
                }
                if(x>=0 && y-1>=0 && x<A.size() && y-1<A.get(0).size() && A.get(x).get(y-1)==1){
                    A.get(x).set(y-1,2);
                    q.add(new pair(x,y-1));
                }
                if(x>=0 && y+1>=0 && x<A.size() && y+1<A.get(0).size() && A.get(x).get(y+1)==1){
                    A.get(x).set(y+1,2);
                    q.add(new pair(x,y+1));
                }
                temp--;
            }
            time++;
        }
        for(int i=0;i<A.size();i++){
            for(int j=0;j<A.get(0).size();j++){
                if(A.get(i).get(j)==1){
                    return -1;
                }
            }
        }
        return time-1;
    }
    public static void main(String[] args) {
        RottenOranges I = new RottenOranges();
        ArrayList<ArrayList<Integer>>B=new ArrayList<>();
        ArrayList<Integer>b1=new ArrayList<>();
        ArrayList<Integer>b2=new ArrayList<>();
        ArrayList<Integer>b3=new ArrayList<>();

        b1.add(2);b1.add( 1);b1.add( 1);
        b2.add(1);b2.add( 1);b2.add( 0);
        b3.add( 0);b3.add( 1) ;b3.add( 1) ;

        B.add(b1);B.add(b2);B.add(b3);
        System.out.println( I.solve(B));
    }
}



