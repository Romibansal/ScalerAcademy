package Advance_Modular_Arithmetic;

//Q=Problem Description
//        Given an array of integers A, calculate the sum of A [ i ] % A [ j ] for all possible i, j pairs. Return sum % (109 + 7) as an output.
//
//
//
//        Problem Constraints
//        1 <= length of the array A <= 10^5
//
//        1 <= A[i] <= 10^3

public class ModSum {
    public int solve(int[] A) {
        int arr[] = new int[1001];
        long sum = 0;
        long mod = 1000000007;

        for(int i = 0; i < A.length; i++){
            arr[A[i]]++;
        }

        for(int i = 1; i <=1000; i++){
            for(int j = 1; j <=1000; j++){
                    int value = ((i % j) * arr[j]*arr[i]);
                    sum = ((sum % mod) + (value % mod)) % mod;
            }
        }
        return (int) sum;
    }

    public static void main(String[] args) {
        ModSum I = new ModSum();
        int A[]=new int[3];
        A[0]=1;
        A[1]=2;
        A[2]=3;
        System.out.println(I.solve(A));
    }
}

