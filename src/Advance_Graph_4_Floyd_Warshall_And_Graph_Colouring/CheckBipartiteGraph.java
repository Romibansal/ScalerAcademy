package Advance_Graph_4_Floyd_Warshall_And_Graph_Colouring;


import java.util.ArrayList;

//Q=Problem Description
//        Given a undirected graph having A nodes. A matrix B of size M x 2 is given
//        which represents the edges such that there is an edge between B[i][0] and B[i][1].
//
//        Find whether the given graph is bipartite or not.
//
//        A graph is bipartite if we can split it's set of nodes into two independent subsets
//        A and B such that every edge in the graph has one node in A and another node in B
//
//        Note:
//
//        There are no self-loops in the graph.
//
//        No multiple edges between two pair of vertices.
//
//        The graph may or may not be connected.
//
//        Nodes are Numbered from 0 to A-1.
//
//        Your solution will run on multiple testcases. If you are using global variables
//        make sure to clear them.
//
//
//
//        Problem Constraints

//        1 <= A <= 100000
//
//        1 <= M <= min(A*(A-1)/2,200000)
//
//        0 <= B[i][0],B[i][1] < A
//
//
//
//Input Format

//        The first argument given is an integer A.
//
//        The second argument given is the matrix B.
//
//
//
//        Output Format

//        Return 1 if the given graph is bipartide else return 0.
//
//
//
//        Example Input

//        Input 1:
//
//        A = 2
//        B = [ [0, 1] ]

//        Input 2:
//
//        A = 3
//        B = [ [0, 1], [0, 2], [1, 2] ]
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
//        Put 0 and 1 into 2 different subsets.

//        Explanation 2:
//
//        It is impossible to break the graph down to make two different subsets for bipartite matching

public class CheckBipartiteGraph {
    boolean dfs(int[] colour,int source,ArrayList<ArrayList<Integer>>a){
        for(int i=0;i<a.get(source).size();i++){
            if(colour[a.get(source).get(i)]==-1){
                if(colour[source]==1){
                    colour[a.get(source).get(i)]=0;
                }
                else{
                    colour[a.get(source).get(i)]=1;
                }
                if(dfs(colour,a.get(source).get(i),a)==false){
                    return false;
                }
            }
            else{
                if(colour[source]==colour[a.get(source).get(i)]){
                    return false;
                }
            }
        }
        return true;
    }
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<ArrayList<Integer>>a=new ArrayList<>();
        for(int i=0;i<A;i++){
            a.add(new ArrayList<>());
        }
        for(int i=0;i<B.size();i++){
            a.get(B.get(i).get(0)).add(B.get(i).get(1));
            a.get(B.get(i).get(1)).add(B.get(i).get(0));
        }
        int[]colour=new int[A];

        //-1 means not visited yet

        for(int i=0;i<A;i++){
            colour[i]=-1;
        }

        for(int i=0;i<A;i++){
            if(colour[i]==-1) {
                colour[i] = 0;
                if (!dfs(colour, i, a)) {
                    return 0;
                }
            }
        }

        return 1;
    }
    public static void main(String[] args) {
        CheckBipartiteGraph I = new CheckBipartiteGraph();
        int A = 10;
        ArrayList<ArrayList<Integer>>B=new ArrayList<>();
        ArrayList<Integer>b1=new ArrayList<>();
        ArrayList<Integer>b2=new ArrayList<>();
        ArrayList<Integer>b3=new ArrayList<>();
        ArrayList<Integer>b4=new ArrayList<>();
        ArrayList<Integer>b5=new ArrayList<>();
        ArrayList<Integer>b6=new ArrayList<>();

        ArrayList<Integer>b7=new ArrayList<>();
        ArrayList<Integer>b8=new ArrayList<>();
        ArrayList<Integer>b9=new ArrayList<>();

        b1.add(7);b1.add( 8);
        b2.add(1);b2.add( 2);
        b3.add( 0);b3.add( 9) ;

        b4.add(1);b4.add( 3);
        b5.add(6);b5.add( 7);
        b6.add( 0);b6.add( 3) ;

        b7.add(2);b7.add( 5);
        b8.add(3);b8.add( 8);
        b9.add( 4);b9.add( 8) ;

        B.add(b1);B.add(b2);B.add(b3);B.add(b4);B.add(b5);B.add(b6);B.add(b7);B.add(b8);B.add(b9);
        System.out.println( I.solve(A,B));
    }
}


