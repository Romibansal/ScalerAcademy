package Hashing_2;

import java.util.HashMap;

//Q=Problem Description
//        Given an integer array A containing N distinct integers.
//        Find the number of unique pairs of integers in the array whose XOR is equal to B.
//
//        NOTE:
//        Pair (a, b) and (b, a) is considered to be the same and should be counted once.
//
//        Problem Constraints
//        1 <= N <= 10^5
//        1 <= A[i], B <= 10^7




public class PairsWithGivenXor {
    public int solve(int[] A, int B) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        int count=0;
        for(int i=0;i<A.length;i++){
            int number=(B^A[i]);
            if(hm.containsKey(number)){
                count=count+hm.get(number);
            }
            if(hm.containsKey(A[i])){
                int v=hm.get(A[i]);
                v=v+1;
                hm.put(A[i],v);
            }
            else{
                hm.put(A[i],1);
            }
        }
        return count;
    }
    public static void main(String args []){
        PairsWithGivenXor N1=new PairsWithGivenXor();
        int [] A=new int[6];
        A[0]=3;A[1]=6;A[2]=8;A[3]=10;A[4]=15;A[5]=50;
        System.out.println( N1.solve(A,5));
    }
}


