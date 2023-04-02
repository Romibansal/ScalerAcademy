import Sliding_Window.SubarrayWithLeastAverage;

import java.util.HashSet;

public class ValidSudoku {
    public int isValidSudoku(final String[] A) {
        for(int i=0;i<A.length;i++){
            HashSet<Character> h=new HashSet<Character>();
            for(int j=0;j<A[i].length();j++){
                if(A[i].charAt(j)=='.'){
                    continue;
                }
                if(h.contains(A[i].charAt(j))){
                    return 0;
                }
                else{
                    h.add(A[i].charAt(j));
                }
            }
        }
        int n=A[0].length();
        for(int k=0;k<n;k++){
            HashSet<Character> h1=new HashSet<Character>();
            for(int t=0;t<A.length;t++){
                if(A[t].charAt(k)=='.'){
                    continue;
                }
                if(h1.contains(A[t].charAt(k))){
                    return 0;
                }
                else{
                    h1.add(A[t].charAt(k));
                }
            }
        }
        return 1;
    }
    public static void main(String args []){
        ValidSudoku R1=new ValidSudoku();
        String []A={"....5..1.", ".4.3.....", ".....3..1", "8......2.", "..2.7....", ".15......", ".....2...", ".2.9.....", "..4......"  };
        System.out.print(R1.isValidSudoku(A));
    }
}

