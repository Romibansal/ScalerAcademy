package Hashing_2;

import java.util.HashSet;
//
//Q=Determine if a Sudoku is valid, according to: http://sudoku.com.au/TheRules.aspx
//
//        The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
//
//        The input corresponding to the above configuration :
//
//        ["53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79"]
//        A partially filled sudoku which is valid.
//
//        Note:
//
//        A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
//
//        Return 0 / 1 ( 0 for false, 1 for true ) for this problem

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
        for(int m=0;m<7;m++){
            HashSet<Character> h3=new HashSet<Character>();
            for(int g=0;g<3;g++){
                for(int z=0+m;z<3+m;z++){
                    if(A[g].charAt(z)=='.'){
                        continue;
                    }
                    if(h3.contains(A[g].charAt(z))){
                        return 0;
                    }
                    else{
                        h3.add(A[g].charAt(z));
                    }
                }
            }
            m=m+2;
        }
        for(int s=0;s<7;s++){
            HashSet<Character> h4=new HashSet<Character>();
            for(int q=3;q<6;q++){
                for(int v=0+s;v<3+s;v++){
                    if(A[q].charAt(v)=='.'){
                        continue;
                    }
                    if(h4.contains(A[q].charAt(v))){
                        return 0;
                    }
                    else{
                        h4.add(A[q].charAt(v));
                    }
                }
            }
            s=s+2;
        }
        for(int w=0;w<7;w++){
            HashSet<Character> h5=new HashSet<Character>();
            for(int u=6;u<9;u++){
                for(int l=0+w;l<3+w;l++){
                    if(A[u].charAt(l)=='.'){
                        continue;
                    }
                    if(h5.contains(A[u].charAt(l))){
                        return 0;
                    }
                    else{
                        h5.add(A[u].charAt(l));
                    }
                }
            }
            w=w+2;
        }
        return 1;
    }
    public static void main(String args []){
        ValidSudoku R1=new ValidSudoku();
        String []A={"..5.....6", "....14...", ".........", ".....92..", "5....2...", ".......3.", "...54....", "3.....42.", "...27.6.."};
        System.out.print(R1.isValidSudoku(A));
    }
}

