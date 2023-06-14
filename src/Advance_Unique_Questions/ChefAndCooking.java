package Advance_Unique_Questions;
//
//Q= One day, the chef decided to create a new dish that consists of a sequence of ingredients. Each
//ingredient has a distinct weight and chef wants to choose a subarray of ingredients that have an increasing
//weight . The chef wants to know the max possible sum of weights of the ascending subarray she can choose
//Help the chef by writing a function that returns the max possible sum of an ascending subarray in the
//weights of the ingredients?
//
//
//Problem Contraints
//    1<=|A|<=10^5
//    1<=A[i]<=10^9


public class ChefAndCooking {
    public long solve(int[] A) {
        long ans=0;
        long sum=A[0];
        for(int i=0;i<A.length-1;i++){
            if(A[i]<A[i+1]){
                sum=sum+A[i+1];
                ans=Math.max(ans,sum);
            }
            else{
                ans=Math.max(ans,sum);
                sum=A[i+1];
            }
        }
        if(A[A.length-1]>sum){
            return A[A.length-1];
        }
        return ans;
    }
    public static void main(String[] args) {
        ChefAndCooking I = new ChefAndCooking();
        int A[]=new int[5];
        A[0]=1;A[1]=2;A[2]=3;A[3]=4;A[4]=5;
        System.out.println(I.solve(A));
    }
}


