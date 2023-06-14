package Advance_Modular_Arithmetic;

import java.util.ArrayList;
import java.util.HashMap;

//Q=Problem Description
//        Given an array of integers A and an integer B, find and
//        return the number of pairs in A whose sum is divisible by B.
//
//        Since the answer may be large, return the answer modulo (10^9 + 7).
//
//
//
//        Problem Constraints
//        1 <= length of the array <= 100000
//        1 <= A[i] <= 10^9
//        1 <= B <= 10^6

public class PairSumDivisiblebyM {
    public int solve(ArrayList<Integer> A, int B) {
        HashMap<Integer, Integer> map = new HashMap<>();
        long ans=0;
        int mod=(int)Math.pow(10,9)+7;
        for(int i=0;i<A.size();i++){
            if((A.get(i)%B)==0){
                if(map.containsKey((A.get(i)%B))){
                    ans=(ans%mod+map.get((A.get(i)%B))%mod)%mod;
                    int value=map.get((A.get(i)%B));
                    value++;
                    map.put((A.get(i)%B),value);
                }
                else{
                    map.put((A.get(i)%B),1);
                }
            }
            else {
                if (map.containsKey((B - (A.get(i) % B)))) {
                    ans = (ans %mod+ map.get((B - (A.get(i) % B)))%mod)%mod;
                }
                if (map.containsKey((A.get(i) % B))) {
                    int value = map.get((A.get(i) % B));
                    value++;
                    map.put((A.get(i) % B), value);
                } else {
                    map.put((A.get(i) % B), 1);
                }
            }
        }
        return (int)ans;
    }

    public static void main(String[] args) {
        PairSumDivisiblebyM I = new PairSumDivisiblebyM();
        ArrayList<Integer>A=new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(4);
        A.add(5);
        System.out.println(I.solve(A, 2));
    }
}


