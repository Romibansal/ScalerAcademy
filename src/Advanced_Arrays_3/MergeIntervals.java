package Advanced_Arrays_3;

//Q=Problem Description
//        Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
//
//        You may assume that the intervals were initially sorted according to their start times.
//
//
//
//        Problem Constraints
//        0 <= |intervals| <= 10^5



import java.util.ArrayList;

public class MergeIntervals {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> ans=new ArrayList<Interval>();
        int i=0;
        int n=intervals.size();
        while(i<n && intervals.get(i).end< newInterval.start){
            ans.add(intervals.get(i));
            i++;
        }
        while(i<n && (intervals.get(i).start<=newInterval.end)){
            newInterval.start=Math.min(newInterval.start,intervals.get(i).start);
            newInterval.end=Math.max(newInterval.end,intervals.get(i).end);
            i++;
        }
        ans.add(newInterval);
        while(i<n){
            ans.add(intervals.get(i));
            i++;
        }

        return ans;
    }
    public static void main(String args []){
        MergeIntervals R1=new MergeIntervals();
        ArrayList<Interval> A=new ArrayList<Interval>();
        Interval i1=new Interval(1,2);
        Interval i2=new Interval(3,6);
        Interval i3=new Interval(8,10);
        A.add(i1);A.add(i2);
        System.out.println(R1.insert(A,i3));
    }
}
