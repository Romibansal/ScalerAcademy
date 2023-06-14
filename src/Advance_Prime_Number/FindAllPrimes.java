package Advance_Prime_Number;

//Q=Problem Description
//        Given an integer A. Find the list of all prime numbers in the range [1, A].
//
//
//        Problem Constraints
//        1 <= A <= 10^6


import java.util.ArrayList;

public class FindAllPrimes {
    public int[] solve(int A) {
        int a[]=new int[A+1];
        a[0]=a[1]=1;
        int n=A+1;
        for(int i=2;i<Math.sqrt(n);i++){
            if(a[i]==0){
                for(int j=(i*i);j<n;j=(j+i)){
                    a[j]=1;
                }
            }
        }
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<a.length;i++){
            if(a[i]==0){
                ans.add(i);
            }
        }
        int b[]=new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            b[i]=ans.get(i);
        }
        return b;
    }
    public static void main(String[] args) {
        FindAllPrimes I = new FindAllPrimes();
        System.out.println(I.solve(12 ));
    }
}


