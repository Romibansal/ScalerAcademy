package Advance_Greedy;

import java.util.ArrayList;
import java.util.Collections;

//Q=Problem Description
//        N Mice and N holes are placed in a straight line. Each hole can accommodate only one mouse.
//
//        The positions of Mice are denoted by array A, and the position of holes is denoted by array B.
//
//        A mouse can stay at his position, move one step right from x to x + 1,
//        or move one step left from x to x − 1. Any of these moves consume 1 minute.
//
//        Assign mice to holes so that the time when the last mouse gets inside a hole is minimized.
//
//
//
//        Problem Constraints

//        1 <= N <= 10^5
//
//        -10^9 <= A[i], B[i] <= 10^9
//
//
//
//        Input Format

//        The first argument is an integer array A.
//
//        The second argument is an integer array B.
//
//
//
//        Output Format

//        Return an integer denoting the minimum time when the last nouse gets inside the holes.
//
//
//
//        Example Input

//        Input 1:
//
//        A = [-4, 2, 3]
//        B = [0, -2, 4]

//        Input 2:
//
//        A = [-2]
//        B = [-6]
//
//
//        Example Output

//        Output 1:
//
//        2

//        Output 2:
//
//        4
//
//
//        Example Explanation

//        Explanation 1:
//
//        Assign the mouse at position (-4 to -2), (2 to 0) and (3 to 4).
//        The number of moves required will be 2, 2 and 1 respectively.
//        So, the time taken will be 2.

//        Explanation 2:
//
//        Assign the mouse at position -2 to -6.
//        The number of moves required will be 4.
//        So, the time taken will be 4.

public class AssignMiceToHoles {
    public int mice(ArrayList<Integer> A, ArrayList<Integer> B) {
        Collections.sort(A);
        Collections.sort(B);
        int ans=Math.abs(A.get(0)-B.get(0));
        for(int i=1;i<A.size();i++){
            int temp=Math.abs(A.get(i)-B.get(i));
            ans=Math.max(temp,ans);
        }
        return ans;
    }
    public static void main(String[] args) {
        AssignMiceToHoles I = new AssignMiceToHoles();
        ArrayList<Integer>A=new ArrayList<>();
        ArrayList<Integer>B=new ArrayList<>();
        A.add(-22);A.add(-99);A.add(20);A.add(-48);
        B.add(77);B.add( -34);B.add( -94);B.add( 9);
        System.out.println( I.mice(A,B));
    }
}





