package Unique_Questions;

import java.util.ArrayList;

// Q= Given the array of A of N integers .Return the pretty numbers in the array in the same relative ordering as the original
// array. Pretty Numbers are the ones which have at least 2 numbers less than themselves.


// 1<=N<=10^5  (so we have to do in O(N))
// 1<=A[i]<=10^9



public class PrettyNumbersC2 {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        ArrayList<Integer>B=new ArrayList<Integer>();
        if(A.size()==1 || A.size()==0){
            return B;
        }
        int count=0;
        int min=A.get(0);
        int second_min=A.get(1);
        if(A.get(0)>A.get(1)){
            second_min=A.get(0);
            min=A.get(1);
        }
        for(int j=2;j<A.size();j++){
            if(A.get(j)<min){
                second_min=min;
                min=A.get(j);
            }
            else if(A.get(j)<second_min  && A.get(j)>min){
                second_min=A.get(j);
            }
        }
        for(int h=0;h<A.size();h++){
            if(A.get(h)==min){
                count++;
            }
        }

        for(int i=0;i<A.size();i++){
            if(second_min<A.get(i)){
                B.add(A.get(i));
            }
            else if(min<A.get(i) && count>1){
                B.add(A.get(i));
            }
        }
        return B;
    }
    public static void main(String args []){
        PrettyNumbersC2 N1=new PrettyNumbersC2();
        ArrayList<Integer>A=new ArrayList<Integer>(5);
        A.add(13);A.add(15);A.add(13);A.add(2);A.add(9);A.add(3);A.add(10);A.add(10);A.add(20);A.add(13);
        System.out.println( N1.solve(A));
    }
}

