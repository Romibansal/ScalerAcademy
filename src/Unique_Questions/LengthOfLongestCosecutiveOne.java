package Unique_Questions;



import java.util.ArrayList;

//
//
//Q=Given a binary string A. It is allowed to do at most one swap between any 0 and 1.
//        Find and return the length of the longest consecutive 1’s that can be achieved.



public class LengthOfLongestCosecutiveOne {
    public int solve(String A) {
        int totalones=0;
        for(int i=0;i<A.length();i++){
            if(A.charAt(i)=='1'){
                totalones++;
            }
        }
        int ans=0;
        for(int j=0;j<A.length();j++){
            int left=0;
            int right=0;
            int k=j-1;
            while(k>-1 && A.charAt(k)!='0'){
                    left++;
                    k--;
            }
            int h=j+1;
            while(h<A.length() && A.charAt(h)!='0'){
                    right++;
                    h++;
            }
            if((left+right)==totalones){
                ans=Math.max(ans,(left+right));
            }
            else{
                ans=Math.max(ans,(left+right+1));
            }
        }
        return ans;
    }
    public static void main(String args []){
        LengthOfLongestCosecutiveOne N1=new LengthOfLongestCosecutiveOne();
        System.out.println( N1.solve("111011101"));
    }
}

