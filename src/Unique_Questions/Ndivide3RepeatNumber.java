package Unique_Questions;

//Q=Problem Description
//        You're given a read-only array of N integers. Find out if any integer occurs more than N/3
//        times in the array in linear time and constant additional space.
//        If so, return the integer. If not, return -1.
//
//        If there are multiple solutions, return any one.
//
//        Note: Read-only array means that the input array should not be modified in the process of solving the problem
//
//
//
//        Problem Constraints
//        1 <= N <= 7*10^5
//        1 <= A[i] <= 10^9

public class Ndivide3RepeatNumber {
    public int repeatedNumber(int[] A) {
        int count1=0;
        int count2=0;
        int ans1=-1;
        int ans2=-1;
        for(int i=0;i<A.length;i++){
            if(A[i]!=ans1 && count2==0){
                ans2=A[i];
                count2++;
            }
            else if(A[i]!=ans2 && count1==0){
                ans1=A[i];
                count1++;
            }
            else if(A[i]==ans1){
                count1++;
            }
            else if(A[i]==ans2){
                count2++;
            }
            else if(count1>0 && count2>0 && A[i]!=ans1 && A[i]!=ans2){
                count1--;
                count2--;
            }
        }
        count1=0;count2=0;
        for(int j=0;j<A.length;j++){
            if(ans1==A[j]){
                count1++;
            }
            if(ans2==A[j]){
                count2++;
            }
        }
        if(count1>A.length/3)
            return ans1;
        if(count2>A.length/3)
            return ans2;
        return -1;
    }
    public static void main(String args []){
        Ndivide3RepeatNumber N1=new Ndivide3RepeatNumber();
        int []A=new int[5];
        A[0]=1;A[1]=2;A[2]=3;A[3]=1;A[4]=1;

        System.out.println( N1.repeatedNumber(A));
    }
}





