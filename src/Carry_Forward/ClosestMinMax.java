package Carry_Forward;

//Q=Problem Description
//        Given an array A, find the size of the smallest subarray such that it contains at
//        least one occurrence of the maximum value of the array
//        and at least one occurrence of the minimum value of the array.
//
//
//
//        Problem Constraints
//        1 <= |A| <= 2000

public class ClosestMinMax {
    public int solve(int[] A) {
        int max=A[0];
        int min=A[0];
        for(int i=0;i<A.length;i++){
            if(A[i]>max){
                max=A[i];
            }
            if(A[i]<min){
                min=A[i];
            }
        }
        int last_min_index=-1;
        int last_max_index=-1;
        int ans =A.length;
        for(int j=0;j<A.length;j++){
            if(A[j]==min){
                last_min_index=j;
                if(last_max_index!=-1){
                    ans=Math.min(ans,j-last_max_index+1);
                }
            }
            if(A[j]==max){
                last_max_index=j;
                if(last_min_index!=-1){
                    ans=Math.min(ans,j-last_min_index+1);
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        ClosestMinMax I = new ClosestMinMax();
        int []A=new int[5];
        A[0]=2;A[1]=6;A[2]=1;A[3]=6;A[4]=9;
        System.out.println( I.solve(A));
    }
}
