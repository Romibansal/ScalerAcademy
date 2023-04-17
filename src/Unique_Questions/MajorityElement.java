package Unique_Questions;

//Q=Problem Description
//        Given an array of size N, find the majority element.
//        The majority element is the element that appears more than floor(n/2) times.
//        You may assume that the array is non-empty and the majority element always exists in the array.
//
//
//
//        Problem Constraints
//        1 <= N <= 5*10^5
//        1 <= num[i] <= 10^9


public class MajorityElement {
    public int majorityElement(final int[] A) {
        int count=1;
        int result=A[0];
        for(int i=1;i<A.length;i++){
            if(A[i]==result){
                count++;
            }
            else{
                if(count>1){
                    count--;
                }
                else{
                    count=1;
                    result=A[i];
                }
            }
        }
        return result;

    }
    public static void main(String args []){
        MajorityElement N1=new MajorityElement();
        int []A=new int[3];
        A[0]=2;A[1]=1;A[2]=2;
        System.out.println( N1.majorityElement(A));
    }
}





