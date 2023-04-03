package Sorting;

import java.util.Arrays;


//Q=Problem Description
//        Given an integer array A of size N. You can remove any element from the array in one operation.
//        The cost of this operation is the sum of all elements in the array present before this operation.
//
//        Find the minimum cost to remove all elements from the array.


public class ElementsRemoval {

    public int solve(int[] A) {
        Arrays.sort(A);
        int ans=0;
        int j=1;
        for(int i=A.length-1;i>-1;i--){
            ans=ans+(j*A[i]);
            j++;
        }
        return ans;
    }
    public static void main(String args []){
        ElementsRemoval N1=new ElementsRemoval();
        int A[]=new int[3];
        A[0]=8;
        A[1]=0;
        A[2]=10;
        System.out.println( N1.solve(A));
    }
}

