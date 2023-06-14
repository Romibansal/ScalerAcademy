package Unique_Questions;

//Q=Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas.
//        The guards have gone and will come back in h hours.
//
//        Koko can decide her bananas-per-hour eating speed of k. Each hour,
//        she chooses some pile of bananas and eats k bananas from that pile.
//        If the pile has less than k bananas, she eats all of them instead and will not
//        eat any more bananas during this hour.
//
//        Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
//
//        Return the minimum integer k such that she can eat all the bananas within h hours.
//
//
//   Constraints:
//        1 <= piles.length <= 10^4
//        piles.length <= h <= 10^9
//        1 <= piles[i] <= 10^9

//
//        Example 1:
//
//        Input: piles = [3,6,7,11], h = 8
//        Output: 4

public class BinarySearch {
    int time(int[] A,long mid){
        int t =0;
        for(int i=0;i<A.length;i++){
           t=t+ (int)Math.ceil((double) A[i]/mid);

        }
        return t;
    }
    public int minEatingSpeed(int[] piles, int h) {
        long sum=0;
        long max=piles[0];
        for(int i=0;i<piles.length;i++){
            sum=sum+piles[i];
            max=Math.max(piles[i],max);
        }
        long min_speed=(sum/h);
        long max_speed=max;
        long ans=max;
        while(min_speed<=max_speed){
            long mid=min_speed+(max_speed-min_speed)/2;
            long T=time(piles,mid);
            if(T<=h){
                ans=mid;
                max_speed=mid-1;
            }
            else{
                min_speed=mid+1;
            }
        }
        return (int) ans;
    }
    public static void main(String[] args) {
        BinarySearch I = new BinarySearch();
        int[]A=new int[4];
        A[0]=3;A[1]=6;A[2]=7;A[3]=11;


        System.out.println(I.minEatingSpeed(A,8));
    }
}







