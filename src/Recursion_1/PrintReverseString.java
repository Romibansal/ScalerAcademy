package Recursion_1;

import java.util.Scanner;


//Q=Problem Description
//        Write a recursive function that, given a string S, prints the characters of S in reverse order.
//
//
//
//        Problem Constraints
//        1 <= |s| <= 1000



public class PrintReverseString {
    static void Reverse(String userString, int e){
        if(e==0){
            System.out.print(userString.charAt(0));
            return;
        }
        System.out.print(userString.charAt(e));
        Reverse(userString,e-1);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userString = scanner.next();
        int e=userString.length()-1;
        Reverse(userString,e);
    }
}


