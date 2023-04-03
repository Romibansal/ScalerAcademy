package Intro_To_Arrays;

//Q=Problem Description
//        Given an array A and an integer B. A pair(i, j) in the array is a good pair
//        if i != j and (A[i] + A[j] == B). Check if any good pair exist or not.
//
//        Problem Constraints
//        1 <= A.size() <= 10^4
//        1 <= A[i] <= 10^9
//        1 <= B <= 10^9


public class GoodPair {
    public int solve(int[] A, int B) {
        for(int i=0;i<A.length;i++){
            for(int j=i+1;j<A.length;j++){
                if(A[i]+A[j]==B){
                    return 1;
                }
            }
        }
        return 0;
    }
    public static void main(String args []){
        GoodPair N1=new GoodPair();
        int[] A=new int[4];
        A[0]=1;A[3]=4;
        A[1]=2;
        A[2]=3;
        System.out.println( N1.solve(A,7));
    }
}

