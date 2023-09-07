package Adnavnce_Stack_2_Nearest_Smallest;

import java.util.ArrayList;
import java.util.Stack;

//Q=Given a 2D binary matrix of integers A containing 0's and 1's of size N x M.
//
//        Find the largest rectangle containing only 1's and return its area.
//
//        Note: Rows are numbered from top to bottom and columns are numbered from left to right.
//
//
//        Input Format
//
//        The only argument given is the integer matrix A.
//        Output Format
//
//        Return the area of the largest rectangle containing only 1's.
//        Constraints
//
//        1 <= N, M <= 1000
//        0 <= A[i] <= 1
//        For Example
//
//        Input 1:
//        A = [   [0, 0, 1]
//        [0, 1, 1]
//        [1, 1, 1]   ]
//        Output 1:
//        4
//
//        Input 2:
//        A = [   [0, 1, 0, 1]
//        [1, 0, 1, 0]    ]
//        Output 2:
//        1

public class MaximumRectangle {
    int find_area(int[] A){
        Stack<Integer> stk=new Stack<>();
        int[] nearesrt_smallest_left=new int[A.length];
        for(int i=0;i<A.length;i++){
            while(!stk.empty() && A[stk.peek()]>=A[i]){
                stk.pop();
            }
            if(stk.empty()){
                nearesrt_smallest_left[i]=-1;
            }
            else{
                nearesrt_smallest_left[i]=(stk.peek());
            }
            stk.push(i);
        }
        Stack<Integer> stk1=new Stack<>();
        int[] nearesrt_smallest_right=new int[A.length];
        for(int i=A.length-1;i>-1;i--){
            while(!stk1.empty() && A[stk1.peek()]>=A[i]){
                stk1.pop();
            }
            if(stk1.empty()){
                nearesrt_smallest_right[i]=A.length;
            }
            else{
                nearesrt_smallest_right[i]=stk1.peek();
            }
            stk1.push(i);
        }
        int ans=0;
        for(int i=0;i<A.length;i++){
            int area=(A[i]*(nearesrt_smallest_right[i]-nearesrt_smallest_left[i]-1));
            ans=Math.max(ans,area);
        }
        return ans;
    }
    public int solve(int[][] A) {
        int N = A.length;
        int M = A[0].length;
        int result=0;
        for(int j = 0; j < M; j++) {
            for(int i = 1; i < N; i++) {
                if(A[i][j] != 0) {
                    A[i][j] = A[i][j] + A[i - 1][j];
                }
                else {
                    A[i][j] = 0;
                }
            }
        }
        for(int i=0;i<A.length;i++){
            result=Math.max(result,find_area(A[i]));
        }
        return result;
    }
    public static void main(String[] args) {
        MaximumRectangle I = new MaximumRectangle();
        int[][] a=new int[3][3];
        a[0][0]=0;a[0][1]=0;a[0][2]=1;
        a[1][0]=0;a[1][1]=1;a[1][2]=1;
        a[2][0]=1;a[2][1]=1;a[2][2]=1;
        System.out.println(I.solve(a));
    }
}

