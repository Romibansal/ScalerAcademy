package Unique_Questions;

import java.util.ArrayList;


//Q=You are given an array A of N elements. Find the number of triplets i,j and k such that i<j<k and A[i]<A[j]<A[k]


public class CountIncreasingTriplets {
    public int solve(ArrayList<Integer> A) {
        int ans=0;
        for(int i=0;i<A.size();i++){
            int left=0;
            int j=i-1;
            while(j>-1){
                if(A.get(j)<A.get(i)){
                    left++;
                }
                j--;
            }
            int right=0;
            int k=i+1;
            while(k<A.size()){
                if(A.get(k)>A.get(i)){
                    right++;
                }
                k++;
            }
            ans=ans+(left*right);
        }
        return ans;
    }
    public static void main(String args []){
        CountIncreasingTriplets N1=new CountIncreasingTriplets();
        ArrayList<Integer>A=new ArrayList<>(5);
        A.add(1);A.add(2);A.add(4);A.add(3);
        System.out.println( N1.solve(A));
    }
}


