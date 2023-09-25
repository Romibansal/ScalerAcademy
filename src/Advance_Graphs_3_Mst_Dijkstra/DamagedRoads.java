package Advance_Graphs_3_Mst_Dijkstra;

import java.util.ArrayList;
import java.util.Collections;

//Q=Problem Description
//
//        You are the Prime Minister of a country and once you went for a world tour.
//        After 5 years, when you returned to your country, you were shocked to see the
//        condition of the roads between the cities. So, you plan to repair them, but you cannot
//        afford to spend a lot of money.
//
//        The country can be represented as a (N+1) x (M+1) grid, where Country(i, j) is a city.
//
//        The cost of repairing a road between (i, j) and (i + 1, j) is A[i]. The cost of repairing a road
//        between (i, j) and (i, j + 1) is B[j].
//
//        Return the minimum cost of repairing the roads such that all cities can be visited from
//        city indexed (0, 0).
//
//        As the cost can be large, return the cost modulo 109+7.
//
//
//
//        Problem Constraints
//
//        1 <= N, M <= 10^5
//
//        1 <= A[i], B[i] <= 10^3
//
//
//        Input Format
//
//        The first argument will be an integer array, A, of size N.
//        The second argument will be an integer array, B, of size M.
//
//
//
//        Output Format
//
//        Return an integer representing the minimum possible cost.
//
//
//
//        Example Input
//
//        Input 1:
//
//        A = [1, 1, 1]
//        B = [1, 1, 2]
//        Input 2:
//
//        A = [1, 2, 3]
//        B = [4, 5, 6]
//
//
//        Example Output
//
//        Output 1:
//
//        16
//        Output 2:
//
//        39
//
//
//        Example Explanation
//
//        Explanation 1:
//
//        The minimum cost will be 16 if we repair the roads in the following way:
//        Repair the roads from the all cities in row 0 to row 1 i.e. (0, j) to (1, j) (0 <= j <= 3),
//        so that the cost will be 4 (A[0] * 4).
//        Repair the roads from the all cities in row 1 to row 2 i.e. (1, j) to (2, j) (0 <= j <= 3),
//        so that the cost will be 4 (A[1] * 4).
//        Repair the roads from the all cities in row 2 to row 3 i.e. (2, j) to (3, j) (0 <= j <= 3),
//        so that the cost will be 4 (A[2] * 4).
//        Repair the roads (0, 0) to (0, 1), (0, 1) to (0, 2), (0, 2) to (0, 3), so that the cost
//        will be B[0] + B[1] + B[2] = 4.
//        Total cost will be 16.
//
//        Explanation 2:
//
//        The minimum possible cost will be 39.

public class DamagedRoads {
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        long ans=0;
        int mod=(int)Math.pow(10,9)+7;
        Collections.sort(A);
        Collections.sort(B);
        int N=A.size()+1;
        int M=B.size()+1;
        int i=0;
        int j=0;
        while(N>1 && M>1 && i<A.size() && j<B.size()){
            if(A.get(i)<=B.get(j)){
                ans=(ans%mod+(((long)M*A.get(i))%mod))%mod;
                i++;
                N--;
            }
            else{
                ans=(ans%mod+(((long)N*B.get(j))%mod))%mod;
                j++;
                M--;
            }
        }
        while(M>1){
            ans=ans+B.get(j);
            j++;
            M--;
        }
        while(N>1){
            ans=ans+A.get(i);
            i++;
            N--;
        }
        return (int)ans;
    }
    public static void main(String[] args) {
        DamagedRoads I = new DamagedRoads();
        ArrayList<Integer>A=new ArrayList<>();

        A.add(2);A.add(2);A.add(4);A.add(1);A.add(2);A.add(4);A.add(2);
        ArrayList<Integer>B=new ArrayList<>();
        B.add(3);B.add(3);B.add(4);B.add(5);
        System.out.println( I.solve(A,B));
    }
}


