package Advance_Two_Pointers;

//Q=Problem Description
//        Given a sorted array of integers (not necessarily distinct) A and an integer B,
//        find and return how many pair of integers ( A[i], A[j] ) such that i != j have sum equal to B.
//
//        Since the number of such pairs can be very large, return number of such pairs modulo (109 + 7).
//
//
//
//        Problem Constraints
//        1 <= |A| <= 100000
//
//        1 <= A[i] <= 10^9
//
//        1 <= B <= 10^9

public class PairsWithGivenSumII {
    public int solve(int[] A, int B) {
        int mod=(int)Math.pow(10,9)+7;
        int i=0;
        int j=A.length-1;
        long count=0;
        while(i<j){
            if((A[i]+A[j])<B){
                i++;
            }
            else if((A[i]+A[j])>B){
                j--;
            }
            else{
                if(A[i]!=A[j]){
                    int a=1;
                    while(A[i]==A[i+1]){
                        a++;
                        i++;
                    }
                    i++;
                    int b=1;
                    while(A[j]==A[j-1]){
                        b++;
                        j--;
                    }
                    j--;
                    count=(count%mod+((a%mod*b%mod)%mod))%mod;
                }
                else{
                    long n=j-i+1;
                    long f=(n*(n-1))/2;
                    count=(count%mod+f%mod)%mod;
                    return (int)count;
                }
            }
        }
        return (int)count;
    }
    public static void main(String[] args) {
        PairsWithGivenSumII I = new PairsWithGivenSumII();
        int []A=new int[12];
        A[0]=1;A[1]=1;A[2]=1;A[3]=2;
        A[4]=2;A[5]=3;A[6]=4;A[7]=5;
        A[8]=6;A[9]=7;A[10]=8;A[11]=9;

        System.out.println(I.solve(A,2));
    }
}
