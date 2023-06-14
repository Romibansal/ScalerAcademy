package Advance_Two_Pointers;

//Q=Problem Description
//        Given an array of positive integers A and an integer B, find and return
//        first continuous subarray which adds to B.
//
//        If the answer does not exist return an array with a single integer "-1".
//
//        First sub-array means the sub-array for which starting index in minimum.
//
//
//
//        Problem Constraints
//        1 <= length of the array <= 100000
//        1 <= A[i] <= 10^9
//        1 <= B <= 10^9

public class SubarrayWithGivenSum {
    public int[] solve(int[] A, int B) {
        int i=0;
        int j=0;
        int sum=0;
        while(j<A.length){
            if(sum<B){
                sum=sum+A[j];
                j++;
            }
            if(sum>B){
                sum=sum-A[i];
                i++;
            }
            if(sum==B){
                int n=j-i;
                int[] ans=new int[n];
                for(int k=0;k<n;k++){
                    ans[k]=A[i+k];
                }

                return ans;
            }
        }
        int[] ans1=new int[1];
        ans1[0]=-1;
        return ans1;
    }
    public static void main(String[] args) {
        SubarrayWithGivenSum I = new SubarrayWithGivenSum();
       int []A=new int[14];
       A[0]=36;A[1]=50;A[2]=38;A[3]=8;A[4]=13;
       A[5]=37;A[6]=33;A[7]=38;A[8]=17;A[9]=25;
       A[10]=50;A[11]=50;A[12]=41;A[13]=29;
       System.out.println(I.solve(A,100));
    }
}