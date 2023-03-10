package Sliding_Window;

import Arrays_2D_Matrices.AntiDiagonals;

public class SubarrayWithLeastAverage {
    public int solve(int[] A, int B) {
        int sum=0;
        for(int i=0;i<B;i++){
            sum=sum+A[i];
        }
        int ans=0;
        int temp_sum=sum;
        int min=sum;
        int s=1;int l=B;
        while(l<A.length){
            temp_sum=sum-A[s-1]+A[l];
            if(temp_sum<min){
                min=temp_sum;
                ans=s;
            }
            sum=temp_sum;
            s++;l++;
        }
        return ans;
    }
    public static void main(String args []){
        SubarrayWithLeastAverage R1=new SubarrayWithLeastAverage();
        int[] A=new int[10];
        A[0]=15;
        A[1]=3;
        A[2]=15;
        A[3]=6;
        A[4]=9;
        A[5]=14;A[6]=8;A[7]=10;A[8]=9;A[9]=17;

        R1.solve(A,1);
    }
}

