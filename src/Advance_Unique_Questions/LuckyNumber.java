package Advance_Unique_Questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

//Q=The queen had a tresure map,that was divided into grid of N*M squares. Each square had distinct number on it.
//The queen wanted to find all the lucky numbers on the map. A lucky number was a number that was the smallest in
//its row and the largest in its column.
// Find all the lucky numbers on the treasure map and return them in sorted order?

// Problem Constraints
// 1<=N,M<=10^3
// 1<=A[i][j]<=10^9


public class LuckyNumber {
    public int[] solve(int[][] A) {
        int N=A.length;
        int M=A[0].length;
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<N;i++){
            int min=A[i][0];
            int min_ind=0;
            for(int j=0;j<M;j++){
                if(min>A[i][j]){
                    min=A[i][j];
                    min_ind=j;
                }
            }
            if(hm.containsKey(min_ind)){
                if(hm.get(min_ind)<min){
                    hm.put(min_ind,min);
                }
            }
            else{
                hm.put(min_ind,min);
            }
        }
        ArrayList<Integer> B=new ArrayList<>();
        for(int h=0;h<M;h++){
            if(hm.containsKey(h)){
                int flag=0;
                int max=hm.get(h);
                for(int t=0;t<N;t++){
                    if(max<A[t][h]){
                        flag=1;
                        break;
                    }
                }
                if(flag==0){
                    B.add(max);
                }
            }
        }
        Collections.sort(B);
        int ans[]=new int[B.size()];
        for(int l=0;l<ans.length;l++){
            ans[l]=B.get(l);
        }
        return ans;
    }

    public static void main(String[] args) {
        LuckyNumber I = new LuckyNumber();
        int[][] A=new int[2][2];
        A[0][0]=1;
        A[0][1]=2;
        A[1][0]=3;
        A[1][1]=4;
        System.out.println(I.solve(A));
    }
}

