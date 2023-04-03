package Hashing_1;

import java.util.ArrayList;
import java.util.HashMap;

//Q=Problem Description
//        Given two integer arrays, A and B of size N and M, respectively.
//        Your task is to find all the common elements in both the array.
//        NOTE:
//        Each element in the result should appear as many times as it appears in both arrays.
//        The result can be in any order.
//
//        Problem Constraints
//        1 <= N, M <= 10^5
//        1 <= A[i] <= 10^9




public class CommonElements {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        HashMap<Integer,Integer> hm1=new HashMap<>();
        ArrayList<Integer> C=new ArrayList<>();
        for(int i=0; i<A.size();i++){
            if(hm1.containsKey(A.get(i))){
                int v=hm1.get(A.get(i));
                v=v+1;
                hm1.put(A.get(i),v);
            }
            else{
                hm1.put(A.get(i),1);
            }
        }
        for(int j=0; j<B.size();j++){
            if(hm1.containsKey(B.get(j)) && hm1.get(B.get(j))>0){
                C.add(B.get(j));
                int w=hm1.get(B.get(j));
                w=w-1;
                hm1.put(B.get(j),w);
            }
        }
        return C;
    }
    public static void main(String args []){
        CommonElements N1=new CommonElements();
        ArrayList<Integer>A=new ArrayList<>();
        ArrayList<Integer>B=new ArrayList<>();
        B.add(3);B.add(6);B.add(2);B.add( 10);B.add(10);
        A.add(2);A.add(1);A.add(4);A.add(10);
        System.out.println( N1.solve(A,B));
    }
}

