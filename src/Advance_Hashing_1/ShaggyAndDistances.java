package Advance_Hashing_1;

import java.util.HashMap;

//Q=Problem Description
//        Shaggy has an array A consisting of N elements. We call a pair of
//        distinct indices in that array a special if elements at those indices in the array are equal.
//
//        Shaggy wants you to find a special pair such that the distance between that pair is minimum.
//        Distance between two indices is defined as |i-j|. If there is no special pair in the array,
//        then return -1.
//
//
//
//        Problem Constraints
//        1 <= |A| <= 10^5

public class ShaggyAndDistances {
    public int solve(int[] A) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans=A.length;
        for(int i=0;i<A.length;i++){
            if(map.containsKey(A[i])){
                ans=Math.min(ans,(i-map.get(A[i])));
            }
            map.put(A[i],i);

        }
        if(ans==A.length){
            return -1;
        }
        return ans;
    }
    public static void main(String[] args) {
        ShaggyAndDistances I = new ShaggyAndDistances();
        int []A=new int[6];
        A[0]=7;A[1]=1;A[2]=3;A[3]=4;A[4]=1;
        A[5]=7;
        System.out.println(I.solve(A));
    }
}
