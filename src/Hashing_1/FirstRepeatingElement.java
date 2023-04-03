package Hashing_1;

import java.util.HashMap;

//Q=Problem Description
//        Given an integer array A of size N, find the first repeating element in it.
//        We need to find the element that occurs more than once and whose index of the first occurrence is the smallest.
//        If there is no repeating element, return -1.
//
//        Problem Constraints
//        1 <= N <= 10^5
//        1 <= A[i] <= 10^9

public class FirstRepeatingElement {
    public int solve(int[] A) {
        HashMap<Integer,Integer>hm=new HashMap<>();
        for(int i=0;i<A.length;i++){
            if(hm.containsKey(A[i])){
                int v=hm.get(A[i]);
                v=v+1;
                hm.put(A[i],v);
            }
            else{
                hm.put(A[i],1);
            }
        }
        for(int j=0;j<A.length;j++){
            if(hm.containsKey(A[j]) && hm.get(A[j])>1){
                return A[j];
            }
        }
        return -1;
    }
    public static void main(String args []){
        FirstRepeatingElement N1=new FirstRepeatingElement();
        int A[]=new int[7];
        A[0]=10;A[1]=5;A[2]=3;A[3]=4;A[4]=3;A[5]=5;A[6]=6;
        System.out.println( N1.solve(A));
    }
}

