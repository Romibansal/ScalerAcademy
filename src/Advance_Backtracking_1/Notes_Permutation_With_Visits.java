package Advance_Backtracking_1;

import java.util.ArrayList;

public class Notes_Permutation_With_Visits {
    void pemutation(ArrayList<Character> A, int idx, char ans[], ArrayList<Integer>visited){
        if(idx ==A.size()){
            for(int j=0;j<ans.length;j++) {
                System.out.print(ans[j]);
            }
            System.out.println();
            return;
        }
        for(int i=0;i<A.size();i++){
            if(visited.get(i)==0){
                visited.set(i,1);
                char c=A.get(i);
                ans[idx]=c;
                pemutation(A,idx+1,ans,visited);
                visited.set(i,0);
            }
        }
    }
    public int solve(ArrayList<Character> A) {
       char[] ans =new char[A.size()];
        ArrayList<Integer>visited=new ArrayList<>();
        visited.add(0);visited.add(0);visited.add(0);
        pemutation(A,0,ans,visited);
        return  0;
    }
    public static void main(String[] args) {
        Notes_Permutation_With_Visits I = new Notes_Permutation_With_Visits();
        ArrayList<Character>A=new ArrayList<>();
        A.add('a');A.add( 'b');A.add('c');


        System.out.println( I.solve(A));
    }
}






