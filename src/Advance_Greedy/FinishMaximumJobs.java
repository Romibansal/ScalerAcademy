package Advance_Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
//
//Q=Problem Description
//        There are N jobs to be done, but you can do only one job at a time.
//
//        Given an array A denoting the start time of the jobs and an array B denoting the finish time of the jobs.
//
//        Your aim is to select jobs in such a way so that you can finish the maximum number of jobs.
//
//        Return the maximum number of jobs you can finish.
//
//
//
//        Problem Constraints

//        1 <= N <= 10^5
//
//        1 <= A[i] < B[i] <= 10^9
//
//
//
//        Input Format
//        The first argument is an integer array A of size N, denoting the start time of the jobs.
//        The second argument is an integer array B of size N, denoting the finish time of the jobs.
//
//
//
//        Output Format
//        Return an integer denoting the maximum number of jobs you can finish.
//
//
//
//        Example Input
//        Input 1:
//
//        A = [1, 5, 7, 1]
//        B = [7, 8, 8, 8]
//        Input 2:
//
//        A = [3, 2, 6]
//        B = [9, 8, 9]
//
//
//        Example Output
//        Output 1:
//
//        2
//        Output 2:
//
//        1
//
//
//        Example Explanation
//        Explanation 1:
//
//        We can finish the job in the period of time: (1, 7) and (7, 8).
//        Explanation 2:
//
//        Since all three jobs collide with each other. We can do only 1 job.

public class FinishMaximumJobs {
    class pair{
        int start;
        int end;
        pair(int s,int e){
            start=s;
            end=e;
        }
    }
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        ArrayList<pair> p=new ArrayList<>();
        for(int i=0;i<A.size();i++){
            p.add(new pair(A.get(i),B.get(i)));
        }
        Collections.sort(p, new Comparator<pair>() {
            public int compare(pair o1, pair o2) {
                return (o1.end-o2.end);
            }
        });
        int ans=1;
        int last_end_time=p.get(0).end;
        for(int i=1;i<p.size();i++){
            if(p.get(i).start>=last_end_time){
                ans++;
                last_end_time=p.get(i).end;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        FinishMaximumJobs I = new FinishMaximumJobs();
        ArrayList<Integer>A=new ArrayList<>();
        A.add(3);A.add( 2);A.add(6);

        ArrayList<Integer>B=new ArrayList<>();
        B.add(9);B.add( 8);B.add( 9);

        System.out.println( I.solve(A,B));
    }
}



