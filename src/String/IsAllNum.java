package String;


//Q=Problem Description
//        You are given a function isalpha() consisting of a character array A.
//
//        Return 1 if all the characters of a character array are alphanumeric (a-z, A-Z, and 0-9) else, return 0.
//
//
//
//        Problem Constraints
//        1 <= |A| <= 10^5




public class IsAllNum {
    public int solve(char[] A) {
        for(int i=0;i<A.length;i++){
            if(A[i]>=65 && A[i]<=90){
                continue;
            }
            else if(A[i]>=97 && A[i]<=122){
                continue;
            }
            else if(A[i]>=48 && A[i]<=57){
                continue;
            }
            else{
                return 0;
            }
        }
        return 1;
    }
    public static void main(String args []){
        IsAllNum N1=new IsAllNum();
       char A[] = new char[17];
       A[0]='S';
       A[1]='c'; A[2]='a'; A[3]='l';A[4]='e'; A[5]='r';
        A[6]='A'; A[7]='c'; A[8]='a'; A[9]='d';A[10]= 'e';
        A[11]='m'; A[12]='y';A[13]='2';A[14]='0';A[15]='2';A[16]= '0';
        System.out.println( N1.solve(A));
    }
}
