package Unique_Questions;

//Q=Given an array of integers A of size N. Return the length of maximum size subarray of A having only magic elements.
//Magic elements are numbers that divisible by 2 or 3.
//Problem Contraints
//1<=N<=10^5
//1<=A[i]<=10^9

public class MagicalNumberDivisibilityC1 {
    public int solve(int[] A) {
        int ans=0;
        int currlen=0;
        for(int i=0;i<A.length;i++){
            if(A[i]%2==0 || A[i]%3==0){
                currlen++;
            }
            else{
                currlen=0;
            }
            ans=Math.max(ans,currlen);
        }
        return ans;
    }
    public static void main(String args []){
        MagicalNumberDivisibilityC1 N1=new MagicalNumberDivisibilityC1();
        int []A=new int[3];
        A[0]=2;A[1]=6;A[2]=5;
        System.out.println( N1.solve(A));
    }
}
