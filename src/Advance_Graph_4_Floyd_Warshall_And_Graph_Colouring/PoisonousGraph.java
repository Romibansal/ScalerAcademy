package Advance_Graph_4_Floyd_Warshall_And_Graph_Colouring;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//Q=Problem Description

//        You are given an undirected unweighted graph consisting of A
//        vertices and M edges given in a form of 2D Matrix B of size M x 2
//        where (B[i][0], B][i][1]) denotes two nodes connected by an edge.
//
//        You have to write a number on each vertex of the graph. Each number should be
//        1, 2 or 3. The graph becomes Poisonous if for each edge the sum of numbers on vertices
//        connected by this edge is odd.
//
//        Calculate the number of possible ways to write numbers 1, 2 or 3 on vertices
//        so the graph becomes poisonous. Since this number may be large, return it modulo 998244353.
//
//        NOTE:
//
//        Note that you have to write exactly one number on each vertex.
//        The graph does not have any self-loops or multiple edges.
//        Nodes are labelled from 1 to A.
//
//
//        Problem Constraints

//        1 <= A <= 3*10^5
//
//        0 <= M <= 3*10^5
//
//        1 <= B[i][0], B[i][1] <= A
//
//        B[i][0] != B[i][1]
//
//
//
//        Input Format

//        First argument is an integer A denoting the number of nodes.
//
//        Second argument is an 2D Matrix B of size M x 2 denoting the M edges.
//
//
//
//        Output Format
//        Return one integer denoting the number of possible ways to write numbers 1, 2
//        or 3 on the vertices of given graph so it becomes Poisonous . Since answer may be
//        large, print it modulo 998244353.
//
//
//
//        Example Input

//        Input 1:
//
//        A = 2
//        B = [  [1, 2]
//        ]

//        Input 2:
//
//        A = 4
//        B = [  [1, 2]
//        [1, 3]
//        [1, 4]
//        [2, 3]
//        [2, 4]
//        [3, 4]
//        ]
//
//
//        Example Output

//        Output 1:
//
//        4

//        Output 2:
//
//        0
//
//
//        Example Explanation

//        Explanation 1:
//
//        There are 4 ways to make the graph poisonous. i.e, writing number on node 1 and 2 as,
//        [1, 2] , [3, 2], [2, 1] or [2, 3] repsectively.

//        Explanation 2:
//
//        There is no way to make the graph poisonous.
//


public class PoisonousGraph {

    int count0=0;
    int count1=0;
    int mod=998244353;
    boolean bfs(int[] colour,ArrayList<ArrayList<Integer>>b,int source){
        Queue<Integer>q=new LinkedList<>();
        q.add(source);
        while (!q.isEmpty()){
            int temp=q.poll();
            if(colour[temp]==-1){
                count0++;
                colour[temp]=0;
            }
            for(int i=0;i<b.get(temp).size();i++){
                if(colour[b.get(temp).get(i)]==-1){
                    if(colour[temp]==0){
                        colour[b.get(temp).get(i)]=1;
                        count1++;
                    }
                    else{
                        colour[b.get(temp).get(i)]=0;
                        count0++;
                    }
                    q.add(b.get(temp).get(i));
                }
                else{
                    if(colour[temp]==colour[b.get(temp).get(i)]){
                        return false;
                    }
                }

            }
        }
        return true;
    }
    public int solve(int A, int[][] B) {

        long[] array=new long[A+1];
        array[0]=1;
        for(int i=1;i<array.length;i++){
            array[i]=(array[i-1]*2)%mod;
        }
        long ans=1;
        int[]colour=new int[A+1];
        for(int i=0;i<A+1;i++){
            colour[i]=-1;
        }

        ArrayList<ArrayList<Integer>> b=new ArrayList<>();
        for(int i=0;i<A+1;i++){
            b.add(new ArrayList<>());
        }
        for(int i=0;i<B.length;i++){
            int parent=B[i][0];
            int child=B[i][1];
            b.get(parent).add(child);
            b.get(child).add(parent);
        }
        for(int i=1;i<=A;i++){
            if(colour[i]==-1){
                count0=0;
                count1=0;

                if(!bfs(colour,b,i)){
                    return 0;
                }

                long temp1 = array[count0];
                long temp2 = array[count1];
                long res=(temp1%mod+temp2%mod)%mod;
                ans=(ans%mod*res%mod)%mod;
            }
        }
        return (int)(ans%mod);
    }



    public static void main(String[] args) {
        PoisonousGraph I = new PoisonousGraph();

        int[][]B=new int[0][0];
//        B[0][0]=1;B[0][1]=2;
//        B[1][0]=1;B[1][1]=3;
//        B[2][0]=1;B[2][1]=4;
//        B[3][0]=2;B[3][1]=3;
//        B[4][0]=2;B[4][1]=4;
//        B[5][0]=3;B[5][1]=4;



        System.out.println( I.solve(100000,B));
    }
}





