package Advance_Array_Two_Dimensional;

//Q=Problem Description
//
//        Given an array of integers A and an integer B, find and return
//        the minimum number of swaps required to bring all the numbers less than or equal to B together.
//
//        Note: It is possible to swap any two elements, not necessarily consecutive.
//
//
//
//        Problem Constraints
//
//        1 <= length of the array <= 100000
//        -10^9 <= A[i], B <= 10^9

public class MinimumSwaps {
    public int solve(int[] A, int B) {
        int total_number=0;
        for(int i=0;i<A.length;i++){
            if(A[i]<=B){
                total_number++;
            }
        }
        int bad_words=0;
        for(int i=0;i<total_number;i++){
            if(A[i]>B){
                bad_words++;
            }
        }
        int ans=bad_words;
        int s=1;
        int l=total_number;
        while(l<A.length){
            if(A[s-1]>B){
                bad_words--;
            }
            if(A[l]>B){
                bad_words++;
            }
            ans=Math.min(ans,bad_words);
            s++;
            l++;
        }
        return ans;
    }
    public static void main(String args []){
        MinimumSwaps R1=new MinimumSwaps();
        int A[]=new int[7];
        A[0]=1;
        A[1]=12;
        A[2]=10;
        A[3]=3;
        A[4]=14;
        A[5]=10;
        A[6]=5;
        System.out.println(R1.solve(A,8));
    }
}