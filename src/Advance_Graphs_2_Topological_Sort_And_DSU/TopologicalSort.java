package Advance_Graphs_2_Topological_Sort_And_DSU;

import java.util.ArrayList;
import java.util.PriorityQueue;

//Q=Problem Description
//        Given an directed acyclic graph having A nodes. A matrix B of size M x 2
//        is given which represents the M edges such that there is a edge directed
//        from node B[i][0] to node B[i][1].
//
//        Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of
//        vertices such that for every directed edge uv, vertex u comes before v in the ordering.
//        Topological Sorting for a graph is not possible if the graph is not a DAG.
//
//        Return the topological ordering of the graph and if it doesn't exist then return an empty array.
//
//        If there is a solution return the correct ordering. If there are multiple solutions print the
//        lexographically smallest one.
//
//        Ordering (a, b, c) is said to be lexographically smaller than ordering (e, f, g)
//        if a < e or if(a==e) then b < f and so on.
//
//        NOTE:
//
//        There are no self-loops in the graph.
//        The graph may or may not be connected.
//        Nodes are numbered from 1 to A.
//        Your solution will run on multiple test cases. If you are using global variables make sure to clear them.
//
//
//        Problem Constraints

//        2 <= A <= 10^4
//
//        1 <= M <= min(100000,A*(A-1))
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
//        Return a one-dimensional array denoting the topological ordering of the graph and it it
//        doesn't exist then return empty array.
//
//
//
//        Example Input


//        Input 1:
//
//        A = 6

//        B = [  [6, 3]
//        [6, 1]
//        [5, 1]
//        [5, 2]
//        [3, 4]
//        [4, 2] ]

//        Input 2:
//
//        A = 3

//        B = [  [1, 2]
//        [2, 3]
//        [3, 1] ]
//
//
//        Example Output

//        Output 1:
//
//        [5, 6, 1, 3, 4, 2]

//        Output 2:
//
//        []
//
//
//        Example Explanation

//        Explanation 1:
//
//        The given graph contain no cycle so topological ordering exists which is [5, 6, 1, 3, 4, 2]

//        Explanation 2:
//
//        The given graph contain cycle so topological ordering not possible we will return empty array.

public class TopologicalSort {
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
    // Cheacking cycling or not
    public int cyclic(int A, int[][] B) {
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

    public int[] solve(int A, int[][] B) {
        if(cyclic(A,B)==1){
            return new int[0];  // If cycle is present cannot do topological sorting
        }
        ArrayList<ArrayList<Integer>> a=new ArrayList<>();
        for(int i=0;i<=A;i++){
            a.add(new ArrayList<Integer>());
        }
        for(int i=0;i<B.length;i++){
            int parent=B[i][0];
            int child=B[i][1];
            a.get(parent).add(child);
        }
        int[] indegree=new int[A+1];
        for(int i=1;i<=A;i++){
            for(int j=0;j<a.get(i).size();j++){
                indegree[a.get(i).get(j)]++;
            }
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=1;i<indegree.length;i++){
            if(indegree[i]==0){
                pq.add(i);
            }
        }
        int[]result=new int[A];
        int j=0;
        while(!pq.isEmpty()) {
            int element = pq.poll();
            result[j] = element;
            j++;
            for(int i=0;i<a.get(element).size();i++){
                indegree[a.get(element).get(i)]--;
                if(indegree[a.get(element).get(i)]==0){
                    pq.add(a.get(element).get(i));
                }
            }
        }


        return result;
    }
    public static void main(String[] args) {
        TopologicalSort I = new TopologicalSort();
        int[][] A=new int[6][2];
        A[0][0]=6;A[0][1]=3;
        A[1][0]=6;A[1][1]=1;
        A[2][0]=5;A[2][1]=1;
        A[3][0]=5;A[3][1]=2;
        A[4][0]=3;A[4][1]=4;
        A[5][0]=4;A[5][1]=2;


        System.out.println( I.solve(6,A));
    }
}


