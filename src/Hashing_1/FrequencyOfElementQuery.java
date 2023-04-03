package Hashing_1;

import java.util.HashMap;

//Q=Problem Description
//        Given an array A. You have some integers given in the array B.
//
//        For the i-th number, find the frequency of B[i] in the array A and return a list containing all the frequencies.
//
//        Problem Constraints
//        1 <= |A| <= 10^5
//        1 <= |B| <= 10^5
//        1 <= A[i] <= 10^5
//        1 <= B[i] <= 10^5


public class FrequencyOfElementQuery {
    public int[] solve(int[] A, int[] B) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0;i<A.length;i++){
            if(hm.containsKey(A[i])==true){
                int v=hm.get(A[i]);
                v=v+1;
                hm.put(A[i],v);
            }
            else{
                hm.put(A[i],1);
            }
        }
        int C[]=new int[B.length];
        for(int j=0;j<B.length;j++){
            if(hm.containsKey(B[j])==true) {
                C[j]=hm.get(B[j]);
            }
            else{
                C[j]=0;
            }
        }
        return C;
    }
    public static void main(String args []){
        FrequencyOfElementQuery N1=new FrequencyOfElementQuery();
        int A[]=new int[9];
        A[0]=6;
        A[1]=3;A[2]=3;A[3]=6;A[4]=7;A[5]=8;A[6]=7;A[7]=3;A[8]=7;
        int B[]=new int[3];
        B[0]=10;B[1]=9;B[2]=8;

        System.out.println( N1.solve(A,B));
    }
}
