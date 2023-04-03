package Modular_Arthimetic_Introduction;



//Q=Problem Description
//        Given an integer A representing a year, Return 1 if it is a leap year else, return 0.
//
//        A year is a leap year if the following conditions are satisfied:
//
//        The year is multiple of 400.
//        or the year is multiple of 4 and not multiple of 100.
//


public class Leapyear {
    public int solve(int A) {
        int B=A%100;
        if(A%400==0){
            return 1;
        }
        if( B%4==0 && A%100!=0){
            return 1;
        }
        return 0;
    }
    public static void main(String args []){
        Leapyear N1=new Leapyear();
        System.out.println( N1.solve(1999));
    }
}