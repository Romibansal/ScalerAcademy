package Carry_Forward;

public class EvenSubarrays {
    public String solve(int[] A) {
        int n = A.length;
        int i =0;
        if(n%2==0 && A[i]%2==0 && A[n-1]%2==0){
            return "YES";
        }
        return "NO";
    }
    public static void main(String[] args) {
        EvenSubarrays I = new EvenSubarrays();
        int []A=new int[4];
        A[0]=2;A[1]=4;A[2]=8;A[3]=6;
        System.out.println( I.solve(A));
    }
}
