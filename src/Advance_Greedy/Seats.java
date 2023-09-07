package Advance_Greedy;

import java.util.ArrayList;

//Q=Problem Description
//        There is a row of seats represented by string A. Assume that it contains N seats adjacent to each other.
//        There is a group of people who are already seated in that row randomly. i.e. some are sitting together &
//        some are scattered.
//
//        An occupied seat is marked with a character 'x' and an unoccupied seat is marked with a dot ('.')
//
//        Now your target is to make the whole group sit together i.e. next to each other,
//        without having any vacant seat between them in such a way that the total number
//        of hops or jumps to move them should be minimum.
//
//        In one jump a person can move to the adjacent seat (if available).
//
//        NOTE: 1. Return your answer modulo 10^7 + 3.
//
//
//
//        Problem Constraints

//        1 <= N <= 1000000

//        A[i] = 'x' or '.'
//
//
//
//        Input Format

//        The first and only argument is a string A of size N.
//
//
//
//        Output Format

//        Return an integer denoting the minimum number of jumps required.
//
//
//
//        Example Input

//        Input 1:
//
//        A = "....x..xx...x.."

//        Input 2:
//
//        A = "....xxx"
//
//
//        Example Output

//        Output 1:
//
//        5

//        Output 2:
//
//        0
//
//
//        Example Explanation

//        Explanation 1:
//
//        Here is the row having 15 seats represented by the String (0, 1, 2, 3, ......... , 14)
//        . . . . x . . x x . . . x . .
//        Now to make them sit together one of approaches is -
//        . . . . . . x x x x . . . . .
//        Steps To achieve this:
//        1) Move the person sitting at 4th index to 6th index: Number of jumps by him =   (6 - 4) = 2
//        2) Bring the person sitting at 12th index to 9th index: Number of jumps by him = (12 - 9) = 3
//        So, total number of jumps made: 2 + 3 = 5 which is the minimum possible.
//
//        If we other ways to make them sit together but the number of jumps will exceed
//        5 and that will not be minimum.
//
//        Explanation 2:
//
//        They are already together. So, the cost is zero.

public class Seats {
    public int seats(String A) {
        int mod=(int)Math.pow(10,7)+3;
        ArrayList<Integer>pos=new ArrayList<>();
        long ans=0;
        for(int i=0;i<A.length();i++) {
            if (A.charAt(i) == 'x') {
                pos.add(i);
            }
        }
            int mid=pos.size()/2;
            int r=mid+1;
            int k=1;

            while(r< pos.size()) {
                int temp=(pos.get(r)-(pos.get(mid)+k));
                ans=(ans%mod+temp)%mod;
                r++;k++;
            }
            k=1;
            int l=mid-1;
            while(l>=0){
                int temp=(pos.get(mid)-k)-pos.get(l);
                ans=(ans%mod+temp)%mod;
                l--;k++;
            }

        return (int)(ans%mod);
    }
    public static void main(String[] args) {
        Seats I = new Seats();
        System.out.println( I.seats("....x..xx...x.."));
    }
}
