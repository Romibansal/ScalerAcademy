package Advance_Graphs_3_Mst_Dijkstra;


import java.util.ArrayList;
import java.util.Collections;

//Q=Problem Description
//        There are A islands and there are M bridges connecting them. Each bridge has some cost attached to it.
//
//        We need to find bridges with minimal cost such that all islands are connected.
//
//        It is guaranteed that input data will contain at least one possible scenario in which
//        all islands are connected with each other.
//
//
//
//        Problem Constraints

//        1 <= A, M <= 6*10^4
//
//        1 <= B[i][0], B[i][1] <= A
//
//        1 <= B[i][2] <= 10^3
//
//
//
//        Input Format

//        The first argument contains an integer, A, representing the number of islands.
//
//        The second argument contains an 2-d integer matrix, B, of size M x 3 where Island B[i][0]
//        and B[i][1] are connected using a bridge of cost B[i][2].
//
//
//
//        Output Format

//        Return an integer representing the minimal cost required.
//
//
//
//        Example Input

//        Input 1:
//
//        A = 4
//        B = [  [1, 2, 1]
//        [2, 3, 4]
//        [1, 4, 3]
//        [4, 3, 2]
//        [1, 3, 10]  ]

//        Input 2:
//
//        A = 4

//        B = [  [1, 2, 1]
//        [2, 3, 2]
//        [3, 4, 4]
//        [1, 4, 3]   ]
//
//
//        Example Output

//        Output 1:
//
//        6

//        Output 2:
//
//        6
//
//
//        Example Explanation

//        Explanation 1:
//
//        We can choose bridges (1, 2, 1), (1, 4, 3) and (4, 3, 2), where the
//        total cost incurred will be (1 + 3 + 2) = 6.

//        Explanation 2:
//
//        We can choose bridges (1, 2, 1), (2, 3, 2) and (1, 4, 3), where the
//        total cost incurred will be (1 + 2 + 3) = 6.

public class CommutableIslandsWithKushalsAlgo {
    int root(int x, int[] parent_array){
        while(x!=parent_array[x]){
            x=parent_array[x];
        }
        return x;
    }
    boolean union(int x,int y,int[] parent_array){
        int rx=root(x,parent_array);
        int ry=root(y,parent_array);
        if(rx==ry){
            return false;
        }
        parent_array[ry]=rx;
        return true;
    }
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        int[] parent_array=new int[A+1];
        for(int i=1;i<=A;i++){
            parent_array[i]=i;
        }
        Collections.sort(B, (a, b) -> a.get(2) - b.get(2));
        int ans=0;
        for(int i=0;i<B.size();i++){
            if(union(B.get(i).get(0),B.get(i).get(1),parent_array)){
                ans=ans+B.get(i).get(2);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        CommutableIslandsWithKushalsAlgo I = new CommutableIslandsWithKushalsAlgo();
        ArrayList<ArrayList<Integer>>B=new ArrayList<>();

        ArrayList<Integer>b1=new ArrayList<>();
        b1.add(1);b1.add(2);b1.add(1);

        ArrayList<Integer>b2=new ArrayList<>();
        b2.add(2);b2.add(3);b2.add(4);


        ArrayList<Integer>b3=new ArrayList<>();
        b3.add(1);b3.add(4);b3.add(3);

        ArrayList<Integer>b4=new ArrayList<>();
        b4.add(4);b4.add(3);b4.add(2);

        ArrayList<Integer>b5=new ArrayList<>();
        b5.add(1);b5.add(3);b5.add(10);
        B.add(b1);B.add(b2);B.add(b3);B.add(b4);B.add(b5);
        System.out.println( I.solve(4,B));
    }
}

