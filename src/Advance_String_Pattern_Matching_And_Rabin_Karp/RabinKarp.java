package Advance_String_Pattern_Matching_And_Rabin_Karp;

public class RabinKarp {
    int pow_function(int A,long pow){
        int mod=(int)Math.pow(10,9)+7;
        if(pow==0){
            return 1;
        }
        long p=pow_function(A,pow/2);
        long l=(p%mod*p%mod)%mod;
        if(pow%2==0){
            return (int)l%mod;
        }

        else{
            return (int)((l%mod)*A%mod)%mod;
        }
    }
    public int solve(String A, String B) {
        long b=0;
        int mod=(int)Math.pow(10,9)+7;
        for(int i=0;i<B.length();i++){
            int num=(B.charAt(i)-'a'+1);
            int pow=B.length()-1-i;
            long l=pow_function(29,pow);
            b=b%mod+(l%mod*num%mod)%mod;
        }
        long temp=0;
        for(int i=0;i<B.length();i++){
            int temp_num=(A.charAt(i)-'a'+1);
            int temp_pow=B.length()-1-i;
            long temp_l=(long)pow_function(29,temp_pow);
            temp=temp%mod+(temp_l%mod*temp_num%mod)%mod;
        }
        int ans=0;
        if(temp==b){
            ans++;
        }
        int l=1;
        int r=B.length();
        while(r<A.length()){
            long remove_element=(A.charAt(l-1)-'a'+1);
            long remove=remove_element*(long)pow_function(29,B.length()-1);
            temp=(temp-remove +mod)%mod;
            temp=(temp%mod*29)%mod;
            temp=temp+(A.charAt(r)-'a'+1);
            if(temp==b){
                ans++;
            }
            l++;
            r++;
        }
        return ans;
    }
    public static void main(String[] args) {
            RabinKarp I = new RabinKarp();
            System.out.println(I.solve("ccbcdaacc","ac"));
    }
}
