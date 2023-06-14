package Advance_GCD;

//Q=Problem Description
//
//        Given an integer array A of size N. You have to delete one
//        element such that the GCD(Greatest common divisor) of the remaining array is maximum.
//
//        Find the maximum value of GCD.
//
//
//
//        Problem Constraints
//
//        2 <= N <= 10^5
//        1 <= A[i] <= 10^9

public class DeleteOne {
    int gcd(int a,int b){
        if(a==0){
            return b;
        }
        return (gcd((b%a),a));
    }
    public int solve(int[] A) {
        int n=A.length;
        int prefix_gcd[]=new int[A.length];
        int sufix_gcd[]=new int[A.length];
        prefix_gcd[0]=A[0];
        for(int i=1;i<n;i++){
            prefix_gcd[i]=gcd(prefix_gcd[i-1],A[i]);
        }
        sufix_gcd[n-1]=A[n-1];
        for(int i=n-2;i>-1;i--){
            sufix_gcd[i]=gcd(sufix_gcd[i+1],A[i]);
        }
        int ans=sufix_gcd[1];
        for(int j=1;j<n-1;j++){
            int temp=gcd(prefix_gcd[j-1],sufix_gcd[j+1]);
            ans=Math.max(ans,temp);
        }
        ans=Math.max(ans,prefix_gcd[n-2]);
        return ans;
    }
    public static void main(String[] args) {
        DeleteOne I = new DeleteOne();
        int[] A=new int[3];
        A[0]=12;A[1]= 15;A[2]= 18;
        System.out.println(I.solve(A ));
    }
}



