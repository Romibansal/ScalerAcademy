package Advance_Arrays_3;

//Q=Problem Description
//        Given a vector A of non-negative integers representing an
//        elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
//
//
//
//        Problem Constraints
//        1 <= |A| <= 100000



public class RainWaterTrapped {
    public int trap(final int[] A) {
        int max=A[A.length-1];
        int mr[]=new int[A.length];
        mr[A.length-1]=max;
        for(int i=A.length-2;i>-1;i--){
            if(max<A[i]){
                max=A[i];
            }
            mr[i]=max;
        }
        int ans=0;
        int ml=0;
        for(int j=0;j<A.length;j++){
            ml=Math.max(ml,A[j]);
            ans=ans+Math.min(ml,mr[j])-A[j];
        }
        return ans;
    }
    public static void main(String args []){
        RainWaterTrapped R1=new RainWaterTrapped();
        int A[]=new int[4];
        A[0]=0; A[1]=1;
        A[2]=0; A[3]=2;
        System.out.println(R1.trap(A));
    }
}


