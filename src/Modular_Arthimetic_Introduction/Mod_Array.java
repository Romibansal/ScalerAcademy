package Modular_Arthimetic_Introduction;



//Q=Problem Description
//        You are given a large number in the form of a array A of size N where each element denotes a digit of the number.
//        You are also given a number B. You have to find out the value of A % B and return it.
//
//
//
//        Problem Constraints
//        1 <= N <= 10^5
//        0 <= A[i] <= 9
//        1 <= B <= 10^9


public class Mod_Array {
    public int solve(int[] A, int B) {
        long t=1;  //(10^0)%B
        int sum=0;
        for(int i=A.length-1;i>-1;i--){
            sum=(int)(sum+((A[i]*t)%B))%B;
            t=(t*10)%B;
        }
        return sum;
    }
    public static void main(String args []){
        Mod_Array N1=new Mod_Array();
        int A[]=new int[3];
        A[0]=1;
        A[1]=4;
        A[2]=3;
        int B = 2;
        System.out.println( N1.solve(A,B));
    }
}
