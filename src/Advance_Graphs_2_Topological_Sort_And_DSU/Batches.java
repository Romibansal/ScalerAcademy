package Advance_Graphs_2_Topological_Sort_And_DSU;


import java.util.ArrayList;

//
//Q=Problem Description
//
//        A students applied for admission in IB Academy. An array of integers B is
//        given representing the strengths of A people i.e. B[i] represents the strength of ith student.
//
//        Among the A students some of them knew each other. A matrix C of size M x 2
//        is given which represents relations where ith relations depicts that C[i][0] and C[i][1] knew each other.
//
//        All students who know each other are placed in one batch.
//
//        Strength of a batch is equal to sum of the strength of all the students in it.
//
//        Now the number of batches are formed are very much, it is impossible for IB to handle them.
//        So IB set criteria for selection: All those batches having strength at least D are selected.
//
//        Find the number of batches selected.
//
//        NOTE: If student x and student y know each other, student y and z know each other then student x
//        and student z will also know each other.
//
//
//
//        Problem Constraints
//
//        1 <= A <= 10^5
//
//        1 <= M <= 2*10^5
//
//        1 <= B[i] <= 10^4
//
//        1 <= C[i][0], C[i][1] <= A
//
//        1 <= D <= 10^9
//
//
//
//        Input Format
//
//        The first argument given is an integer A.
//        The second argument given is an integer array B.
//        The third argument given is a matrix C.
//        The fourth argument given is an integer D.
//
//
//
//        Output Format
//
//        Return the number of batches selected in IB.
//
//
//
//        Example Input
//
//        Input 1:
//
//        A = 7
//        B = [1, 6, 7, 2, 9, 4, 5]
//        C = [  [1, 2]
//        [2, 3]
//        [5, 6]
//        [5, 7]  ]

//        D = 12

//        Input 2:
//
//        A = 5
//        B = [1, 2, 3, 4, 5]
//        C = [  [1, 5]
//        [2, 3]  ]

//        D = 6
//
//
//        Example Output
//
//        Output 1:
//
//        2

//        Output 2:
//
//        1
//
//
//        Example Explanation
//
//        Explanation 1:
//
//        Initial Batches :

//        Batch 1 = {1, 2, 3} Batch Strength = 1 + 6 + 7 = 14
//        Batch 2 = {4} Batch Strength = 2
//        Batch 3 = {5, 6, 7} Batch Strength = 9 + 4 + 5 = 18
//        Selected Batches are Batch 1 and Batch 2.

//        Explanation 2:
//
//        Initial Batches :

//        Batch 1 = {1, 5} Batch Strength = 1 + 5  = 6
//        Batch 2 = {2, 3} Batch Strength = 5
//        Batch 3 = {4} Batch Strength = 4
//        Selected Batch is only Batch 1.


public class Batches {
    int dfs(int s,ArrayList<ArrayList<Integer>>a,int ans,int[] strength,boolean[] visited){
        ans=ans+strength[s-1];
        visited[s]=true;
        for(int i=0;i<a.get(s).size();i++){
            if(visited[a.get(s).get(i)]==false){
                ans=dfs(a.get(s).get(i),a,ans,strength,visited);
            }
        }
        return ans;
    }
    public int solve(int A, int[] B, int[][] C, int D) {
        boolean[] visited=new boolean[A+1];
        ArrayList<ArrayList<Integer>>a=new ArrayList<>();
        for(int i=0;i<=A;i++){
            a.add(new ArrayList<>());
        }
        for(int i=0;i<C.length;i++){
            a.get(C[i][0]).add(C[i][1]);
            a.get(C[i][1]).add(C[i][0]);
        }
        int result=0;
        for(int i=1;i<=A;i++){
            if(visited[i]==false){
                int temp=dfs(i,a,0,B,visited);
                if(temp>=D){
                    result++;
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Batches I = new Batches();
        int[][] C=new int[9][2];
        C[0][0]=1;C[0][1]=4;
        C[1][0]=1;C[1][1]=6;
        C[2][0]=2;C[2][1]=7;
        C[3][0]=2;C[3][1]=9;

        C[4][0]=3;C[4][1]=5;
        C[5][0]=3;C[5][1]=8;
        C[6][0]=4;C[6][1]=9;
        C[7][0]=5;C[7][1]=8;
        C[8][0]=6;C[8][1]=8;

        int A = 9;
        int[]B=new int[9];
        B[0]=10; B[1]=8; B[2]=2;B[3]= 3;
        B[4]=4;B[5]= 8;B[6]= 3;B[7]= 5;B[8]= 9;

        int D = 25;
        System.out.println( I.solve(A,B,C,D));
    }
}





