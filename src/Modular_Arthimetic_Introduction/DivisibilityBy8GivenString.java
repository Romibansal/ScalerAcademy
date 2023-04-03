package Modular_Arthimetic_Introduction;


//Q=Problem Description
//        You are given a number A in the form of a string. Check if the number is divisible by eight or not.
//
//        Return 1 if it is divisible by eight else, return 0.


public class DivisibilityBy8GivenString {
    public int solve(String A) {
        int num=0;
        int j=0;
        for(int i=A.length()-1;i>-1;i--){
            int r=Integer.parseInt(String.valueOf(A.charAt(i)));
            num=num+r*((int)Math.pow(10,j));
            j++;
            if(j==3){
                break;
            }
        }
        if(num%8==0){
            return 1;
        }
        return 0;
    }
    public static void main(String args []){
        DivisibilityBy8GivenString N1=new DivisibilityBy8GivenString();
        System.out.println( N1.solve("7878787878800"));
    }
}
