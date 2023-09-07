package Advance_Graphs_3_Mst_Dijkstra;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

//Q=Problem Description
//
//        Given a weighted undirected graph having A nodes, a source node C and destination node D.
//
//        Find the shortest distance from C to D and if it is impossible to reach node D from C then return -1.
//
//        You are expected to do it in Time Complexity of O(A + M).
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
//        Your solution will run on multiple testcases. If you are using global variables make sure to clear them.
//
//
//
//        Problem Constraints
//
//        1 <= A <= 10^5
//
//        0 <= B[i][0], B[i][1] < A
//
//        1 <= B[i][2] <= 2
//
//        0 <= C < A
//
//         0 <= D < A
//
//
//
//Input Format
//
//        The first argument given is an integer A, representing the number of nodes.
//
//        The second argument given is the matrix B, where B[i][0] and B[i][1] are connected
//        through an edge of weight B[i][2].
//
//        The third argument given is an integer C, representing the source node.
//
//        The fourth argument is an integer D, representing the destination node.
//
//        Note: B[i][2] will be either 1 or 2.
//
//
//
//        Output Format
//
//        Return the shortest distance from C to D. If it is impossible to reach node D from C then return -1.
//
//
//
//        Example Input
//
//        Input 1:
//
//
//        A = 6
//        B = [   [2, 5, 1]
//        [1, 3, 1]
//        [0, 5, 2]
//        [0, 2, 2]
//        [1, 4, 1]
//        [0, 1, 1] ]
//        C = 3
//        D = 2

//        Input 2:
//
//        A = 2
//        B = [   [0, 1, 1] ]
//        C = 0
//        D = 1
//
//
//        Example Output
//
//        Output 1:
//
//        4
//        Output 2:
//
//        1
//
//
//        Example Explanation
//
//        Explanation 1:
//
//        The path to be followed will be:
//        3 -> 1 (Edge weight : 1)
//        1 -> 0 (Edge weight : 1)
//        0 -> 2 (Edge weight : 2)
//        Total length of path = 1 + 1 + 2 = 4.

//        Explanation 2:
//
//        Path will be 0-> 1.

public class AnotherBFS {
    class pair{
        int dis;
        int node;
        pair(int d,int n){
            dis=d;
            node=n;
        }
    }
    public int solve(int A, ArrayList<ArrayList<Integer>> B, int C, int D) {

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
        return result.get(D);
    }
    public static void main(String[] args) {
        AnotherBFS I = new AnotherBFS();
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

        B.add(b1);B.add(b2);B.add(b3);B.add(b4);B.add(b5);B.add(b6);B.add(b7);B.add(b8);
        B.add(b9);


        System.out.println( I.solve(6,B,4,5));
    }
}
