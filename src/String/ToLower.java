package String;


//Q=Problem Description
//        You are given a function to_lower() which takes a character array A as an argument.
//
//        Convert each character of A into lowercase characters if it exists. If the lowercase of a
//        character does not exist, it remains unmodified.
//        The uppercase letters from A to Z are converted to lowercase letters from a to z respectively.
//
//        Return the lowercase version of the given character array.
//
//
//
//        Problem Constraints
//        1 <= |A| <= 10^5



public class ToLower {
    public char[] to_lower(char[] A) {
        for(int i=0;i<A.length;i++){
            if((int)A[i]>=65 && (int)A[i]<=90){
                A[i]=(char)((int)A[i]+32);
            }
        }
        return A;
    }
    public static void main(String args []){
        ToLower N1=new ToLower();
        char A[] = new char[9];
        A[0]='S';A[4]='e';
        A[1]='c';A[5]='r';
        A[2]='A';A[6]='A';
        A[3]='l';A[7]='c';
        A[8]='a';
        System.out.println( N1.to_lower(A));
    }
}
