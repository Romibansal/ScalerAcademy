package Advance_Graphs_3_Mst_Dijkstra;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

//Q=Problem Description

//        Given a weighted undirected graph having A nodes and M weighted edges, and a source node C.
//
//        You have to find an integer array D of size A such that:
//
//        D[i]: Shortest distance from the C node to node i.
//        If node i is not reachable from C then -1.
//        Note:
//
//        There are no self-loops in the graph.
//        There are no multiple edges between two pairs of vertices.
//        The graph may or may not be connected.
//        Nodes are numbered from 0 to A-1.
//        Your solution will run on multiple test cases. If you are using global variables,
//        make sure to clear them.
//
//
//        Problem Constraints

//        1 <= A <= 1e5
//
//        0 <= B[i][0],B[i][1] < A
//
//        0 <= B[i][2] <= 1e3
//
//        0 <= C < A
//
//
//
//Input Format

//        The first argument is an integer A, representing the number of nodes in the graph.
//        The second argument is a matrix B of size M x 3, where each row represents an edge in the graph.
//        The three columns of each row denote the source node B[i][0], the destination node B[i][1], and
//        the weight of the edge B[i][2].

//        The third argument is an integer C, representing the source node for which the shortest
//        distance to all other nodes needs to be found.
//
//
//        Output Format

//        Return the integer array D.
//
//
//
//        Example Input

//        Input 1:
//
//        A = 6

//        B = [   [0, 4, 9]

//        [3, 4, 6]
//        [1, 2, 1]
//        [2, 5, 1]
//        [2, 4, 5]
//        [0, 3, 7]
//        [0, 1, 1]
//        [4, 5, 7]
//        [0, 5, 1] ]
//        C = 4

//        Input 2:
//
//        A = 5

//        B = [   [0, 3, 4]
//        [2, 3, 3]
//        [0, 1, 9]
//        [3, 4, 10]
//        [1, 3, 8]  ]

//        C = 4
//
//
//        Example Output

//        Output 1:
//
//        D = [7, 6, 5, 6, 0, 6]

//        Output 2:
//
//        D = [14, 18, 13, 10, 0]
//
//
//        Example Explanation

//        Explanation 1:
//
//        All Paths can be considered from the node C to get shortest path

//        Explanation 2:
//
//        All Paths can be considered from the node C to get shortest path


public class Dijsktra {
    class pair{
        int dis;
        int node;
        pair(int d,int n){
            dis=d;
            node=n;
        }
    }
    public ArrayList<Integer> solve(int A, ArrayList<ArrayList<Integer>> B, int C) {
        int[] distance_array=new int[A];
        distance_array[C]=0;
        for(int i=0;i<distance_array.length;i++){
            if(i!=C){
                distance_array[i]=Integer.MAX_VALUE;
            }
        }
        ArrayList<ArrayList<pair>> a=new ArrayList<>();
        for(int i=0;i<A;i++){
            a.add(new ArrayList<>());
        }
        for(int i=0;i<B.size();i++){
            int parent=B.get(i).get(0);
            int child=B.get(i).get(1);
            int distance=B.get(i).get(2);
            a.get(parent).add(new pair(distance,child));
            a.get(child).add(new pair(distance,parent));
        }
        PriorityQueue<pair> minheap=new PriorityQueue<>(new Comparator<pair>() {
            @Override
            public int compare(pair o1, pair o2) {
                return o1.dis-o2.dis;
            }
        });
        for(int i=0;i<a.get(C).size();i++){
            distance_array[a.get(C).get(i).node]=0+a.get(C).get(i).dis;
            minheap.add(new pair(a.get(C).get(i).dis,a.get(C).get(i).node));
        }
        while(!minheap.isEmpty()){
            pair p= minheap.poll();
            int d=p.dis;
            int n=p.node;
            if(distance_array[n]<d){
                continue;
            }
            for(int i=0;i<a.get(n).size();i++){
                int temp_d=d+a.get(n).get(i).dis;
                if(temp_d<distance_array[a.get(n).get(i).node]){
                    distance_array[a.get(n).get(i).node]=temp_d;
                    minheap.add(new pair(temp_d,a.get(n).get(i).node));
                }
            }
        }
        ArrayList<Integer>result=new ArrayList<>();
        for(int i=0;i< distance_array.length;i++){
            if(distance_array[i]==Integer.MAX_VALUE){
                result.add(-1);
            }
            else{
                result.add(distance_array[i]);
            }

        }
        return result;
    }
    public static void main(String[] args) {
        Dijsktra I = new Dijsktra();
        int A = 10;
        ArrayList<ArrayList<Integer>>B=new ArrayList<>();
        ArrayList<Integer> b1=new ArrayList<>();
        b1.add(0);b1.add(4);b1.add(9);

        ArrayList<Integer> b2=new ArrayList<>();
        b2.add(3);b2.add(4);b2.add(6);

        ArrayList<Integer> b3=new ArrayList<>();
        b3.add(1);b3.add(2);b3.add(1);

        ArrayList<Integer> b4=new ArrayList<>();
        b4.add(2);b4.add(5);b4.add(1);

        ArrayList<Integer> b5=new ArrayList<>();
        b5.add(2);b5.add(4);b5.add(5);

        ArrayList<Integer> b6=new ArrayList<>();
        b6.add(0);b6.add(3);b6.add(7);

        ArrayList<Integer> b7=new ArrayList<>();
        b7.add(0);b7.add(1);b7.add(1);

        ArrayList<Integer> b8=new ArrayList<>();
        b8.add(4);b8.add(5);b8.add(7);

        ArrayList<Integer> b9=new ArrayList<>();
        b9.add(0);b9.add(5);b9.add(1);

//        ArrayList<Integer> b10=new ArrayList<>();
//        b10.add(2);b10.add(3);b10.add(5);
//
//        ArrayList<Integer> b11=new ArrayList<>();
//        b11.add(3);b11.add(8);b11.add(2);
//
//        ArrayList<Integer> b12=new ArrayList<>();
//        b12.add(3);b12.add(10);b12.add(1);
//
//        ArrayList<Integer> b13=new ArrayList<>();
//        b13.add(10);b13.add(9);b13.add(4);

        ArrayList<Integer> b14=new ArrayList<>();
        b14.add(9);b14.add(6);b14.add(5);
        B.add(b1);B.add(b2);B.add(b3);B.add(b4);B.add(b5);B.add(b6);B.add(b7);B.add(b8);
        B.add(b9);
        //B.add(b10);B.add(b11);B.add(b12);B.add(b13);B.add(b14);
        int C = 1;
        System.out.println( I.solve(6,B,4));
    }
}

