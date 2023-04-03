package Intro_To_Arrays;

//Q=Problem Description
//        Given an array A of N integers. Count the number of elements that have at
//        least 1 elements greater than itself.

public class CountElements {
    public int solve(int[] A) {
        int max=A[0];
        int count=1;
        for(int i=1;i<A.length;i++){
            if(A[i]>max){
                max=A[i];
                count=1;
            }
            else if(max==A[i]){
                count++;
            }
        }
        return A.length-count;
    }
    public static void main(String args []){
        CountElements N1=new CountElements();
        int[] A=new int[3];
        A[0]=3;
        A[1]=1;
        A[2]=2;
        System.out.println( N1.solve(A));
    }
}
