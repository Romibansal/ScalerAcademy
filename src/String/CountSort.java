package String;


//Q=Problem Description
//        Given an array A. Sort this array using Count Sort Algorithm and return the sorted array.
//
//
//        Problem Constraints
//        1 <= |A| <= 10^5
//        1 <= A[i] <= 10^5

public class CountSort {
    public int[] solve(int[] A) {
        int n=A.length;
        int mx=-1;
        for (int i=0;i<n;i++) {
            mx=Math.max(mx,A[i]);
        }
        int[] freq=new int[mx + 1];
        for (int i=0;i<n;i++) {
            freq[A[i]]=freq[A[i]]+1;
        }
        int k=0;
        for (int i=0;i<=mx;i++) {
            for (int j=0;j<freq[i];j++) {
                A[k]=i;
                k++;
            }
        }
        return A;
    }

    public static void main(String args[]) {
        CountSort N1 = new CountSort();
        int A[]=new int[3];
         A[0]=1;A[1]=3;A[2]=1;
        System.out.println(N1.solve(A));
    }
}
