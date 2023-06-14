package Advance_String_Pattern_Matching_And_Rabin_Karp;

//Q=Problem Description
//        Given a string A of size N consisting only of lowercase alphabets.
//        The only operation allowed is to insert characters in the beginning of the string.
//
//        Find and return how many minimum characters are needed to be inserted to make the
//        string a palindrome string.
//
//
//        Problem Constraints
//        1 <= N <= 10^6


public class MakeStringPalindrome {
    int pow(int number ,int pow){
        int mod=(int)Math.pow(10,9)+7;
        if(pow==0){
            return 1;
        }
        long l1=pow(number,pow/2);
        long l=((l1%mod)*(l1%mod))%mod;
        if(pow%2==0){
            return (int)l;
        }
        else{
            long x=((l%mod)*(number%mod))%mod;
            return (int)(x);
        }
    }
    public int solve(String A) {

        int mod=(int)Math.pow(10,9)+7;
        long forward_hash=0;
        long backward_hash=0;
        int ans=0;

        for(int i=0;i<A.length();i++){
            char c=A.charAt(i);
            forward_hash=(((forward_hash*29)%mod)+(c-'a'+1))%mod;
            backward_hash=(backward_hash+((long)(c-'a'+1)*(pow(29,i)))%mod)%mod;

            if(forward_hash==backward_hash){
                ans=Math.max(ans,i+1);
            }
        }
        return A.length()-ans;
    }
    public static void main(String[] args) {
        MakeStringPalindrome I = new MakeStringPalindrome();
        System.out.println(I.solve("abc"));
    }
}

