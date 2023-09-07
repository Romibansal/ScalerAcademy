package Advance_Graphs_3_Mst_Dijkstra;

import java.util.ArrayList;
import java.util.Collections;

//Q=Problem Description
//
//        Given a undirected weighted graph with A nodes labelled from 1 to A with M edges given in
//        a form of 2D-matrix B of size M * 3 where B[i][0] and B[i][1] denotes the two nodes connected by
//        an edge of weight B[i][2].
//
//        For each edge check whether it belongs to any of the possible minimum spanning tree or not ,
//        return 1 if it belongs else return 0.
//
//        Return an one-dimensional binary array of size M denoting answer for each edge.
//
//        NOTE:
//
//        The graph may be disconnected in that case consider mst for each component.
//        No self-loops and no multiple edges present.
//        Answers in output array must be in order with the input array B output[i] must denote the
//        answer of edge B[i][0] to B[i][1].
//
//
//        Problem Constraints
//
//        1 <= A, M <= 3*10^5
//
//        1 <= B[i][0], B[i][1] <= A
//
//        1 <= B[i][1] <= 10^3
//
//
//
//        Input Format
//
//        The first argument given is an integer A representing the number of nodes in the graph.
//
//        The second argument given is an matrix B of size M x 3 which represents the M edges such that
//        there is a edge between node B[i][0] and node B[i][1] with weight B[i][2].
//
//
//
//        Output Format
//
//        Return an one-dimensional binary array of size M denoting answer for each edge.
//
//
//
//        Example Input
//
//        Input 1:
//
//        A = 3
//        B = [ [1, 2, 2]
//        [1, 3, 2]
//        [2, 3, 3]
//        ]
//
//
//        Example Output
//
//        Output 1:
//
//        [1, 1, 0]
//
//
//        Example Explanation
//
//        Explanation 1:
//
//        Edge (1, 2) with weight 2 is included in the MST           1
//             /   \
//            2     3
//        Edge (1, 3) with weight 2 is included in the same MST mentioned above.
//        Edge (2,3) with weight 3 cannot be included in any of the mst possible.
//        So we will return [1, 1, 0]


public class EdgeInMST {
    class pair{
        int x;
        int y;
        pair(int i,int j){
            x=i;
            y=j;
        }
    }
    int root(int x, int[] parent){
        if(x==parent[x]){
            return x;
        }
        int r=root(parent[x],parent);
        parent[x]=r;
        return r;

    }
    boolean union(int x,int y,int[] parent){
        int rx=root(x,parent);
        int ry=root(y,parent);
        if(rx==ry){
            return false;
        }
        parent[ry]=rx;
        return true;
    }
    public ArrayList<Integer> solve(int A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<Integer>ans=new ArrayList<>();
        for(int i=0;i<B.size();i++){
            ans.add(0);
            B.get(i).add(i);
        }
        int[]parent=new int[A+1];
        for(int i=1;i<=A;i++){
            parent[i]=i;
        }

        Collections.sort(B,(a,b)-> a.get(2)-b.get(2));


        for(int i=0;i<B.size();){
            int wt=B.get(i).get(2);
            int j=i;
            while(j<B.size() && B.get(j).get(2)==wt)
            {
                int u=B.get(j).get(0);
                int v=B.get(j).get(1);
                int idx=B.get(j).get(3);
                if(root(u, parent)!=root(v, parent))
                {
                    ans.set(idx, 1);
                }
                j++;
            }
            j=i;
            while(j<B.size() && B.get(j).get(2)==wt)
            {
                int u=B.get(j).get(0);
                int v=B.get(j).get(1);

                if(root(u, parent)!=root(v, parent))
                    union(u, v, parent);
                j++;
            }
            i=j;
        }

        return ans;
    }
    public static void main(String[] args) {
        EdgeInMST I = new EdgeInMST();
        ArrayList<ArrayList<Integer>>B=new ArrayList<>();

        ArrayList<Integer>b1=new ArrayList<>();
        b1.add(1);b1.add(2);b1.add(469);

        ArrayList<Integer>b2=new ArrayList<>();
        b2.add(2);b2.add(3);b2.add(335);


        ArrayList<Integer>b3=new ArrayList<>();
        b3.add(3);b3.add(1);b3.add(501);

        ArrayList<Integer>b4=new ArrayList<>();
        b4.add(2);b4.add(4);b4.add(170);

        ArrayList<Integer>b5=new ArrayList<>();
        b5.add(2);b5.add(5);b5.add(725);

        ArrayList<Integer>b6=new ArrayList<>();
        b6.add(2);b6.add(7);b6.add(479);

        ArrayList<Integer>b7=new ArrayList<>();
        b7.add(4);b7.add(6);b7.add(359);

        ArrayList<Integer>b8=new ArrayList<>();
        b8.add(5);b8.add(6);b8.add(963);

        B.add(b1);B.add(b2);B.add(b3);B.add(b4);B.add(b5);B.add(b6);B.add(b7);B.add(b8);
        System.out.println( I.solve(7,B));
    }
}


