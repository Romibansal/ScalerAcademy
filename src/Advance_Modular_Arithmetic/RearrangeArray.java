package Advance_Modular_Arithmetic;

import java.util.ArrayList;

//Q=Given an array A of size N. Rearrange the given array so that A[i] becomes A[A[i]] with O(1) extra space.
//
//        Constraints:
//        1 <= N <= 5×10^4
//        0 <= A[i] <= N - 1
//        The elements of A are distinct

public class RearrangeArray {
    public void arrange(ArrayList<Integer> A) {
        int mul = A.size();
        for(int i = 0; i < A.size(); i++){
            int val = mul * A.get(i);
            A.set(i,val);
        }
        for(int i = 0; i < A.size(); i++){
            int newidx = A.get(i)/mul;
            int newval = A.get(newidx)/mul + A.get(i);
            A.set(i,newval);
        }
        for(int i = 0; i < A.size(); i++){
            int val = A.get(i) % mul;
            A.set(i,val);
        }
    }
    public static void main(String[] args) {
        RearrangeArray I = new RearrangeArray();
        ArrayList<Integer>A=new ArrayList<>();
        A.add(4);A.add(0);A.add(1);A.add(2);A.add(3);
        I.arrange(A);
    }
}

