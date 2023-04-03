package Hashing_2;

import java.util.HashMap;

//
//Q=Find the total number of subarrays having sum equals to B.
//
//
//        Input Format
//
//        The first argument given is the integer array A.
//        The second argument given is integer B.
//        Output Format
//
//        Return the total number of subarrays having sum equals to B.
//        Constraints
//
//        1 <= length of the array <= 50000
//        -1000 <= A[i] <= 1000

public class SubarraySumEqualsK {
    public int solve(int[] A, int B) {
        long ps[]=new long[A.length];
        int count=0;
        ps[0]=A[0];
        if(ps[0]==B){
            count++;
        }
        for(int i=1;i<A.length;i++){
            ps[i]=A[i]+ps[i-1];
            if(ps[i]==B){
                count++;
            }
        }
        // HashMap<Long,Integer> hm=new HashMap<>();
        // for(int j=0;j<ps.length;j++){
        //     long number=B+ps[j];
        //     if(hm.containsKey(number)){
        //         count=count+hm.get(number);
        //         int v=hm.get(number);
        //         hm.put(number,v);
        //     }
        //     else{
        //         if(hm.containsKey(ps[j])){
        //             int f=hm.get(ps[j]);
        //             f=f+1;
        //             hm.put(ps[j],f);
        //         }
        //         else {
        //             hm.put(ps[j], 1);
        //         }
        //     }
        // }
        HashMap<Long, Integer> hm1 = new HashMap<>();
        for (int h = 0; h < ps.length; h++) {
            long number1 = ps[h] - B;
            if (hm1.containsKey(number1)) {
                count = count + hm1.get(number1);
            }
            if (hm1.containsKey(ps[h])) {
                int f = hm1.get(ps[h]);
                f = f + 1;
                hm1.put(ps[h], f);
            } else {
                hm1.put(ps[h], 1);
            }

        }
        return count;
    }
    public static void main(String args[]) {
        SubarraySumEqualsK N1 = new SubarraySumEqualsK();
        int[] A ={-20, -13, 4, 2, 18, -17, 17 };

        System.out.println(N1.solve(A, 11));
    }
}
