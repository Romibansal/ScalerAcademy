package Advanced_Arrays_3;

//Q=Problem Description
//        Given a collection of intervals, merge all overlapping intervals.
//
//
//
//        Problem Constraints
//        1 <= Total number of intervals <= 100000.

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

 class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
}

public class MergeOverlappingIntervals {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval o1, Interval o2) {
                int x = o1.start;
                int y = o2.start;
                if(x <y)
                    return -1;
                else if(x>y)
                    return 1;
                else
                    return 0;
            }} );
        ArrayList<Interval> ans=new ArrayList<Interval>();
        int l=intervals.get(0).start;
        int r=intervals.get(0).end;
        for(int i=1;i<intervals.size();i++){
            if(intervals.get(i).start<=r){
                l=Math.min(intervals.get(i).start,l);
                r=Math.max(intervals.get(i).end,r);
            }
            else{
                Interval I=new Interval(l,r);
                ans.add(I);
                l=intervals.get(i).start;
                r=intervals.get(i).end;
            }
        }
        Interval I=new Interval(l,r);
        ans.add(I);
        return ans;
    }
    public static void main(String args []){
        MergeOverlappingIntervals R1=new MergeOverlappingIntervals();
        ArrayList<Interval> A=new ArrayList<Interval>();
        Interval i1=new Interval(1,3);
        Interval i2=new Interval(2,6);
        Interval i3=new Interval(8,10);
        Interval i4=new Interval(15,18);
        A.add(i1);A.add(i2);A.add(i3);A.add(i4);
        System.out.println(R1.merge(A));
    }
}
