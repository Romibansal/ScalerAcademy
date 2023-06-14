package Advance_Prime_Number;

//Q=Problem Description
//        Given an even number A ( greater than 2 ), return
//        two prime numbers whose sum will be equal to the given number.
//
//        If there is more than one solution possible, return the lexicographically smaller solution.
//
//        If [a, b] is one solution with a <= b, and [c,d] is another solution with c <= d, then
//        [a, b] < [c, d], If a < c OR a==c AND b < d.
//        NOTE: A solution will always exist. Read Goldbach's conjecture.
//
//
//
//        Problem Constraints
//        4 <= A <= 2*10^7

public class PrimeSum {
    public int[] primesum(int A) {
        int prime[]=new int[A+1];
        int n=A+1;
        prime[0]=prime[1]=1;
        for(int i=2;i<Math.sqrt(n);i++){
            if(prime[i]==0){
                for(int j=(i*i);j<n;j=j+i){
                    prime[j]=1;
                }
            }
        }
        int ans[]=new int[2];
        for(int i=2;i<prime.length;i++){
            if(prime[i]==0){
                int number=A-i;
                if(prime[number]==0){
                    ans[0]=i;
                    ans[1]=number;
                    return ans;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        PrimeSum I = new PrimeSum();
        System.out.println(I.primesum(2 ));
    }
}



