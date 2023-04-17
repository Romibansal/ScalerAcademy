package Prifix_Sum;


//Q=Given an array of integers A, find and return the product array of the same size where the
//        ith element of the product array will be equal to the product of all the elements divided by
//        the ith element of the array.
//
//        Note: It is always possible to form the product array with integer (32 bit) values.
//        Solve it without using the division operator.



public class ProductArrayPuzzle {
    public int[] solve(int[] A) {
        int n = A.length;
        int[] pref = new int[n];
        int[] suff = new int[n];
        pref[0] = A[0];
        for(int i = 1 ; i < n ; i++){
            pref[i] = pref[i - 1] * A[i];
        }
        suff[n - 1] = A[n - 1];
        for(int i = n - 2 ; i >= 0 ; i--){
            suff[i] = suff[i + 1] * A[i];
        }
        int[] ans = new int[n];
        for(int i = 0 ; i < n ; i++){
            if(i == 0){
                ans[i] = suff[1];
            }
            else if(i == n - 1){
                ans[i] = pref[n-2];
            }
            else{
                ans[i] = pref[i - 1] * suff[i + 1];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ProductArrayPuzzle I = new ProductArrayPuzzle();
        int[] A=new int[5];
        A[0]=1 ;
        A[1]=2;
        A[2]=3;
        A[3]=4;
        A[4]=5;
        System.out.println( I.solve(A));
    }
}




