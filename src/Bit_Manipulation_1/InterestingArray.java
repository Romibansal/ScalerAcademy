package Bit_Manipulation_1;

//Q=Problem Description
//        You have an array A with N elements. We have two types of operation available on this array :
//        We can split an element B into two elements, C and D, such that B = C + D.
//        We can merge two elements, P and Q, to one element, R, such that R = P ^ Q i.e., XOR of P and Q.
//        You have to determine whether it is possible to convert array A to size 1, containing a single element equal to 0 after several splits and/or merge?
//
//
//
//        Problem Constraints
//        1 <= N <= 100000
//
//        1 <= A[i] <= 10^6



public class InterestingArray {
    public String solve(int[] A) {
        int N = A.length;
        int odd = 0;

        for(int i = 0; i < N; i++){
            if((A[i]%2)!= 0){
                odd++;
            }
        }

        if((odd%2)!=0){
            return "No";
        }

        return "Yes";

    }
    public static void main(String args []){
        InterestingArray S1=new InterestingArray();
        int A[]=new int[2];
        A[0]=9;
        A[1]=17;
        System.out.println( S1.solve(A));
    }
}

