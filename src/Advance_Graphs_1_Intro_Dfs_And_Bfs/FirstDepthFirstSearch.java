package Advance_Graphs_1_Intro_Dfs_And_Bfs;


import java.util.ArrayList;


//Q=Problem Description
//        You are given N towns (1 to N). All towns are connected via unique directed path as
//        mentioned in the input.
//
//        Given 2 towns find whether you can reach the first town from the second without repeating any edge.
//
//        B C : query to find whether B is reachable from C.
//
//        Input contains an integer array A of size N and 2 integers B and C ( 1 <= B, C <= N ).
//
//        There exist a directed edge from A[i] to i+1 for every 1 <= i < N. Also, it's guaranteed that A[i] <= i for every 1 <= i < N.
//
//        NOTE: Array A is 0-indexed. A[0] = 1 which you can ignore as it doesn't represent any edge.
//
//
//
//        Problem Constraints

//        1 <= N <= 100000
//
//
//
//        Input Format

//        First argument is vector A
//
//        Second argument is integer B
//
//        Third argument is integer C
//
//
//
//        Output Format

//        Return 1 if reachable, 0 otherwise.
//
//
//
//        Example Input

//        Input 1:
//
//        A = [1, 1, 2]
//        B = 1
//        C = 2

//        Input 2:
//
//        A = [1, 1, 2]
//        B = 2
//        C = 1
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
//        Tree is 1--> 2--> 3 and hence 1 is not reachable from 2.

//        Explanation 2:
//
//        Tree is 1--> 2--> 3 and hence 2 is reachable from 1.
//

public class FirstDepthFirstSearch {
    int dfs(boolean[] visited,int s,ArrayList<ArrayList<Integer>> a,int des){
        visited[s]=true;
        if(s==des){
            return 1;
        }
        for(int i=0;i<a.get(s).size();i++){
            if(visited[a.get(s).get(i)]==false){
                if(dfs(visited,a.get(s).get(i),a,des)==1){
                    return 1;
                }
            }
        }
        return 0;
    }
    public int solve(int[] A, final int B, final int C) {
        int max=A.length;

        ArrayList<ArrayList<Integer>>a=new ArrayList<>();
        for(int i=0;i<=max+1;i++){
            a.add(new ArrayList<Integer>());
        }
        for(int i=1;i<A.length;i++){
            a.get(A[i]).add(i+1);
        }
        boolean[]visited=new boolean[max+2];

        return dfs(visited,C,a,B);


    }
    public static void main(String[] args) {
        FirstDepthFirstSearch I = new FirstDepthFirstSearch();
        int[]A=new int[9];
        A[0]=1;A[1]=1;A[2]=1;
        A[3]=3;A[4]=3;
        A[5]=2;A[6]=2;
        A[7]=7;A[8]=6;
        System.out.println( I.solve(A,5,1));
    }
}




