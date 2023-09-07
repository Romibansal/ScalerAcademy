package Advance_Graphs_1_Intro_Dfs_And_Bfs;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
//
//Q=Problem Description
//        Given an directed graph having A nodes labelled from 1 to A containing M
//        edges given by matrix B of size M x 2such that there is a edge directed from node
//
//        B[i][0] to node B[i][1].
//
//        Find whether a path exists from node 1 to node A.
//
//        Return 1 if path exists else return 0.
//
//        NOTE:
//
//        There are no self-loops in the graph.
//        There are no multiple edges between two nodes.
//        The graph may or may not be connected.
//        Nodes are numbered from 1 to A.
//        Your solution will run on multiple test cases. If you are using global variables make sure to clear them.
//
//
//        Problem Constraints

//        2 <= A <= 10^5
//
//        1 <= M <= min(200000,A*(A-1))
//
//        1 <= B[i][0], B[i][1] <= A
//
//
//
//        Input Format

//        The first argument given is an integer A representing the number of nodes in the graph.
//
//        The second argument given a matrix B of size M x 2 which represents the M edges such that there
//        is a edge directed from node B[i][0] to node B[i][1].
//
//
//
//        Output Format

//        Return 1 if path exists between node 1 to node A else return 0.
//
//
//
//        Example Input

//        Input 1:
//
//        A = 5
//        B = [  [1, 2]
//        [4, 1]
//        [2, 4]
//        [3, 4]
//        [5, 2]
//        [1, 3] ]

//        Input 2:
//
//        A = 5
//        B = [  [1, 2]
//        [2, 3]
//        [3, 4]
//        [4, 5] ]
//
//
//        Example Output

//        Output 1:
//
//        0

//        Output 2:
//
//        1
//
//
//        Example Explanation

//        Explanation 1:
//
//        The given doens't contain any path from node 1 to node 5 so we will return 0.

//        Explanation 2:
//
//        Path from node1 to node 5 is ( 1 -> 2 -> 3 -> 4 -> 5 ) so we will return 1.

public class PathInDirectedGraph {
    public int solve(int A, int[][] B) {
        ArrayList<ArrayList<Integer>> a=new ArrayList<>();
        for(int i=0;i<=A;i++){
            a.add(new ArrayList<>());
        }
        for(int i=0;i<B.length;i++){
            int idx=B[i][0];
            a.get(idx).add(B[i][1]);
        }
        boolean[] visited=new boolean[A+1];
        Queue<Integer> q=new LinkedList<>();
        q.add(1);
        visited[1]=true;
        while(!q.isEmpty()){
            int u=q.poll();
            if(u==A){
                return 1;
            }
            for(int i=0;i<a.get(u).size();i++){
                int v = a.get(u).get(i);
                if(visited[v] == false){
                    q.add(v);
                    visited[v] = true;
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        PathInDirectedGraph I = new PathInDirectedGraph();
        int[][]A=new int[4][2];
        A[0][0]=1;A[0][1]=2;
        A[1][0]=2; A[1][1]=3;
        A[2][0]=3; A[2][1]=4;
        A[3][0]=4; A[3][1]=5;
        System.out.println( I.solve(5,A));
    }
}



