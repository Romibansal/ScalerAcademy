package Advance_Graphs_1_Intro_Dfs_And_Bfs;

//Q=Problem Description
//        Given an directed graph having A nodes. A matrix B of size M x 2
//        is given which represents the M edges such that there is a edge directed
//        from node B[i][0] to node B[i][1].
//
//        Find whether the graph contains a cycle or not, return 1 if cycle is present else return 0.
//
//        NOTE:
//
//        The cycle must contain atleast two nodes.
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
//        The second argument given a matrix B of size M x 2 which represents the M edges such that
//        there is a edge directed from node B[i][0] to node B[i][1].
//
//
//
//        Output Format

//        Return 1 if cycle is present else return 0.
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
//        1
//        Output 2:
//
//        0
//
//
//        Example Explanation

//        Explanation 1:
//
//        The given graph contain cycle 1 -> 3 -> 4 -> 1 or the cycle 1 -> 2 -> 4 -> 1

//        Explanation 2:
//
//        The given graph doesn't contain any cycle.

import java.util.ArrayList;
public class CycleInDirectedGraph {
    int dfs(boolean[] visited,int s,ArrayList<ArrayList<Integer>> a,boolean[] path){
        path[s]=true;
        visited[s]=true;
        for(int i=0;i<a.get(s).size();i++){
            if(path[a.get(s).get(i)]==true){
                return 1;
            }
            if(visited[a.get(s).get(i)]==false){
               if( dfs(visited,a.get(s).get(i),a,path)==1){
                   return 1;
               }
            }
        }
        path[s]=false;
        return 0;
    }
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
        boolean[] path=new boolean[A+1];
        for(int i=1;i<=A;i++){
            if(visited[i]==false){
                if(dfs(visited,i,a,path)==1){
                    return 1;
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        CycleInDirectedGraph I = new CycleInDirectedGraph();
        int[][]A=new int[7][2];
        A[0][0]=1;A[0][1]=2;
        A[1][0]=1; A[1][1]=3;
        A[2][0]=2; A[2][1]=3;
        A[3][0]=1; A[3][1]=4;
        A[4][0]=4; A[4][1]=3;
        A[5][0]=4; A[5][1]=5;
        A[6][0]=3; A[6][1]=5;
        System.out.println( I.solve(5,A));
    }
}



