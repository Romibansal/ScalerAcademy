package Advance_Graphs_3_Mst_Dijkstra;

import java.util.*;

//Q=Problem Description
//        Given any source point, (C, D) and destination point, (E, F) on a chess board of
//        size A x B, we need to find whether Knight can move to the destination or not.
//
//
//        The above figure details the movements for a knight ( 8 possibilities ).
//
//        If yes, then what would be the minimum number of steps for the knight to move to the
//        said point. If knight can not move from the source point to the destination point, then return -1.
//
//        NOTE: A knight cannot go out of the board.
//
//
//
//        Problem Constraints
//        1 <= A, B <= 500
//
//
//
//        Input Format
//        The first argument of input contains an integer A.
//        The second argument of input contains an integer B.
//        The third argument of input contains an integer C.
//        The fourth argument of input contains an integer D.
//        The fifth argument of input contains an integer E.
//        The sixth argument of input contains an integer F.
//
//
//
//        Output Format
//        If it is possible to reach the destination point, return the minimum number of moves.
//        Else return -1.
//
//
//
//        Example Input

//        Input 1:
//
//        A = 8
//        B = 8
//        C = 1
//        D = 1
//        E = 8
//        F = 8

//        Input 2:
//
//        A = 2
//        B = 4
//        C = 2
//        D = 1
//        E = 4
//        F = 4
//
//
//        Example Output

//        Output 1:
//
//        6

//        Output 2:
//
//        -1
//
//
//        Example Explanation

//        Explanation 1:
//
//        The size of the chessboard is 8x8, the knight is initially at (1, 1) and the knight
//        wants to reach position (8, 8).
//        The minimum number of moves required for this is 6.

//        Explanation 2:
//
//        It is not possible to move knight to position (4, 4) from (2, 1)

public class KnightOnChessBoard {

    public int knight(int A, int B, int C, int D, int E, int F) {
        int[][] matrix=new int[A][B];
        int temp=0;
        if(C==E && D==F){
            return 0;
        }
        for(int i=0;i<A;i++){
            for(int j=0;j<B;j++){
                matrix[i][j]=temp;
                temp++;
            }
        }
        int[]distance=new int[temp];
        distance[matrix[C-1][D-1]]=0;
        Queue<Integer> q=new LinkedList<>();
        q.add(matrix[C-1][D-1]);
        if((E-1)<0 || (E-1)>=A){
            return -1;
        }
        if((F-1)<0 || (F-1)>=B){
            return -1;
        }
        int target=matrix[E-1][F-1];
        HashSet<Integer> set=new HashSet<>();
        set.add(matrix[C-1][D-1]);
        while(!q.isEmpty()){
            int number= q.poll();
            int x=number/B;
            int y=number%B;
            if((x-2)>=0){
                if((y-1)>=0){
                    if(!set.contains(matrix[x - 2][y - 1])) {
                        set.add(matrix[x - 2][y - 1]);
                        q.add(matrix[x - 2][y - 1]);
                        distance[matrix[x - 2][y - 1]]=distance[matrix[x][y]]+1;
                    }
                }
                if((y+1)<B){
                    if(!set.contains(matrix[x - 2][y + 1])) {
                        set.add(matrix[x - 2][y + 1]);
                        q.add(matrix[x - 2][y + 1]);
                        distance[matrix[x - 2][y + 1]]=distance[matrix[x][y]]+1;
                    }
                }
            }
            if((x-1)>=0){
                if((y+2)<B){
                    if(!set.contains(matrix[x - 1][y + 2])) {
                        set.add(matrix[x - 1][y + 2]);
                        q.add(matrix[x - 1][y + 2]);
                        distance[matrix[x - 1][y + 2]]=distance[matrix[x][y]]+1;
                    }
                }
                if((y-2)>=0){
                    if(!set.contains(matrix[x - 1][y - 2])) {
                        set.add(matrix[x - 1][y - 2]);
                        q.add(matrix[x - 1][y - 2]);
                        distance[matrix[x - 1][y - 2]]=distance[matrix[x][y]]+1;
                    }
                }
            }
            if((x+1)<A){
                if((y-2)>=0){
                    if(!set.contains(matrix[x + 1][y - 2])) {
                        set.add(matrix[x + 1][y - 2]);
                        q.add(matrix[x + 1][y - 2]);
                        distance[matrix[x + 1][y - 2]]=distance[matrix[x][y]]+1;
                    }
                }
                if((y+2)<B){
                    if(!set.contains(matrix[x + 1][y + 2])) {
                        set.add(matrix[x + 1][y + 2]);
                        q.add(matrix[x + 1][y + 2]);
                        distance[matrix[x + 1][y + 2]]=distance[matrix[x][y]]+1;
                    }
                }
            }
            if((x+2)<A){
                if((y+1)<B){
                    if(!set.contains(matrix[x + 2][y + 1])) {
                        set.add(matrix[x + 2][y + 1]);
                        q.add(matrix[x + 2][y + 1]);
                        distance[matrix[x + 2][y + 1]]=distance[matrix[x][y]]+1;
                    }
                }
                if((y-1)>=0){
                    if(!set.contains(matrix[x + 2][y - 1])) {
                        set.add(matrix[x + 2][y - 1]);
                        q.add(matrix[x + 2][y - 1]);
                        distance[matrix[x + 2][y - 1]]=distance[matrix[x][y]]+1;
                    }
                }
            }
            if(distance[target]>0){
                return distance[target];
            }
        }
        return -1;

    }
    public static void main(String[] args) {
        KnightOnChessBoard I = new KnightOnChessBoard();

        System.out.println( I.knight(2,20,1,18,1,5));
    }
}

