package String;

//Q=Problem Description
//        You are given two lowercase strings A and B each of length N.
//        Return 1 if they are anagrams to each other and 0 if not.
//
//        Note : Two strings A and B are called anagrams to each other if
//        A can be formed after rearranging the letters of B.
//
//        Problem Constraints
//        1 <= N <= 105
//        A and B are lowercase strings


public class CheckAnagrams {
    public int solve(String A, String B) {
        int S[]=new int [26];
        int T[]=new int [26];
        for(int j=0;j<S.length;j++){
            S[j]=0;
            T[j]=0;
        }
        for(int i=0;i<A.length();i++){
            int index=(int)A.charAt(i)-97;
            S[index]=S[index]+1;
            int ind=(int)B.charAt(i)-97;
            T[ind]=T[ind]+1;
        }
        for(int y=0;y<S.length;y++){
            if(S[y]!=T[y]){
                return 0;
            }
        }
        return 1;
    }
    public static void main(String args []){
        CheckAnagrams N1=new CheckAnagrams();
        System.out.println( N1.solve("bgipsvukg","ylwfyulte"));
    }
}

