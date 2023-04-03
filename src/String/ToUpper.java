package String;

//Q=Problem Description
//        You are given a function to_upper() consisting of a character array A.
//
//        Convert each charater of A into Uppercase character if it exists. If the Uppercase of a
//        character does not exist, it remains unmodified.
//        The lowercase letters from a to z is converted to uppercase letters from A to Z respectively.
//
//        Return the uppercase version of the given character array.
//
//
//
//        Problem Constraints
//        1 <= |A| <= 10^5


public class ToUpper {
    public char[] to_upper(char[] A) {
        for(int i=0;i<A.length;i++){
            if(A[i]>=97 && A[i]<=122){
                A[i]=(char)((int)A[i]-32);
            }
        }
        return A;
    }
    public static void main(String args []){
        ToUpper N1=new ToUpper();
        char A[] = new char[9];
        A[0]='S';A[4]='e';
        A[1]='c';A[5]='r';
        A[2]='A';A[6]='A';
        A[3]='l';A[7]='c';
        A[8]='a';
        System.out.println( N1.to_upper(A));
    }
}
