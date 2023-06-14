package Advance_Hashing_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

//Q=Problem Description
//        Given two arrays of integers A and B, Sort A in such a way that the
//        relative order among the elements will be the same as those are in B.
//        For the elements not present in B, append them at last in sorted order.
//
//        Return the array A after sorting from the above method.
//
//        NOTE: Elements of B are unique.
//
//        Problem Constraints
//        1 <= length of the array A <= 100000
//
//        1 <= length of the array B <= 100000
//
//        -10^9 <= A[i] <= 10^9

public class SortArrayinGivenOrder {
    public int[] solve(int[] A, int[] B) {
        ArrayList <Integer>ans=new ArrayList<>();
        HashMap<Integer,Integer> map=new HashMap();
        for(int i=0;i<A.length;i++){
            if(map.containsKey(A[i])){
                int value=map.get(A[i]);
                value++;
                map.put(A[i],value);
            }
            else{
                map.put(A[i],1);
            }
        }
        for(int i=0;i<B.length;i++){
            if(map.containsKey(B[i])){
                for(int k=0;k<map.get(B[i]);k++){
                    ans.add(B[i]);
                }
                map.remove(B[i]);
            }
        }
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<A.length;i++){
            set.add(A[i]);
        }
        ArrayList<Integer> temp=new ArrayList<>();
        for (Integer ele : set) {
            if(map.containsKey(ele)){
                for(int k=0;k<map.get(ele);k++){
                    temp.add(ele);
                }
            }
        }
        Collections.sort(temp);
        for(int j=0;j<temp.size();j++){
            ans.add(temp.get(j));
        }
        int [] result=new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            result[i]=ans.get(i);
        }
        return result;
    }
    public static void main(String[] args) {
        SortArrayinGivenOrder I = new SortArrayinGivenOrder();
        int []A=new int[4];
        A[0]=3;A[1]=20;A[2]=17; A[3]=17;
        int []B=new int[8];
        B[0]=5;B[1]=9;B[2]=20;
        B[3]=11;B[4]=6;B[5]=18;
        B[6]=7;B[7]=13;
        System.out.println(I.solve(A,B));
    }
}