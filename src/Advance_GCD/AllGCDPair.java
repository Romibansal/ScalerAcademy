package Advance_GCD;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

//Q=Problem Description
//        Given an array of integers A of size N containing GCD of every possible pair of
//        elements of another array.
//
//        Find and return the original numbers used to calculate the GCD array in any order.
//        For example, if original numbers are {2, 8, 10} then the given array will be {2, 2, 2, 2, 8, 2, 2, 2, 10}.
//
//
//
//        Problem Constraints
//        1 <= N <= 10000
//
//        1 <= A[i] <= 10^9

public class AllGCDPair {
    int gcd(int a, int b){
        if(a==0){
            return b;
        }
        return (gcd((b%a),a));
    }
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        ArrayList<Integer>ans =new ArrayList<>();
        Collections.sort(A, Collections.reverseOrder());
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<A.size();i++){
            if(map.containsKey(A.get(i))){
                int value=map.get(A.get(i));
                value--;
                if(value==0){
                    map.remove(A.get(i));
                }
                else{
                    map.put(A.get(i),value);
                }
            }
            else{
                ans.add(A.get(i));
                for(int j=0;j<ans.size()-1;j++){
                    int key=gcd(A.get(i),ans.get(j));
                    if(map.containsKey(key)){
                        int v=map.get(key);
                        v=v+2;
                        map.put(key,v);
                    }
                    else{
                        map.put(key,2);
                    }
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        AllGCDPair I = new AllGCDPair();
        ArrayList<Integer>A=new ArrayList<>();
        A.add(2);A.add(2);A.add(2);A.add(2);A.add(8);A.add(2);A.add(2);A.add(2);A.add(10);
        System.out.println(I.solve(A ));
    }
}

