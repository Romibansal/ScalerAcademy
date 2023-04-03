package Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


//Q=Problem Description
//        Given an integer array A, find if an integer p exists in the array such that the number of integers greater
//        than p in the array equals p.

public class NobleInteger {
    public int solve(ArrayList<Integer> A) {
       // Arrays.sort(new int[][]{A}, Collections.reverseOrder());
        Collections.sort(A, Collections.reverseOrder());
        int temp_count=0;
        int count=0;
        if(A.get(0)==temp_count){
            return 1;
        }
        for(int i=1;i<A.size();i++){
            if(A.get(i)==A.get(i-1)){
                temp_count=count;
            }
            else{
                temp_count=i;
                count=temp_count;
            }
            if(temp_count==A.get(i)){
                return 1;
            }
        }
        return -1;
    }
    public static void main(String args []){
        NobleInteger N1=new NobleInteger();
        ArrayList<Integer>A=new ArrayList<>(3);
        A.add(1); A.add(2); A.add(7); A.add(0); A.add(9); A.add(3);
        A.add(6); A.add(0); A.add(6);

        System.out.println( N1.solve(A));
    }
}


