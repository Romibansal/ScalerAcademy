package Unique_Questions;

//Q=Problem Description
//        Given an array, arr[] of size N, the task is to find the count of array indices such that
//        removing an element from these indices makes the sum of even-indexed and odd-indexed array elements equal.
//
//
//
//        Problem Constraints
//        1 <= n <= 10^5
//        -10^5 <= A[i] <= 10^5



public class SpecialIndex {
    public int solve(int[] A) {
        int n=A.length;
        int [] e=new int [n];
        int [] o=new int [n];
        e[0]=A[0];
        int count=0;
        for(int i=1;i<A.length;i++){
            if(i%2==0){
                e[i]=e[i-1]+A[i];
            }
            else{
                e[i]=e[i-1];
            }
        }
        o[0]=0;
        for(int j=1;j<A.length;j++){
            if(j%2!=0){
                o[j]=o[j-1]+A[j];
            }
            else{
                o[j]=o[j-1];
            }
        }
        for(int k=0;k<A.length;k++){
            int l=0;
            int r=k-1;
            int sum_o=0;
            int sum_e=0;
            if(r<0){
                sum_o=0;
                sum_e=0;
            }
            else{
                sum_o=o[r];
                sum_e=e[r];
            }
            int le=k;
            int ri=A.length-1;
            int sum_od=o[ri]-o[le];
            int sum_ev=e[ri]-e[le];
            if((sum_e+sum_od)==(sum_o+sum_ev)){
                count++;
            }
        }
        return count;
    }
    public static void main(String args []){
        SpecialIndex N1=new SpecialIndex();
        int []A=new int[4];
        A[0]=2;A[1]=1;A[2]=6;A[3]=4;
        System.out.println( N1.solve(A));
    }
}





