package Modular_Arthimetic_Introduction;


//Q=Problem Description
//        Given three 2-digit integers, A, B, and C, find out the minimum number obtained by concatenating
//        them in any order.
//        Return the minimum result obtained.

public class ConcatenateThreeNumbers {
    public int solve(int A, int B, int C) {
        int first=A;
        int second=B;
        int third=C;
        if(first>second){
            int temp=first;
            first=second;
            second=temp;
        }
        if(second>third){
            int temp1=second;
            second=third;
            third=temp1;
        }
        if(first>second){
            int temp2=first;
            first=second;
            second=temp2;
        }

        int ans=(int)((first*(Math.pow(10,4)))+(second*(Math.pow(10,2)))+third);
        return ans;
    }
    public static void main(String args []){
        ConcatenateThreeNumbers N1=new ConcatenateThreeNumbers();
        System.out.println( N1.solve(10,45,47));
    }
}
