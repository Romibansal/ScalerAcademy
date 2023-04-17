package Unique_Questions;

//Q=John and Jake love to play with arrays. John has recently found an array A of size N. He asks Jake Q queries, which in each
//query he gives him a range from L to R and asks him to find the count of beautiful numbers in subarray A[L],A[L+1],....A[R].
//Beautiful Numbers are defined as the numbers that are prime . Since Jake doesnt know about prime numbers he asks for your help
//Solve this problem for him.
//
//Problem Constraints
//1<=N<=10^4
//1<=A[i]<=10^4
//1<=L<=R<=N

public class RangePrimeC1 {
    public int[] solve(int[] A, int[][] B) {
        int n=0;
        if(A[0]==1){
            A[0]=0;
        }
        else {
            for(int k=2;k<A[0];k++){
                if(A[0]%k==0){
                    n=1;
                    break;
                }
            }
            if(n==0){
                A[0]=1;
            }
            else{
                A[0]=0;
            }

        }
        for(int i=1;i<A.length;i++){
            int flag =0;
            if(A[i]==1){
                flag=1;
            }
            for(int j=2;j<A[i];j++){
                if(A[i]%j==0){
                    flag=1;
                    break;
                }
            }
            if(flag==0){
                A[i]=A[i-1]+1;
            }
            else{
                A[i]=A[i-1];
            }
        }
        int a[]=new int[B.length];
        for(int t=0;t<B.length;t++){
            int l=B[t][0]-1;
            int r=B[t][1]-1;
            if(l==0){
                a[t]=A[r];
            }
            else{
                a[t]=A[r]-A[l-1];
            }

        }
        return a;
    }
    public static void main(String args []){
        RangePrimeC1 N1=new RangePrimeC1();
        int []A=new int[4];
        int [][]Q=new int[3][3];
        Q[0][0]=2;Q[0][1]=3;
        Q[1][0]=3;Q[1][1]=4;
        Q[2][0]=1;Q[2][1]=4;
        A[0]=1;A[1]=4;A[2]=5;A[3]=2;
        System.out.println( N1.solve(A,Q));
    }
}

