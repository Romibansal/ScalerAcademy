package Advance_Arrays_3;

//Q=Problem Description
//        Given an unsorted integer array, A of size N. Find the first missing positive integer.
//
//        Note: Your algorithm should run in O(n) time and use constant space.
//
//
//
//        Problem Constraints
//        1 <= N <= 1000000
//
//        -10^9 <= A[i] <= 10^9



public class FirstMissingInteger {
    public int firstMissingPositive(int[] A) {
        int i=0;
        int n=A.length;
        while(i<n){
            if(A[i]==i+1){
                i++;
            }
            else if(A[i]>=1 && A[i]<=n){
                if(A[A[i]-1]==A[i]){
                    i++;
                    continue;
                }
                int temp=A[A[i]-1];
                int temp1=A[i];
                A[A[i]-1]=temp1;
                A[i]=temp;
            }
            else{
                i++;
            }
        }
        int ans=0;
        for(int j=0;j<A.length;j++){
            if((ans+1)!=A[j]){
                return ans+1;
            }
            ans=j+1;
        }
        return n+1;
    }
        public static void main(String args []){
            FirstMissingInteger R1=new FirstMissingInteger();
            int A[]=new int[4];
            A[0]=3; A[1]=4;
            A[2]=-1; A[3]=1;
            System.out.println(R1.firstMissingPositive(A));
        }
    }

