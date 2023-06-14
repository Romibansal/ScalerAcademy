package Advance_Binary_Search_Problem2;

//Q=Problem Description
//        You are given three positive integers, A, B, and C.
//
//        Any positive integer is magical if divisible by either B or C.
//
//        Return the Ath smallest magical number. Since the answer may be very large, return modulo 10^9 + 7.
//
//        Note: Ensure to prevent integer overflow while calculating.
//
//
//
//        Problem Constraints
//        1 <= A <= 10^9
//
//        2 <= B, C <= 40000

public class AthMagicalNumber {
    int gcd(int B,int C){
        if(B==0){
            return C;
        }
        return gcd(C%B,B);
    }
    public int solve(int A, int B, int C) {
        int mod=(int)Math.pow(10,9)+7;
        long hcf=gcd(B,C);
        long lcm=(B*C)/hcf;
        long st=Math.min(B,C);
        long end=A*st;
        while(st<=end){
            long mid=st+(end-st)/2;
            long count=(mid/B)+(mid/C)-(mid/lcm);
            if(count==A && (mid%B==0 || mid%C==0)){
                return (int)(mid%mod);
            }
            if(count>=A){
                end=mid-1;
            }
            else{
                st=mid+1;
            }
        }
        return-1;
    }
    public static void main(String[] args) {
        AthMagicalNumber I = new AthMagicalNumber();

        System.out.println(I.solve(807414236,3788,38141));
    }
}
