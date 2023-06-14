package Advance_Two_Pointers;

//Q=Problem Description
//
//        Given a sorted array of distinct integers A and an integer B,
//        find and return how many rectangles with distinct configurations can
//        be created using elements of this array as length and breadth whose area is lesser than B.
//
//        (Note that a rectangle of 2 x 3 is different from 3 x 2 if we take configuration into view)
//
//        Problem Constraints
//
//        1 <= |A| <= 100000
//        1 <= A[i] <= 10^9
//        1 <= B <= 10^9

public class AnotherCountRectangles {
    public int solve(int[] A, int B) {
        int mod=(int)Math.pow(10,9)+7;
        int i=0;
        int j=A.length-1;
        long count=0;
        while(i<=j){
            long l=A[i];
            long r=A[j];
            if(r*l>=B){
                j--;
            }
            else if(r*l<B){
                count=count+((j-i)*2)+1;
                i++;
            }
        }
        return (int)count%mod;
    }
    public static void main(String[] args) {
        AnotherCountRectangles I = new AnotherCountRectangles();
        int []A=new int[5];
        A[0]=1;A[1]=2;A[2]=3;A[3]=4;A[4]=5;
        System.out.println(I.solve(A,5));
    }
}

