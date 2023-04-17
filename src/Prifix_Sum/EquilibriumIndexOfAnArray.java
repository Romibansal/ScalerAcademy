package Prifix_Sum;

//Q=Problem Description
//        You are given an array A of integers of size N.
//
//        Your task is to find the equilibrium index of the given array
//
//        The equilibrium index of an array is an index such that the sum of elements at
//        lower indexes is equal to the sum of elements at higher indexes.
//
//        If there are no elements that are at lower indexes or at higher indexes,
//        then the corresponding sum of elements is considered as 0.
//
//        Note:
//        Array indexing starts from 0.
//        If there is no equilibrium index then return -1.
//        If there are more than one equilibrium indexes then return the minimum index.
//
//
//        Problem Constraints
//        1 <= N <= 10^5
//        -10^5 <= A[i] <= 10^5


public class EquilibriumIndexOfAnArray {
    public int solve(int[] A) {
        int[] Psum = new int[A.length];
        Psum[0]=A[0];
        for(int i=1;i<A.length;i++){
            Psum[i]=Psum[i-1]+A[i];
        }
        for(int j=0;j<A.length;j++){
            if(j==0){
                if((Psum[A.length-1]-Psum[j])==0){
                    return 0;
                }

            }
            else if(Psum[j-1]==(Psum[A.length-1]-Psum[j])){
                return j;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        EquilibriumIndexOfAnArray I = new EquilibriumIndexOfAnArray();
        int[] A=new int[7];
        A[0]=-7 ;
        A[1]=1;
        A[2]=5;
        A[3]=2;
        A[4]=-4;
        A[5]=3;  A[6]=0;
        System.out.println( I.solve(A));
    }
}




