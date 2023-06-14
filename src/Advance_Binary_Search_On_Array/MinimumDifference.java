package Advance_Binary_Search_On_Array;

import java.util.ArrayList;
import java.util.Collections;

//Q=Problem Description
//        You are given a 2-D matrix C of size A × B.
//        You need to build a new 1-D array of size A by taking one element from each
//        row of the 2-D matrix in such a way that the cost of the newly built array is minimized.
//
//        The cost of an array is the minimum possible value of the absolute
//        difference between any two adjacent elements of the array.
//
//        So if the newly built array is X, the element picked from row 1 will become X[1],
//        element picked from row 2 will become X[2], and so on.
//
//        Determine the minimum cost of the newly built array.
//
//
//
//        Problem Constraints
//        2 <= A <= 1000
//        2 <= B <= 1000
//        1 <= C[i][j] <= 10^6

public class MinimumDifference {
    public int diff_min(ArrayList<Integer> A, int M){
        int low = 0;
        int high = A.size() - 1;
        while(low <= high){
            int mid = low+(high-low)/2;
            if(A.get(mid)==M){
                return mid;
            }
            if( A.get(mid) < M ){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return high;
    }

    public int diff_max(ArrayList<Integer> A, int M){
        int low = 0;
        int high = A.size() - 1;
        while(low <= high){
            int mid = low+(high-low)/2;
            if(A.get(mid)==M){
                return mid;
            }
            if( A.get(mid) < M ){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return low;
    }

    public int solve(int A, int B, ArrayList<ArrayList<Integer>> C) {
        for(int i=0;i<A;i++){
            ArrayList<Integer> temp= C.get(i);
            Collections.sort(temp);
            C.set(i,temp);
        }
        int ans=1000000000;
        int num=-1;
        for(int i=0;i<C.size()-1;i++){
            ArrayList<Integer> a1= new ArrayList<>(C.get(i));
            ArrayList<Integer>a2=new ArrayList<>(C.get(i+1));
            for(int j=0;j<a1.size();j++){
                int num_min= diff_min(a2,a1.get(j));
                if(num_min>-1){
                    num=a1.get(j)-a2.get(num_min);
                    ans=Math.min(ans,num);
                }
                if(num!=0){
                    int num_max= diff_max(a2,a1.get(j));
                    if(num_max<C.get(0).size()){
                        num=a2.get(num_max)-a1.get(j);
                        ans=Math.min(ans,num);
                    }
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        MinimumDifference I = new MinimumDifference();
        ArrayList<ArrayList<Integer>> A=new ArrayList<>();
        ArrayList<Integer>a1=new ArrayList<>();
        a1.add(8);a1.add(4);
        ArrayList<Integer>a2=new ArrayList<>();
        a2.add(6);a2.add(8);
        A.add(a1);A.add(a2);
        System.out.println(I.solve(2,2,A));
    }
}
