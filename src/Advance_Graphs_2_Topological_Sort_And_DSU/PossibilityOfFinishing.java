package Advance_Graphs_2_Topological_Sort_And_DSU;


import java.util.ArrayList;

//Q=Problem Description
//        There are a total of A courses you have to take, labeled from 1 to A.
//
//        Some courses may have prerequisites, for example to take course 2 you have to first take course 1,
//        which is expressed as a pair: [1,2].
//
//        So you are given two integer array B and C of same size where for each i (B[i], C[i]) denotes a pair.
//
//        Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish
//        all courses?
//
//        Return 1 if it is possible to finish all the courses, or 0 if it is not possible to finish
//        all the courses.
//
//
//
//        Problem Constraints

//        1 <= A <= 6*10^4
//
//        1 <= length(B) = length(C) <= 10^5
//
//        1 <= B[i], C[i] <= A
//
//
//
//        Input Format

//        The first argument of input contains an integer A, representing the number of courses.
//
//        The second argument of input contains an integer array, B.
//
//        The third argument of input contains an integer array, C.
//
//
//
//        Output Format

//        Return 1 if it is possible to finish all the courses, or 0 if it is
//        not possible to finish all the courses.
//
//
//
//        Example Input

//        Input 1:
//
//        A = 3
//        B = [1, 2]
//        C = [2, 3]

//        Input 2:
//
//        A = 2
//        B = [1, 2]
//        C = [2, 1]
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
//        It is possible to complete the courses in the following order:
//        1 -> 2 -> 3

//        Explanation 2:
//
//        It is not possible to complete all the courses.


public class PossibilityOfFinishing {
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
    public int solve(int A, int[] B,int[] C) {
        ArrayList<ArrayList<Integer>> a=new ArrayList<>();
        for(int i=0;i<=A;i++){
            a.add(new ArrayList<>());
        }
        for(int i=0;i<B.length;i++){
            int idx=B[i];
            a.get(idx).add(C[i]);
        }
        boolean[] visited=new boolean[A+1];
        boolean[] path=new boolean[A+1];
        for(int i=1;i<=A;i++){
            if(visited[i]==false){
                if(dfs(visited,i,a,path)==1){
                    return 0;
                }
            }
        }
        return 1;
    }
    public static void main(String[] args) {
        PossibilityOfFinishing I = new PossibilityOfFinishing();
        int[]B=new int[2];
        B[0]=1;B[1]= 2;
        int[]C=new int[2];

        C[0]=2;C[1] =1;
        System.out.println( I.solve(5,B,C));
    }
}
