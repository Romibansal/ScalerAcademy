package Advance_GCD;


//Q=Problem Description
//
//        You are given two positive numbers A and B . You need to find the maximum valued integer X such that:
//
//        X divides A i.e. A % X = 0
//        X and B are co-prime i.e. gcd(X, B) = 1
//
//
//        Problem Constraints
//
//        1 <= A, B <= 10^9

public class LargestCoprimeDivisor {
    int gcd (int a, int b){
        if(a==0){
            return b;
        }
        return (gcd((b%a),a));
    }
    public int cpFact(int A, int B) {
        while(gcd(A,B)!=1){
            int a=gcd(A,B);
            A= (A/a);
        }
        return A;
    }
    public static void main(String[] args) {
        LargestCoprimeDivisor I = new LargestCoprimeDivisor();
        int[] A=new int[3];
        System.out.println(I.cpFact(24,36 ));
    }
}


