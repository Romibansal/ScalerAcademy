package Advance_Backtracking_1;

import java.util.ArrayList;

public class Notes_Permutattion_With_Frequency {
    void permutation(ArrayList<Character> A, int idx, char ans[],int freq[]){
        if(idx ==A.size()){
            for(int j=0;j<ans.length;j++) {
                System.out.print(ans[j]);
            }
            System.out.println();
            return;
        }
        for(int i=0;i<26;i++){
            if(freq[i]>0){
                ans[idx]=(char)(i+'a');
                freq[i]--;
                permutation(A,idx+1,ans,freq);
                freq[i]++;
            }
        }
    }
    public int solve(ArrayList<Character> A) {
        char[] ans =new char[A.size()];
        int[] freq=new int [26];
        for(int i=0;i<A.size();i++){
            int j=A.get(i)-'a';
            freq[j]=freq[j]+1;
        }
        permutation(A,0,ans,freq);
        return  0;
    }
    public static void main(String[] args) {
        Notes_Permutattion_With_Frequency I = new Notes_Permutattion_With_Frequency();
        ArrayList<Character>A=new ArrayList<>();
        A.add('a');A.add( 'b');A.add('a');


        System.out.println( I.solve(A));
    }
}







