package Intro_To_Arrays;

//Q=Problem Description
//        Given an integer array A of size N and an integer B,
//        you have to return the same array after rotating it B times towards the right.
//
//        Problem Constraints
//        1 <= N <= 10^5
//        1 <= A[i] <=10^9
//        1 <= B <= 10^9


public class ArrayRotation {
    void Reverse(int[] A,int S,int E) {
        while(S<E){
            int temp=A[S];
            A[S]=A[E];
            A[E]=temp;
            S++;
            E--;
        }
    }
    public int[] solve(int[] A, int B) {
        B=B%A.length;
        Reverse(A,0,(A.length-1));
        Reverse(A,0,B-1);
        Reverse(A,B,(A.length-1));
        return A;
    }

    public static void main(String args []){
        GoodPair N1=new GoodPair();
        int[] A=new int[4];
        A[0]=1;A[3]=4;
        A[1]=2;
        A[2]=3;
        System.out.println( N1.solve(A,2));
    }
}
