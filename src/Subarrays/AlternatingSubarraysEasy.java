package Subarrays;

import java.util.ArrayList;

//Q=Problem Description
//        You are given an integer array A of length N comprising of 0's & 1's, and an integer B.
//
//        You have to tell all the indices of array A that can act as a center of 2 * B + 1 length 0-1 alternating subarray.
//
//        A 0-1 alternating array is an array containing only 0's & 1's, and having no adjacent 0's or 1's. For e.g. arrays [0, 1, 0, 1], [1, 0] and [1] are 0-1 alternating, while [1, 1] and [0, 1, 0, 0, 1] are not.
//
//
//
//        Problem Constraints
//        1 <= N <= 10^3
//
//        A[i] equals to 0 or 1.
//
//        0 <= B <= (N - 1) / 2

public class AlternatingSubarraysEasy {
    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        ArrayList<Integer> a=new ArrayList<Integer>();
        if(B==0){
            for(int i=0;i<A.size();i++){
                a.add(i);
            }
            return a;
        }
        for(int i=1;i<A.size();i++){
            boolean alternative=true;
            for(int t=0;t<B;t++){
                if((i-t)<0 || (i-1-t)<0){
                    alternative=false;
                    break;
                }
                if(A.get(i-t)==A.get(i-1-t)){
                    alternative=false;
                    break;
                }
            }
            if(alternative){
                for(int t=0;t<B;t++){
                    if((t+i)>A.size()-1 || (t+i+1)>A.size()-1){
                        alternative=false;
                        break;
                    }
                    if(A.get(t+i)==A.get(t+i+1)){
                        alternative=false;
                        break;
                    }
                }
            }
            if(alternative){
                a.add(i);
            }
        }
        return a;
    }
    public static void main(String args[]) {
        AlternatingSubarraysEasy N1 = new AlternatingSubarraysEasy();
        ArrayList<Integer>A=new ArrayList<>();
        A.add(1);A.add(0);A.add(1); A.add(0); A.add(1);
        System.out.println(N1.solve(A,1));
    }
}



