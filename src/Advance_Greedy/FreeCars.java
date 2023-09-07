package Advance_Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;


//Q=Problem Description
//        Given two arrays, A and B of size N. A[i] represents the time by which you
//        can buy the ith car without paying any money.
//
//        B[i] represents the profit you can earn by buying the ith car.
//        It takes 1 minute to buy a car, so you can only buy the ith car when the current time <= A[i] - 1.
//
//        Your task is to find the maximum profit one can earn by buying cars considering that you can
//        only buy one car at a time.
//
//        NOTE:
//
//        You can start buying from time = 0.
//        Return your answer modulo 10^9 + 7.
//
//
//        Problem Constraints
//        1 <= N <= 10^5
//        1 <= A[i] <= 10^9
//        0 <= B[i] <= 10^9
//
//
//
//        Input Format

//        The first argument is an integer array A represents the deadline for buying the cars.
//        The second argument is an integer array B represents the profit obtained after buying the cars.
//
//
//
//        Output Format

//        Return an integer denoting the maximum profit you can earn.
//
//
//
//        Example Input

//        Input 1:
//
//        A = [1, 3, 2, 3, 3]
//        B = [5, 6, 1, 3, 9]

//        Input 2:
//
//        A = [3, 8, 7, 5]
//        B = [3, 1, 7, 19]
//
//
//        Example Output

//        Output 1:
//
//        20

//        Output 2:
//
//        30
//
//
//        Example Explanation

//        Explanation 1:
//
//        At time 0, buy car with profit 5.
//        At time 1, buy car with profit 6.
//        At time 2, buy car with profit 9.
//        At time = 3 or after , you can't buy any car, as there is no car with deadline >= 4.
//        So, total profit that one can earn is 20.

//        Explanation 2:
//
//        At time 0, buy car with profit 3.
//        At time 1, buy car with profit 1.
//        At time 2, buy car with profit 7.
//        At time 3, buy car with profit 19.
//        We are able to buy all cars within their deadline. So, total profit that one can earn is 30.


public class FreeCars {
    class pair{
        int time;
        int profit;
        pair(int t,int p){
            time=t;
            profit=p;
        }
    }
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        ArrayList<pair>p=new ArrayList<>();
        for(int i=0;i<A.size();i++){
            p.add(new pair(A.get(i),B.get(i)));
        }
        Collections.sort(p, new Comparator<pair>() {
            @Override
            public int compare(pair o1, pair o2) {
                return (o1.time-o2.time);
            }
        });
        int t=0;
        PriorityQueue<Integer>q=new PriorityQueue<>();
        for(int i=0;i<p.size();i++){
            if(p.get(i).time>t){
                q.add(p.get(i).profit);
                t++;
            }
            else{
                if(q.peek()<p.get(i).profit){
                    q.poll();
                    q.add(p.get(i).profit);
                }
            }

        }
        long sum=0;
        int mod=(int)Math.pow(10,9)+7;
        int size=q.size();
        for(int i=0;i<size;i++){
            sum=(sum%mod+q.poll())%mod;
        }
        int temp=(int)(sum%mod);
        return temp;
    }
    public static void main(String[] args) {
        FreeCars I = new FreeCars();

        ArrayList<Integer>A=new ArrayList<>();
        A.add(1);A.add(3);A.add(2);A.add(3);A.add(3);

        ArrayList<Integer>B=new ArrayList<>();
        B.add(5);B.add(6);B.add(1);B.add(3);B.add(9);
        System.out.println( I.solve(A,B));
    }
}





