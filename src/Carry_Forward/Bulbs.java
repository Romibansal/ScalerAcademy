package Carry_Forward;

//Q=Problem Description
//        A wire connects N light bulbs.
//
//        Each bulb has a switch associated with it; however, due to faulty wiring,
//        a switch also changes the state of all the bulbs to the right of the current bulb.
//
//        Given an initial state of all bulbs, find the minimum number of switches you have to press to turn on all the bulbs.
//
//        You can press the same switch multiple times.
//
//        Note: 0 represents the bulb is off and 1 represents the bulb is on.
//
//
//        Problem Constraints
//        0 <= N <= 5×10^5
//        0 <= A[i] <= 1



public class Bulbs {
    public int bulbs(int[] A) {
        int count=0;
        for(int i=0;i<A.length;i++){
            if(A[i]==0 && count%2==0){
                count++;
            }
            else if(A[i]==1 && count%2!=0){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Bulbs I = new Bulbs();
        int []A=new int[4];
        A[0]=0;A[1]=1;A[2]=0;A[3]=1;
        System.out.println( I.bulbs(A));
    }
}
