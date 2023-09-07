package Advance_Backtracking_2;

import java.util.ArrayList;

//Q=Problem Description
//        Write a program to solve a Sudoku puzzle by filling the empty cells.
//        Empty cells are indicated by the character '.' You may assume that there will be only one unique solution.
//
//
//
//        A sudoku puzzle,
//
//
//
//        and its solution numbers marked in red.
//
//
//
//        Problem Constraints
//        N = 9
//
//

//        Input Format

//        First argument is an array of array of characters representing the Sudoku puzzle.
//
//
//        Output Format

//        Modify the given input to the required answer.
//
//
//        Example Input

//        Input 1:
//
//        A = [[53..7....], [6..195...], [.98....6.], [8...6...3], [4..8.3..1], [7...2...6],
//        [.6....28.], [...419..5], [....8..79]]
//
//
//        Example Output
//        Output 1:
//
//        [[534678912], [672195348], [198342567], [859761423], [426853791], [713924856],
//        [961537284], [287419635], [345286179]]
//
//
//        Example Explanation

//        Explanation 1:
//
//        Look at the diagrams given in the question.


public class Sudoku {

    boolean isValid(int x,int row,int column,ArrayList<ArrayList<Character>> a){
        for(int k=0;k<9;k++){
            if((a.get(k).get(column))-'0' ==x) {
                return false;
            }
        }
        for(int k=0;k<9;k++){
            if((a.get(row).get(k))-'0' ==x) {
                return false;
            }
        }
        int top_left_row=row-(row%3);
        int top_left_column=column-(column%3);
        for(int s=0;s<3;s++){
            for(int t=0;t<3;t++){
                if((a.get(top_left_row+s).get(top_left_column+t))-'0'==x){
                    return false;
                }
            }
        }
        return true;
    }
    boolean permutation(ArrayList<ArrayList<Character>> a,int x,int y){
        if(y==9){
            x=x+1;
            y=0;
        }
        if(x==9){
            return true;
        }
        if(a.get(x).get(y)!='.'){
             if(permutation(a,x,y+1)){
                 return true;
             }
            return false;
        }
        else{
            for(int i=1;i<10;i++){
                if(isValid(i,x,y,a)){
                    ArrayList<Character>temp= a.get(x);
                    temp.set(y,(char)(i+'0'));
                    if(permutation(a,x,y+1)) {
                        return true;
                    }
                    else {
                        ArrayList<Character>t1= a.get(x);
                        t1.set(y,'.');
                    }
                }

            }
        }
        return false;
    }
    public void solveSudoku(ArrayList<ArrayList<Character>> a) {
        permutation(a,0,0);
    }
    public static void main(String[] args) {
        Sudoku I = new Sudoku();
        ArrayList<ArrayList<Character>>A=new ArrayList<>();
        ArrayList<Character>a1=new ArrayList<>();
        a1.add('5');a1.add('3');a1.add('.');a1.add('.');a1.add('7');a1.add('.');a1.add('.');
        a1.add('.');a1.add('.');

        ArrayList<Character>a2=new ArrayList<>();
        a2.add('6');a2.add('.');a2.add('.');a2.add('1');a2.add('9');a2.add('5');a2.add('.');a2.add('.');a2.add('.');

        ArrayList<Character>a3=new ArrayList<>();
        a3.add('.');a3.add('9');a3.add('8');a3.add('.');a3.add('.');a3.add('.');a3.add('.');a3.add('6');a3.add('.');

        ArrayList<Character>a4=new ArrayList<>();
        a4.add('8');a4.add('.');a4.add('.');a4.add('.');a4.add('6');a4.add('.');a4.add('.');a4.add('.');a4.add('3');

        ArrayList<Character>a5=new ArrayList<>();
        a5.add('4');a5.add('.');a5.add('.');a5.add('8');a5.add('.');a5.add('3');a5.add('.');a5.add('.');a5.add('1');

        ArrayList<Character>a6=new ArrayList<>();
        a6.add('7');a6.add('.');a6.add('.');a6.add('.');a6.add('2');a6.add('.');a6.add('.');a6.add('.');a6.add('6');

        ArrayList<Character>a7=new ArrayList<>();
        a7.add('.');a7.add('6');a7.add('.');a7.add('.');a7.add('.');a7.add('.');a7.add('2');a7.add('8');a7.add('.');

        ArrayList<Character>a8=new ArrayList<>();
        a8.add('.');a8.add('.');a8.add('.');a8.add('4');a8.add('1');a8.add('9');a8.add('.');a8.add('.');a8.add('5');

        ArrayList<Character>a9=new ArrayList<>();
        a9.add('.');a9.add('.');a9.add('.');a9.add('.');a9.add('8');a9.add('.');a9.add('.');a9.add('7');a9.add('9');

        A.add(a1);A.add(a2);A.add(a3);A.add(a4);A.add(a5);A.add(a6);A.add(a7);A.add(a8);A.add(a9);
         I.solveSudoku(A);
    }
}




