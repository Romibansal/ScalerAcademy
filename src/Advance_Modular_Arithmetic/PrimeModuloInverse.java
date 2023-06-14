package Advance_Modular_Arithmetic;

//Q-Problem Description
//        Given two integers A and B. Find the value of A^-1 mod B where B is a prime number and gcd(A, B) = 1.
//
//        A^-1 mod B is also known as modular multiplicative inverse of A under modulo B.
//
//
//
//        Problem Constraints
//        1 <= A <= 10^9
//        1<= B <= 10^9
//        B is a prime number

public class PrimeModuloInverse {
    int power(int A,int pow,int B){
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
    public int solve(int A, int B) {
        int pow=(B-2);
        int ans=power(A,pow,B);
        return ans;
    }

    public static void main(String[] args) {
        PrimeModuloInverse I = new PrimeModuloInverse();
        System.out.println(I.solve(12, 55557209));
    }
}

