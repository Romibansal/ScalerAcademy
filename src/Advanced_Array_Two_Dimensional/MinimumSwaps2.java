package Advanced_Array_Two_Dimensional;


//Q=Problem Description
//        Given an array of integers A of size N that is a permutation of [0, 1, 2, ..., (N-1)].
//        It is allowed to swap any two elements (not necessarily consecutive).
//
//        Find the minimum number of swaps required to sort the array in ascending order.
//
//        Problem Constraints
//        1 <= N <= 100000
//        0 <= A[i] < N

public class MinimumSwaps2 {
    public int solve(int[] A) {
        int count=0;
        int start=0;
        while(start<A.length){
            if(A[start]==start){
                start++;
            }
            else{
                count++;
                int temp=A[start];
                int temp1=A[temp];
                A[temp]=temp;
                A[start]=temp1;
            }
        }
        return count;
    }
    public static void main(String args []){
        MinimumSwaps2 R1=new MinimumSwaps2();
        int A[]=new int[4];
        A[0]=2;A[1]=0;
        A[2]=1;A[3]=3;
        System.out.println(R1.solve(A));
    }
}


