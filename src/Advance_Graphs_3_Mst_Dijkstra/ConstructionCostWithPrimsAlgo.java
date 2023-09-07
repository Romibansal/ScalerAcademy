package Advance_Graphs_3_Mst_Dijkstra;

//Q=Problem Description
//        Given a graph with A nodes and C weighted edges. Cost of constructing the graph
//        is the sum of weights of all the edges in the graph.
//
//        Find the minimum cost of constructing the graph by selecting some given edges such that we can
//        reach every other node from the 1st node.
//
//        NOTE: Return the answer modulo 109+7 as the answer can be large.
//
//
//
//        Problem Constraints
//        1 <= A <= 100000
//        0 <= C <= 100000
//        1 <= B[i][0], B[i][1] <= N
//        1 <= B[i][2] <= 10^9
//
//
//
//        Input Format
//        First argument is an integer A.
//        Second argument is a 2-D integer array B of size C*3 denoting edges. B[i][0] and
//        B[i][1] are connected by ith edge with weight B[i][2]
//
//
//
//        Output Format
//        Return an integer denoting the minimum construction cost.
//
//
//
//        Example Input
//        Input 1:
//
//        A = 3
//        B = [   [1, 2, 14]
//        [2, 3, 7]
//        [3, 1, 2]   ]
//        Input 2:
//
//        A = 3
//        B = [   [1, 2, 20]
//        [2, 3, 17]  ]
//
//
//        Example Output

//        Output 1:
//
//        9

//        Output 2:
//
//        37
//
//
//        Example Explanation

//        Explanation 1:
//
//        We can take only two edges (2 -> 3 and 3 -> 1) to construct the graph.
//        we can reach the 1st node from 2nd and 3rd node using only these two edges.
//        So, the total cost of costruction is 9.

//        Explanation 2:
//
//        We have to take both the given edges so that we can reach the 1st node from 2nd and 3rd node.

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ConstructionCostWithPrimsAlgo {
    int mod=(int)Math.pow(10,9)+7;
    class pair{
        int node;
        int weight;
        pair(int n,int w){
            node=n;
            weight=w;
        }
    }
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<ArrayList<pair>>a=new ArrayList<>();
        for(int i=0;i<A+1;i++){
            a.add(new ArrayList<>());
        }
        for(int i=0;i<B.size();i++){
            int weight=B.get(i).get(2);
            int parent=B.get(i).get(0);
            int child=B.get(i).get(1);
            a.get(parent).add(new pair(child,weight));
            a.get(child).add(new pair(parent,weight));
        }
        boolean visited[]=new boolean[A+1];

        PriorityQueue<pair>minheap=new PriorityQueue<>(new Comparator<pair>() {
            @Override
            public int compare(pair o1, pair o2) {
                return o1.weight-o2.weight;
            }
        });
        long ans=0;
        visited[1]=true;
        for(int i=0;i<a.get(1).size();i++){
            minheap.add(a.get(1).get(i));
        }
        while(!minheap.isEmpty()){
            pair p=minheap.poll();
            if(visited[p.node]==false) {
                visited[p.node] = true;
                ans = (ans%mod + p.weight)%mod;
            }
            int node=p.node;
            for(int i=0;i<a.get(node).size();i++){
                if(visited[a.get(node).get(i).node]==false){
                    minheap.add(a.get(node).get(i));
                }
            }
        }

        return (int)(ans%mod);
    }
    public static void main(String[] args) {
        ConstructionCostWithPrimsAlgo I = new ConstructionCostWithPrimsAlgo();
        ArrayList<ArrayList<Integer>>B=new ArrayList<>();

        ArrayList<Integer>b1=new ArrayList<>();
        b1.add(1);b1.add(2);b1.add(7);

        ArrayList<Integer>b2=new ArrayList<>();
        b2.add(2);b2.add(3);b2.add(6);


        ArrayList<Integer>b3=new ArrayList<>();
        b3.add(3);b3.add(6);b3.add(5);

        ArrayList<Integer>b4=new ArrayList<>();
        b4.add(1);b4.add(4);b4.add(8);

        ArrayList<Integer>b5=new ArrayList<>();
        b5.add(4);b5.add(5);b5.add(3);

        ArrayList<Integer>b6=new ArrayList<>();
        b6.add(5);b6.add(6);b6.add(5);


        ArrayList<Integer>b7=new ArrayList<>();
        b7.add(4);b7.add(2);b7.add(3);


        ArrayList<Integer>b8=new ArrayList<>();
        b8.add(4);b8.add(3);b8.add(4);

        ArrayList<Integer>b9=new ArrayList<>();
        b9.add(3);b9.add(5);b9.add(2);

        B.add(b1);B.add(b2);B.add(b3);B.add(b4);B.add(b5);B.add(b6);B.add(b7);B.add(b8);B.add(b9);
        System.out.println( I.solve(6,B));
    }
}
