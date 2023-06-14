package Advance_Two_Pointers;


//Q=Problem Description
//        Given n non-negative integers A[0], A[1], ..., A[n-1] ,
//        where each represents a point at coordinate (i, A[i]).
//
//        N vertical lines are drawn such that the two endpoints of line i is at (i, A[i]) and (i, 0).
//
//        Find two lines, which together with x-axis forms a container,
//        such that the container contains the most water.
//
//        Note: You may not slant the container.
//
//
//
//        Problem Constraints
//        0 <= N <= 10^5
//        1 <= A[i] <= 10^5



public class ContainerWithMostWater {
    public int maxArea(int[] A) {
        int i=0;
        int j=A.length-1;
        int ans=((j-i)*Math.min(A[0],A[A.length-1]));
        while(i<j){
            ans=Math.max((j-i)*Math.min(A[i],A[j]),ans);
            if(A[i]<A[j]){
                i++;
            }
            else{
                j--;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        ContainerWithMostWater I = new ContainerWithMostWater();
        int []A=new int[4];
        A[0]=1;A[1]=5;A[2]=4;A[3]=3;
        System.out.println(I.maxArea(A));
    }
}

