package Carry_Forward;
import java.util.ArrayList;

//Q=Problem Description
//
//        Given an integer array A containing N distinct integers,
//        you have to find all the leaders in array A. An element is a leader if
//        it is strictly greater than all the elements to its right side.
//
//        NOTE: The rightmost element is always a leader.
//
//        Problem Constraints
//
//        1 <= N <= 10^5
//        1 <= A[i] <= 10^8


public class LeadersInAnArray {
    public int[] solve(int[] A) {
        int leader=A[A.length-1];
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(leader);
        for(int i=A.length-2;i>=0;i--){
            if(A[i]>leader){
                leader=A[i];
                a.add(leader);
            }
        }
        int[] b = new int[a.size()];
        for(int j=0;j<a.size();j++){
            b[j]=a.get(j);
        }
        return b;
    }
    public static void main(String[] args) {
        LeadersInAnArray I = new LeadersInAnArray();
        int []A=new int[6];
        A[0]=16;A[1]=17;A[2]=4;A[3]=3;A[4]=5;A[5]=2;
        System.out.println( I.solve(A));
    }
}



