package Advance_Prime_Number;

//Q=Problem Description
//        A lucky number is a number that has exactly 2 distinct prime divisors.
//
//        You are given a number A, and you need to determine the count of lucky numbers between
//        the range 1 to A (both inclusive).
//
//        Problem Constraints
//        1 <= A <= 50000

public class LuckyNumbers {
    public int solve(int A) {
        int prime[]=new int[A+1];
        prime[0]=prime[1]=1;
        int n=A+1;
        for(int i=2;i<Math.sqrt(n);i++){
            for(int j=(i*i);j<n;j=j+i){
                prime[j]=1;
            }
        }
        int ans[]=new int[n];
        for(int i=2;i<n;i++){
            if(prime[i]==0){
                for(int j=i;j<n;j=j+i){
                    ans[j]=ans[j]+1;
                }
            }
        }
        int count=0;
        for(int i=2;i<ans.length;i++){
            if(ans[i]==2){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        LuckyNumbers I = new LuckyNumbers();
        System.out.println(I.solve(12));
    }
}


