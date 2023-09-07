package Advance_Binary_Search_Problem3;

//Q=Given 2 integers A and B and an array of integers C of size N. Element C[i] represents the length of ith board.
//        You have to paint all N boards [C0, C1, C2, C3 … CN-1]. There are A painters available and each
//        of them takes B units of time to paint 1 unit of the board.
//
//        Calculate and return the minimum time required to paint all boards under
//        the constraints that any painter will only paint contiguous sections of the board.
//        NOTE:
//        1. 2 painters cannot share a board to paint. That is to say, a board cannot be
//        painted partially by one painter, and partially by another.
//        2. A painter will only paint contiguous boards. This means a configuration
//        where painter 1 paints boards 1 and 3 but not 2 is invalid.
//
//        Return the ans % 10000003.
//
//
//        Problem Constraints
//        1 <= A <= 1000
//        1 <= B <= 10^6
//        1 <= N <= 10^5
//        1 <= C[i] <= 10^6

public class PaintersPartitionProblem {
    int painter(int A[],long time,long B){
        int count=1; long t=time;
        for(int i=0;i<A.length;i++){
            if((A[i]*B)<=t){
                t=t-(A[i]*B);
            }
            else{
                count++;
                t=time-(A[i]*B);
            }
        }
        return count;
    }
    public int paint(int A, int B, int[] C) {
        long max=C[0];
        long sum=0;
        for(int i=0;i<C.length;i++){
            max=Math.max(max,C[i]);
            sum=sum+C[i];
        }
        long l=(max*B);
        long r=(sum*B);
        long ans=r;
        while(l<=r){
            long mid=l+(r-l)/2;
            int c=painter(C,mid,B);
            if(c>A){
                l=mid+1;
            }
            else{
                ans=mid;
                r=mid-1;
            }
        }
        return (int)(ans% 10000003);
    }
    public static void main(String[] args) {
        PaintersPartitionProblem I = new PaintersPartitionProblem();
        int C[]=new int [2];
        C[0] =1000000;C[1] = 1000000;


        System.out.println(I.paint(1,1000000,C));
    }
}
