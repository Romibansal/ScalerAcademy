package Advance_DP_Knapsack;


import java.util.ArrayList;
import java.util.List;


//Q=Problem Description
//
//        Given an array A of positive elements, you have to flip the sign of some of its elements
//        such that the resultant sum of the elements of array should be minimum non-negative
//        (as close to zero as possible).
//
//        Return the minimum number of elements whose sign needs to be flipped such that the
//        resultant sum is minimum non-negative.
//
//
//
//        Problem Constraints
//
//        1 <= length of(A) <= 100
//
//        Sum of all the elements will not exceed 10,000.
//
//
//
//        Input Format
//
//        First and only argument is an integer array A.
//
//
//
//        Output Format
//
//        Return an integer denoting the minimum number of elements whose sign needs to be flipped.
//
//
//
//        Example Input
//
//        Input 1:
//
//        A = [15, 10, 6]

//        Input 2:
//
//        A = [14, 10, 4]
//
//
//        Example Output
//
//        Output 1:
//
//        1
//        Output 2:
//
//        1
//
//
//        Example Explanation
//
//        Explanation 1:
//
//        Here, we will flip the sign of 15 and the resultant sum will be 1.
//        Explanation 2:
//
//        Here, we will flip the sign of 14 and the resultant sum will be 0.
//        Note that flipping the sign of 10 and 4 also gives the resultant sum 0 but
//        flippings there sign are not minimum.

public class FlipArray {
    ArrayList<Integer> B;
    int[][][]dp;
    int[] method(int index,int sum){
        if(index==B.size()){
            int[] temp=new int[2];
            temp[0]=sum;
            return temp;
        }
        if(dp[index][sum][1]!=-1){
            return dp[index][sum];
        }
        int ans[]=method(index+1,sum);

        if((sum-(2*B.get(index)))>=0){
            int temp[]=method(index+1,sum-(2*B.get(index)));
            if(temp[0]<=ans[0]){
                ans[0]=temp[0];
                ans[1]=temp[1]+1;
            }
            else if(temp[0]==ans[0]){
                ans[1]=Math.min(ans[1],temp[1]+1);
            }
        }
        dp[index][sum]=ans;
        return ans;

    }
    public int solve(final List<Integer> A) {
        B=new ArrayList<>();

        for(int i=0;i<A.size();i++){
            B.add(A.get(i));
        }
        int sum=0;
        for(int i=0;i<A.size();i++){
            sum=sum+A.get(i);
        }
        dp=new int[A.size()][sum+1][2];
        for(int i=0;i<A.size();i++){
            for(int j=0;j<sum+1;j++){
                dp[i][j][1]=-1;
            }
        }
        int[] t=method(0,sum);
        return t[1];


    }
    public static void main(String[] args) {
        FlipArray I = new FlipArray();
        ArrayList<Integer>A=new ArrayList<>();
        A.add(10);A.add(4);A.add(3);A.add(2);A.add(1);
        System.out.println( I.solve(A));
    }
}

