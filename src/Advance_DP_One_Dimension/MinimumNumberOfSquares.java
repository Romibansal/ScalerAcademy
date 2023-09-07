package Advance_DP_One_Dimension;

//Q=Problem Description

//        Given an integer A. Return minimum count of numbers, sum of whose squares is equal to A.
//
//
//
//        Problem Constraints

//        1 <= A <= 10^5
//
//
//
//        Input Format

//        First and only argument is an integer A.
//
//
//
//        Output Format

//        Return an integer denoting the minimum count.
//
//
//
//        Example Input

//        Input 1:
//
//        A = 6

//        Input 2:
//
//        A = 5
//
//
//        Example Output

//        Output 1:
//
//        3

//        Output 2:
//
//        2
//
//
//        Example Explanation

//        Explanation 1:
//
//        Possible combinations are : (12 + 12 + 12 + 12 + 12 + 12) and (12 + 12 + 22).
//        Minimum count of numbers, sum of whose squares is 6 is 3.

//        Explanation 2:
//
//        We can represent 5 using only 2 numbers i.e. 12 + 22 = 5


public class MinimumNumberOfSquares {
    int[] temp;

    int ways(int A){

        if(A==0){
            return 0;
        }
        if(temp[A]!=-1){
            return temp[A];
        }
        int ans = A;
        for(int i=1;i*i<=A;i++){
            ans=Math.min(ans,1+ways(A-(i*i)));
        }
        temp[A]=ans;
        return ans;
    }
    public int countMinSquares(int A) {
        temp=new int[A+1];
        for(int i=0;i<temp.length;i++){
            temp[i]=-1;
        }
        return ways(A);

    }
    public static void main(String[] args) {

        MinimumNumberOfSquares I = new MinimumNumberOfSquares();
        System.out.println( I.countMinSquares(12));
    }
}
