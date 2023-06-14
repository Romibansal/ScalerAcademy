package Advance_Prime_Number;

//Q=Problem Description
//        Given an array of integers A, find and return the count of divisors of each element of the array.
//
//        NOTE: The order of the resultant array should be the same as the input array.
//
//
//
//        Problem Constraints
//        1 <= length of the array <= 100000
//        1 <= A[i] <= 10^6

public class CountOfDivisors {
    public int[] solve(int[] A) {
        int n=A[0];
        for(int i=0;i<A.length;i++){
            n=Math.max(n,A[i]);
        }
        int ans[]=new int[n+1];
        for(int i=1;i<=n;i++){
            for(int j=i;j<=n;j=j+i){
                ans[j]=ans[j]+1;
            }
        }
        int ans1[]=new int[A.length];
        for(int i=0;i<A.length;i++){
            ans1[i]=ans[A[i]];
        }
        return ans1;
    }
    public static void main(String[] args) {
        CountOfDivisors I = new CountOfDivisors();
        int[] A=new int[28];

        A[0]=20;A[1]=39;A[2]=29;A[3]=51;A[4]=96;A[5]=32;A[6]=35;
        A[7]=50;A[8]=57;A[9]=7;A[10]=59;A[11]=51;A[12]=85;
        A[13]=55;A[14]=8;A[15]=26;A[16]=15;A[17]=4;A[18]=4;
        A[19]=18;A[20]=32;
        A[21]=49;A[22]=40;A[23]=46;
        A[24]=83;A[25]=77;A[26]=100;A[27]=92;

        System.out.println(I.solve(A ));
    }
}

