package Advance_Heaps_2_Questions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

//
//Q=Problem Description
//        Given an array of integers, A denoting a stream of integers. New arrays of integer B and C are formed.
//        Each time an integer is encountered in a stream, append it at the end of B and append the
//        median of array B at the C.
//
//        Find and return the array C.
//
//        NOTE:
//
//        If the number of elements is N in B and N is odd, then consider the median as B[N/2]
//        ( B must be in sorted order).
//        If the number of elements is N in B and N is even, then consider the median as B[N/2-1].
//        ( B must be in sorted order).
//
//
//        Problem Constraints
//        1 <= length of the array <= 100000
//        1 <= A[i] <= 10^9
//
//
//
//        Input Format

//        The only argument given is the integer array A.
//
//
//
//        Output Format

//        Return an integer array C, C[i] denotes the median of the first i elements.
//
//
//
//        Example Input

//        Input 1:
//
//        A = [1, 2, 5, 4, 3]

//        Input 2:
//
//        A = [5, 17, 100, 11]
//
//
//        Example Output

//        Output 1:
//
//        [1, 1, 2, 2, 3]

//        Output 2:
//
//        [5, 5, 17, 11]
//
//
//        Example Explanation

//        Explanation 1:
//
//        stream          median
//        [1]             1
//        [1, 2]          1
//        [1, 2, 5]       2
//        [1, 2, 5, 4]    2
//        [1, 2, 5, 4, 3] 3

//        Explanation 2:

//
//        stream          median
//        [5]              5
//        [5, 17]          5
//        [5, 17, 100]     17
//        [5, 17, 100, 11] 11

public class RunningMedian {
    void balance(PriorityQueue<Integer>min,PriorityQueue<Integer>max){
        while(Math.abs(min.size()-max.size())>1){
            if(min.size()> max.size()){
                max.add(min.poll());
            }
            else{
                min.add(max.poll());
            }
        }
    }
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        PriorityQueue<Integer> min=new PriorityQueue<>();
        PriorityQueue<Integer>max = new PriorityQueue<>(Comparator.reverseOrder());
        max.add(A.get(0));
        ArrayList<Integer>ans=new ArrayList<>();
        ans.add(A.get(0));
        for(int i=1;i<A.size();i++){
            if(max.peek()<A.get(i)){
                int t=A.get(i);
                min.add(t);
            }
            else{
                max.add(A.get(i));
            }
            int diff= Math.abs(min.size()- max.size());
            if(diff>1){
                balance(min,max);
            }
            if(min.size()>max.size()){
                ans.add(min.peek());
            }
            else{
                ans.add(max.peek());
            }
        }
        return ans;

    }
    public static void main(String[] args) {
        RunningMedian I = new RunningMedian();
        ArrayList<Integer>A=new ArrayList<>();
        A.add(1);A.add( 2);A.add( 5);A.add( 4);A.add( 3);

        System.out.println( I.solve(A));
    }
}


