package Advance_Modular_Arithmetic;

//Q=Problem Description
//        Given two Integers A, B. You have to calculate (A ^ (B!)) % (1e9 + 7).
//
//        "^" means power,
//
//        "%" means "mod", and
//
//        "!" means factorial.
//
//        Problem Constraints
//        1 <= A, B <= 5e5

public class VeryLargePower {
    int power(int A,long pow,int B){
        if(A==0){
            return 0;
        }
        if(pow==0){
            return 1;
        }
        long p=power(A,pow/2,B);
        long l=(p%B*p%B)%B;
        if(pow%2==0){
            return (int)l%B;
        }

        else{
            return (int)((l%B)*A%B)%B;
        }
    }

    long factorial(int B){
        int mod=(int)Math.pow(10,9)+7;
        long p=1;
        for(int i=1;i<B+1;i++){
            p=(i*p)%(mod-1);
        }
        return p;
    }
    public int solve(int A, int B) {
        long pow=factorial(B);
        int mod=(int)Math.pow(10,9)+7;
        int result=power(A,pow,mod);
        return result;
    }

    public static void main(String[] args) {
        VeryLargePower I = new VeryLargePower();
        System.out.println(I.solve(2, 27));
    }
}

