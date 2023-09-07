package Advance_Graph_4_Floyd_Warshall_And_Graph_Colouring;

//Q=Problem Description
//        Sheldon lives in a country with A cities (numbered from 1 to A) and B bidirectional roads.
//
//        Roads are denoted by integer array D, E and F of size M, where D[i] and E[i] denotes the
//        cities and F[i] denotes the distance between the cities.
//
//        Now he has many lectures to give in the city and is running short of time, so he asked you
//        C queries, for each query i, find the shortest distance between city G[i] and H[i].
//
//        If the two cities are not connected then the distance between them is assumed to be -1.
//
//
//
//        Problem Constraints

//        1 <= A <= 200
//
//        1 <= B <= 200000
//
//        1 <= C <= 100000
//
//        1 <= F[i] <= 1000000
//
//        1 <= D[i], E[i], G[i], H[i] <= A
//
//
//
//        Input Format

//        First argument is an integer A.
//        Seocnd argument is an integer B.
//        Third argument is an integer C.
//        Fourth argument is an integer array D.
//        Fifth argument is an integer array E.
//        Sixth argument is an integer array F.
//        Seventh argument is an integer array G.
//        Eight argument is an integer array H.
//
//
//
//        Output Format

//        Return an integer array of size C, for each query denoting the shortest distance between
//        the given two vertices.
//        If the two vertices are not connected then output -1.
//
//
//
//        Example Input

//        Input 1:
//
//        A = 4
//        B = 6
//        C = 2
//        D = [1, 2, 3, 2, 4, 3]
//        E = [2, 3, 4, 4, 1, 1]
//        F = [4, 1, 1, 1, 1, 1]
//        G = [1, 1]
//        H = [2, 3]

//        Input 2:
//
//        A = 3
//        B = 3
//        C = 2
//        D = [1, 2, 1]
//        E = [2, 3, 3]
//        F = [3, 1, 1]
//        G = [2, 1]
//        H = [3, 2]
//
//
//        Example Output

//        Output 1:
//
//        [2, 1]

//        Output 2:
//
//        [1, 2]
//
//
//        Example Explanation

//        Explanation 1:
//
//        Distance between (1,2) will 2 if we take path 1->4->2.
//        Distance between (1,3) will 1 if we take path 1->3.

//        Explanation 2:
//
//        Distance between (2,3) will 1 if we take path 1->3.
//        Distance between (1,2) will 2 if we take path 1->3->2.


public class SheldonAndPairOfCities {
    public int[] solve(int A, int B, int C, int[] D, int[] E, int[] F, int[] G, int[] H) {
        int[][] dis = new int[A + 1][A + 1];
        for (int i = 0; i <= A; i++) {
            for (int j = 0; j <= A; j++) {
                if (i == j) {
                    dis[i][j] = 0;
                } else {
                    dis[i][j] = -1;
                }
            }
        }
        for (int i = 0; i < D.length; i++) {
            int city1=D[i];
            int city2=E[i];

            int distance=F[i];
            if(dis[city1][city2]==-1){
                dis[city1][city2]=distance;
            }
            else{
                dis[city1][city2]=Math.min(distance,dis[city1][city2]);
            }
            if(dis[city2][city1]==-1){
                dis[city2][city1]=distance;
            }
            else{
                dis[city2][city1]=Math.min(distance,dis[city2][city1]);
            }
        }
        for (int k = 1; k <= A; k++) {
            for (int i = 1; i <= A; i++) {
                for (int j = 1; j <= A; j++) {
                    if (dis[i][k] != -1 && dis[k][j] != -1) {
                        int newDist = dis[i][k] + dis[k][j];
                        if (dis[i][j] == -1 || newDist < dis[i][j]) {
                            dis[i][j] = newDist;
                        }
                    }
                }
            }
        }
            int[] ans = new int[C];
            for (int i = 0; i < C; i++) {
                ans[i] = dis[G[i]][H[i]];
            }
            return ans;

        }

    public static void main(String[] args) {
        SheldonAndPairOfCities I = new SheldonAndPairOfCities();
        int A=3;
        int B=3;
        int C=2;
        int[]D=new int[3];
        D[0]=1;D[1]=2;D[2]=1;
        int[]E=new int[3];
        E[0]=2;E[1]=3;E[2]=3;

        int[]F=new int[3];
        F[0]=3;F[1]=1;F[2]=1;

        int[] G=new int[2];
        G[0]=2;G[1]=1;
        int[]H=new int[2];
        H[0]=3;H[1]=2;

        System.out.println( I.solve(A,B,C,D,E,F,G,H));
    }
}

