package Modular_Arthimetic_Introduction;

import Bit_Manipulation_2.FindingGoodDays;


//Q=Problem Description
//        You are given A, B and C .
//        Calculate the value of (A ^ B) % C
//


public class PowerWithModules {
    public int solve(int A, int B, int C) {
        long ans=1;
        for(int i=1;i<=B;i++){
            ans=((ans*(A%C))%C);
        }
        return (int)ans;
    }
    public static void main(String args []){
        PowerWithModules N1=new PowerWithModules();
        System.out.println( N1.solve(2,3,3));
    }
}

