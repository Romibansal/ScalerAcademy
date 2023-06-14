package Adnvance_Combinatorics_Basics;

//Q=Problem Description
//        Given three integers A, B, and C, where A represents n, B represents r,
//        and C represents p and p is a prime number greater than equal to n, find and
//        return the value of nCr % p where nCr % p = (n! / ((n-r)! * r!)) % p.
//
//        x! means factorial of x i.e. x! = 1 * 2 * 3... * x.
//
//        NOTE: For this problem, we are considering 1 as a prime.
//
//
//        Problem Constraints
//        1 <= A <= 10^6
//        1 <= B <= A
//        A <= C <= 10^9+7

public class ComputeNcRModP {
    int power(int a,int b,int m){
        if(a==0){
            return 0;
        }
        if(b==0){
            return 1;
        }
        long p=power(a,b/2,m);
        long l=(p%m*p%m)%m;
        if(b%2==0){
            return (int)l%m;
        }

        else{
            return (int)((l%m)*a%m)%m;
        }
    }
    public int solve(int A, int B, int C) {
        int fact[]=new int[1000001];
        fact[0]=1;
        for(int i=1;i<=A;i++){
            long h=((fact[i-1])%C*((long)i%C))%C;
            fact[i]=(int)h%C;
        }
        int f2=fact[A];
        long f=power(fact[(A-B)],(C-2),C);
        int f1=power(fact[B],(C-2),C);
        long ans=((f2%C)*(f%C))%C;
        ans=((ans%C)*(f1%C))%C;
        return (int) ans;
    }
    public static void main(String[] args) {
        ComputeNcRModP I = new ComputeNcRModP();
        System.out.println(I.solve(1000000, 1,1000000007));
    }
}



