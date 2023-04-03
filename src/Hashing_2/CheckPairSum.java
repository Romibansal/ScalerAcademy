package Hashing_2;


import java.util.HashSet;

//Q=Problem Description
//        Given an Array of integers B, and a target sum A.
//        Check if there exists a pair (i,j) such that Bi + Bj = A and i!=j.
//
//
//        Problem Constraints
//        1<= Length of array B <= 103
//        0<= Bi <=10^9
//        0<= A <=10^9


public class CheckPairSum {
    public int solve(int A, int[] B) {
        HashSet<Integer> h=new HashSet<>();
        for(int i=0;i<B.length;i++){
            int number=A-B[i];
            if(h.contains(number)){
                return 1;
            }
            else{
                h.add(B[i]);
            }
        }
        return 0;
    }
    public static void main(String args []){
        CheckPairSum N1=new CheckPairSum();
        int [] B=new int[6];
        B[0]=3; B[1]=5; B[2]=1; B[3]=2;B[4]=1;B[5]=2;
        System.out.println( N1.solve(8,B));
    }
}
