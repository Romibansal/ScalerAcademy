package Advance_Graphs_1_Intro_Dfs_And_Bfs;

import java.util.ArrayList;

//Q=Problem Description

//        Find largest distance Given an arbitrary unweighted rooted tree which consists of N (2 <= N <= 40000)
//        nodes.
//
//        The goal of the problem is to find largest distance between two nodes in a tree. Distance
//        between two nodes is a number of edges on a path between the nodes (there will be a unique path between any pair of nodes since it is a tree).
//
//        The nodes will be numbered 0 through N - 1.
//
//        The tree is given as an array A, there is an edge between nodes A[i] and i (0 <= i < N).
//        Exactly one of the i's will have A[i] equal to -1, it will be root node.
//
//
//
//        Problem Constraints

//        2 <= |A| <= 40000
//
//
//
//        Input Format

//        First and only argument is vector A
//
//
//
//        Output Format

//        Return the length of the longest path
//
//
//
//        Example Input

//        Input 1:
//
//
//        A = [-1, 0]

//        Input 2:
//
//
//        A = [-1, 0, 0]
//
//
//        Example Output

//        Output 1:
//
//        1

//        Output 2:
//
//        2
//
//
//        Example Explanation

//        Explanation 1:
//
//        Path is 0 -> 1.

//        Explanation 2:
//
//        Path is 1 -> 0 -> 2.


public class LargestDistanceBetweenNodesOfATree {
    class pair{
        int node;
        int dis;
        pair(int n,int d){
            node=n;
            dis=d;
        }
    }
    pair dfs(ArrayList < ArrayList < Integer >> adj, int src, boolean[] vis,int dis,pair p) {
        if(dis>p.dis){
            p.node=src;
            p.dis=dis;
        }
        for(int i=0;i<adj.get(src).size();i++){
            if(vis[adj.get(src).get(i)]==false){
                vis[adj.get(src).get(i)]=true;
                dfs(adj,adj.get(src).get(i),vis,dis+1,p);
            }
        }
      return p;
    }

    public int solve(int[] A) {
        int n=A.length;
        ArrayList<ArrayList<Integer>> a=new ArrayList<>();
        for(int i=0;i<n;i++){
            a.add(new ArrayList<>());
        }
        for(int i=0;i<A.length;i++){
            if(A[i]!=-1){
                int parent = A[i];
                a.get(parent).add(i);
                a.get(i).add(parent);
            }
        }
        boolean[] visited=new boolean[n];
        visited[0]=true;
        pair p=new pair(0,0);
        p=dfs(a,0,visited,0,p);
        visited=new boolean[n];
        visited[p.node]=true;
        pair p1=new pair(p.node,0);
        p1=dfs(a,p.node,visited,0,p1);
        return p1.dis;
    }
    public static void main(String[] args) {
        LargestDistanceBetweenNodesOfATree I = new LargestDistanceBetweenNodesOfATree();
        int[]A=new int[6];
       A[0]=-1;A[1]=0;A[2]=1;A[3]=1;A[4]=0;A[5]=4;
        System.out.println( I.solve(A));
    }
}




