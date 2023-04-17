package Sliding_Window;

//Q=Problem Description
//        Given an array A of length N. Also given are integers B and C.
//        Return 1 if there exists a subarray with length B having sum C and 0 otherwise
//
//        Problem Constraints
//        1 <= N <= 10^5
//        1 <= A[i] <= 10^4
//        1 <= B <= N
//        1 <= C <= 10^9

public class SubarrayWithGivenSumAndLength {
    public int solve(int[] A, int B, int C) {
        int sum=0;
        for(int i=0;i<B;i++){
            sum=sum+A[i];
        }
        if(sum==C){
            return 1;
        }
        int s=1;
        int l=B;
        while(l<A.length){
            sum=sum-A[s-1]+A[l];
            if(sum==C){
                return 1;
            }
            s++;l++;
        }
        return 0;
    }

    public static void main(String args []){
        SubarrayWithGivenSumAndLength R1=new SubarrayWithGivenSumAndLength();
        int[] A=new int[5];
        A[0]=4;
        A[1]=3;
        A[2]=2;
        A[3]=6;
        A[4]=1;
        System.out.println(R1.solve(A,3,11));
    }
}



