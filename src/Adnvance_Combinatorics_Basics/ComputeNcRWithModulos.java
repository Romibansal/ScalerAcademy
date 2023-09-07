package Adnvance_Combinatorics_Basics;
//
//Q=Problem Description
//        Given three integers A, B, and C, where A represents n, B represents r,
//        and C represents m, find and return the value of nCr % m where nCr % m = (n!/((n-r)!*r!))% m.
//
//        x! means factorial of x i.e. x! = 1 * 2 * 3... * x.
//
//
//
//        Problem Constraints
//        1 <= A * B <= 10^6
//        1 <= B <= A
//        1 <= C <= 10^6

public class ComputeNcRWithModulos {
    public int solve(int A, int B, int C) {
        int n=A;
        int r=B;
        if(r==0){
            return 1;
        }
        if(r==1){
            return n%C;
        }
        int [] ans=new int[n+1];
        for(int i=1;i<n+1;i++){
            int [] tempans=new int[n+1];
            tempans[0]=tempans[i]=1;
            if(i>1) {
                for (int j=1;j<=B;j++) {
                    long number=((ans[j-1])%C+(ans[j])%C)%C;
                    tempans[j]=(int) number;
                }
            }
            ans = tempans;
        }
        return ans[r];
    }
    public static void main(String[] args) {
        ComputeNcRWithModulos I = new ComputeNcRWithModulos();
        System.out.println(I.solve(25, 6,48713));
    }
}


