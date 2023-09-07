package Advance_Graph_4_Floyd_Warshall_And_Graph_Colouring;

import java.util.ArrayList;

//Q=Problem Description

//        A country consist of N cities connected by N - 1 roads. King of that country
//        want to construct maximum number of roads such that the new country formed remains bipartite country.
//
//        Bipartite country is a country, whose cities can be partitioned into 2 sets
//        in such a way, that for each road (u, v) that belongs to the country, u and v
//        belong to different sets. Also, there should be no multiple roads between two
//        cities and no self loops.
//
//        Return the maximum number of roads king can construct. Since the answer could be
//        large return answer % 109 + 7.
//
//        NOTE: All cities can be visited from any city.
//
//
//
//        Problem Constraints

//        1 <= A <= 10^5
//
//        1 <= B[i][0], B[i][1] <= N
//
//
//
//        Input Format
//        First argument is an integer A denoting the number of cities, N.
//
//        Second argument is a 2D array B of size (N-1) x 2 denoting the initial roads i.e.
//        there is a road between cities B[i][0] and B[1][1] .
//
//
//
//        Output Format

//        Return an integer denoting the maximum number of roads king can construct.
//
//
//
//        Example Input

//        Input 1:
//
//        A = 3
//        B = [
//        [1, 2]
//        [1, 3]
//        ]

//        Input 2:
//
//        A = 5
//        B = [
//        [1, 3]
//        [1, 4]
//        [3, 2]
//        [3, 5]
//        ]
//
//
//        Example Output

//        Output 1:
//
//        0

//        Output 2:
//
//        2
//
//
//        Example Explanation

//        Explanation 1:
//
//        We can't construct any new roads such that the country remains bipartite.

//        Explanation 2:
//
//        We can add two roads between cities (4, 2) and (4, 5).


public class ConstructRoads {
    void dfs(ArrayList<ArrayList<Integer>> a,int[] colour,int source){
        for(int i=0;i<a.get(source).size();i++){
            if(colour[a.get(source).get(i)]==-1){
                if(colour[source]==0) {
                    colour[a.get(source).get(i)] =1;
                }
                else{
                    colour[a.get(source).get(i)] =0;
                }
                dfs(a,colour,a.get(source).get(i));
            }
        }
    }
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<ArrayList<Integer>>a=new ArrayList<>();
        for(int i=0;i<=A;i++){
            a.add(new ArrayList<>());
        }
        for(int i=0;i<B.size();i++){
            a.get(B.get(i).get(0)).add(B.get(i).get(1));
            a.get(B.get(i).get(1)).add(B.get(i).get(0));
        }
        int[] colour=new int[A+1];
        for(int i=0;i<=A;i++){
            colour[i]=-1;
        }
        colour[1]=0;
        dfs(a,colour,1);
        long count1=0;
        long count2=0;
        for(int i=1;i<colour.length;i++){
            if(colour[i]==0){
                count1++;
            }
            else{
                count2++;
            }
        }
        int mod=(int)Math.pow(10,9)+7;
        long total_roads=((count1%mod*count2%mod)%mod);
        return (int)((total_roads-(A-1))%mod);
    }
    public static void main(String[] args) {
        ConstructRoads I = new ConstructRoads();
        int A = 5;
        ArrayList<ArrayList<Integer>>B=new ArrayList<>();
        ArrayList<Integer>b1=new ArrayList<>();
        ArrayList<Integer>b2=new ArrayList<>();
        ArrayList<Integer>b3=new ArrayList<>();
        ArrayList<Integer>b4=new ArrayList<>();


        b1.add(1);b1.add( 3);
        b2.add(1);b2.add( 4);
        b3.add( 3);b3.add( 2) ;

        b4.add(3);b4.add( 5);


        B.add(b1);B.add(b2);B.add(b3);B.add(b4);
        System.out.println( I.solve(A,B));
    }
}



